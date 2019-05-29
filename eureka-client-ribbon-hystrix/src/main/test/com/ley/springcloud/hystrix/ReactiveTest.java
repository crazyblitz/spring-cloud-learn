package com.ley.springcloud.hystrix;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscriber;

/**
 * 响应式编程测试
 **/
@Slf4j
public class ReactiveTest {


    public static void main(String[] args) {
        //创建发布者
        Observable<String> observable = Observable.create(subscriber -> {
            subscriber.onNext("Hello RxJava");
            subscriber.onNext("I am liu en yuan");
            subscriber.onCompleted();
        });

        //创建订阅者
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                log.info("subscribe completed");
            }

            @Override
            public void onError(Throwable e) {
                log.error("exception: {}",e.getMessage());
            }

            @Override
            public void onNext(String s) {
                log.info("subscribe: {}",s);
            }
        };


        //订阅,通过Observable.subscribe触发事件
       if(!subscriber.isUnsubscribed()){
           observable.subscribe(subscriber);
       }
    }
}
