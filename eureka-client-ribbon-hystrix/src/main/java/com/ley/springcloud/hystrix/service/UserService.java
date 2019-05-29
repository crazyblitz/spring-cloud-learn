package com.ley.springcloud.hystrix.service;


import com.ley.springcloud.hystrix.bean.User;
import com.ley.springcloud.hystrix.utils.HystrixCommandConfigConstants;
import com.ley.springcloud.hystrix.utils.ServiceInstanceConstants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;


@Service
@Slf4j
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 同步执行
     **/
    @HystrixCommand
    public User getUserById(Integer id) {
        log.info("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                "/users/{}", id);
        return restTemplate.getForObject("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                "/users/{1}", User.class, id);
    }


    /**
     * 异步执行
     **/
    @HystrixCommand
    public Future<User> getUserByIdAsync(Integer id) {
        log.info("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                "/users/{}", id);
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                        "/users/{1}", User.class, id);
            }
        };
    }



    /**
     * 响应式编程,RxJava
     * <br/>
     * 通过ObservableExecutionMode.LAZY必须有订阅者,才能够发布,否则进行等待
     * <br/>
     * 通过observableExecutionMode = ObservableExecutionMode.EAGER不管有没有订阅者都会发布
     **/
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER)
    public Observable<User> getUserByIdReactive(Integer id) {
        //发布事件
        return Observable.create(observe -> {
            try {
                //必须观察者通过Subscribe订阅
                if (!observe.isUnsubscribed()) {
                    User user = restTemplate.getForObject("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                            "/users/{1}", User.class, id);
                    observe.onNext(user);
                    log.info("user{}", user);
                    //完成事件
                    observe.onCompleted();
                }
            } catch (Exception e) {
                observe.onError(e.getCause());
            }
        });
    }


    /**
     * 同步执行
     * <br/>
     * 使用注解,进行分组,代表命令名称,分组,线程池划分
     * <br/>
     * 设置请求缓存,Hystrix会将该结果放入到请求缓存中,缓存Key值会使用所有参数
     * <br/>
     * 定义缓存key,为请求命令指定具体的缓存key生成规则
     * <br/>
     * 可以使用cacheKeyMethod指定具体的生成函数,也可以使用@CacheKey注解
     * 在方法参数中指定用于组装缓存Key的元素.其中@CacheKey可以指定方法参数内部
     * 属性作为缓存Key
     **/
    @CacheResult
    @HystrixCommand(commandKey = "getUserByIdAndGroup", threadPoolKey = "userThread", threadPoolProperties = {
            @HystrixProperty(name = HystrixCommandConfigConstants.ThreadPoolConstants.CORE_SIZE, value = "20"),
            @HystrixProperty(name = HystrixCommandConfigConstants.ThreadPoolConstants.MAXIMUM_SIZE, value = "20")},
            commandProperties = {@HystrixProperty(name = HystrixCommandConfigConstants.RequestContextConstants.REQUEST_LOG_ENABLED,value = "true")})
    public User getUserByIdAndGroup(@CacheKey Integer id) {
        log.info("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                "/users/{}", id);
        return restTemplate.getForObject("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                "/users/{1}", User.class, id);
    }


    @CacheRemove(commandKey = "getUserByIdAndGroup")
    @HystrixCommand
    public boolean updateUser(@CacheKey("id") User user) {
        return restTemplate.postForObject("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                "/users", user, Boolean.class);
    }




    /**
     * 请求合并器
     **/
    @HystrixCollapser(batchMethod = "findAll", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100")
    })
    public User find(Integer id) {
        return null;
    }


    @HystrixCommand
    public List<User> findAll(List<Integer> ids) {
        String str = StringUtils.join(ids, ",");
        log.info("ids: {},size: {}", ids, ids.size());
        User[] users = restTemplate.getForObject("http://" + ServiceInstanceConstants.SERVICE_INSTANCE_EUREKA_PROVIDER +
                "/users1/{1}", User[].class, str);
        return Arrays.asList(users);
    }


    protected String getUserByIdFallback() {
        return "error";
    }

}
