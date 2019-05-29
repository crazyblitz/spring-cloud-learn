Spring Cloud系列学习

spring cloud版本:Edgware.SR5

spring版本:4.3.13.RELEASE

spring boot admin版本:1.5.6

jasypt加密版本:1.18

项目模块介绍

1:eureka-registry

服务注册中心

实现对服务事件监控,相关类

- EurekaInstanceCanceledEvent:服务下线事件
- EurekaInstanceRegisteredEvent:服务注册事件
- EurekaInstanceRenewedEvent:服务续约事件
- EurekaServerStartedEvent:服务启动事件
- EurekaRegistryAvailableEvent:服务注册中心启动事件

2:eureka-server

服务提供方

解决使用${random.int[min,max]}造成spring tomcat启动端口和eureka启动端口不一致情况。

参照RandomValuePropertySource实现。由于该类每调用一次,便生成一次随机数。

只需要在实现的时候每次调用，只生成一个随机数就行。

相关类:

- com.ley.springcloud.provider.utils.RandomServerPort
- com.ley.springcloud.provider.utils.RandomServerPortPropertySource
- com.ley.springcloud.provider.listener.RandomServerPortApplicationEnvironmentPreparedEventListener

        /**
         * @see RandomServerPortApplicationEnvironmentPreparedEventListener
         **/
        private static void initSpringApplication(String[] args) {
            SpringApplication application = new SpringApplication(EurekaProviderApplication.class);
            application.addListeners(new RandomServerPortApplicationEnvironmentPreparedEventListener());
            application.run(args);
        }

3:eureka-client

服务消费方，使用客户端负载均衡Ribbon

4:eureka-client-ribbon

服务消费方，使用客户端负载均衡Ribbon，并进行Ribbon配置。例如超时，负载规则配置。

    #服务名
    eureka-provider:
      ribbon:
        #配置Ribbon负载均衡规则:IRule
        NFLoadBalancerRuleClassName: com.ley.springcloud.client.rule.MyRoundRobinRule
        #配置Ribbon实例检查策略:IPing
        NFLoadBalancerPingClassName:
        #配置负载均衡器
        NFLoadBalancerClassName:
        #配置服务实例清单维护机制
        NIWSServerListClassName:
        #配置服务清单过滤机制
        NIWSServerListFilterClassName:
        
    #服务名    
    eureka-provider:
      ribbon:
        ConnectTimeout: 250 #单位ms,请求连接超时时间
        ReadTimeout: 1000 #单位ms,请求处理的超时时间
        OkToRetryOnAllOperations: true #对所有操作请求都进行重试
        MaxAutoRetriesNextServer: 2 #切换实例的重试次数
        MaxAutoRetries: 1 #对当前实例的重试次数

5:eureka-client-feign

使用声明式服务调用feign

6:eureka-client-ribbon-hystrix

在ribbon中使用断路器hystrix

7:eureka-client-feign-hystrix

在feign中使用断路器hystrix

8:api-gateway

单独使用api网关zuul

9:api-geteway-eureka

使用zuul整合eureka,利用服务名调用

探究zuul filter的执行过程:pre,route,post,error。

10:spring-cloud-config

子模块:config-server:分布式配置中心服务端

子模块:config-client:分布式配置中心客户端

11:spring-cloud-bus

使用spring cloud bus来改造config-server。

12：spring-cloud-stream

分布式消息

13:spring-cloud-sleuth

分布式链路跟踪

子模块:trace1:服务链路1

子模块:trace2:服务链路2

子模块:zipkin-server:zipkin服务端

子模块:zipkin-server-stream:将zipkin通过消息中间件rabbitmq收集

14:spring-cloud-endpoint

监控端点和健康自定义模块

15:springboot-admin

子模块:admin-server:spring boot admin服务端

子模块:admin-client:spring boot admin客户端

16:springcloud-hystrix-dashboard

hystrix监控面板：集群(Turbine)或者单个(HystrixDashboard)


