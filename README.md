# spring-cloud-learn

#### 项目介绍
**spring cloud learning and this spring cloud learning contains eureka,ribbon,hystrix,feign,zuul,spring cloud config,
spring cloud bus,spring cloud stream,spring cloud sleuth.这个项目是一个学习Spring Cloud微服务的很好的项目**

#### 软件架构
软件架构说明



#### 模块说明

##### 1:eureka-registry
>Eureka注册中心

##### 2:eureka-server
>Eureka提供端

##### 3:eureka-client
>Eureka消费端

##### 4:eureka-client-ribbon
>Eureka消费端以及Ribbon客户端负载均衡

##### 5:eureka-client-ribbon-hystrix
>Eureka消费端以及Ribbon客户端负载均衡以及断路器处理


##### 6:eureka-feign
>Eureka feign客户端改造,使用Feign继承特性,提高代码的复用性.
>包含eureka-feign-api,eureka-feign-client,eureka-feign-server
>三个模块.

##### 7:eureka-client-feign
>Eureka客户端声明式服务调用

##### 8:eureka-client-feign-hystrix
>Eureka客户端声明式服务调用以及断路器处理

##### 9:api-gateway
>Zuul网关

##### 10:api-gateway-eureka
>Zuul网关整合Eureka

##### 11:api-gateway-swagger
>Zuul网关整合swagger
>包含api-gateway-swagger-server和service-a-swagger
>和service-b-swagger三个模块

##### 12:spring-cloud-config
>Spring Cloud Config实现分布式配置
>包含config-server和config-client两个模块

##### 13:spring-cloud-bus
>消息总线

##### 14:spring-cloud-stream
>消息驱动微服务

##### 15:spring-cloud-sleuth
>分布式服务跟踪
>包含trace-1,trace-2,zipkin-server,zipkin-server-stream
>四个模块



