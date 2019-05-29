package com.ley.springcloud.hystrix.utils;

import com.netflix.hystrix.HystrixCommand;

/**
 * HystrixCommand配置常量Key
 *
 * @see com.netflix.hystrix.HystrixCommandProperties
 * @see com.netflix.hystrix.HystrixThreadPoolProperties
 * @see com.netflix.hystrix.HystrixCollapserProperties
 **/
public final class HystrixCommandConfigConstants {


    //Command properties is use to control HystrixCommand

    /**
     * <b>execution 配置控制HystrixCommand.run的执行</b>
     *
     * @see HystrixCommand#run()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand#commandProperties()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
     **/
    public static class ExecutionIsolationConstants {

        /**
         * 配置HystrixCommand.run的执行策略: THREAD|SEMAPHORE
         **/
        public static final String EXECUTION_ISOLATION_STRATEGY = "execution.isolation.strategy";


        /**
         * 配置HystrixCommand执行超时时间: 默认1000ms
         **/
        public static final String EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS = "execution.isolation.thread.timeoutInMilliseconds";


        /**
         * 配置HystrixCommand.run执行是否启用超时时间: 默认为true
         **/
        public static final String EXECUTION_TIMEOUT_ENABLED = "execution.timeout.enabled";


        /**
         * 配置HystrixCommand.run()执行被取消的时候是否将它中断: 默认为true
         **/
        public static final String EXECUTION_ISOLATION_THREAD_INTERRUPT_ON_TIMEOUT = "execution.isolation.thread.interruptOnTimeout";


        /**
         * 当HystrixCommand的隔离策略使用信号量的时候,该属性用来配置信号量的大小(并发请求数),<br/>
         * 当最大并发请求数达到该设置值,后续的请求将被拒绝: 默认10
         **/
        public static final String EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS = "execution.isolation.semaphore.maxConcurrentRequests";
    }


    /**
     * fallback 控制HystrixCommand.getFallback()执行对于线程池或者信号量执行策略都生效
     *
     * @see HystrixCommand#getFallback()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand#commandProperties()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
     **/
    public static class FallbackConstants {

        /**
         * 配置从调用线程中允许HystrixCommand.getFallback()方法的最大执行请求数<br/>
         * 当达到最大并发请求数时,后续请求将被拒绝并抛出异常: 默认10
         **/
        public static final String FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS = "fallback.isolation.semaphore.maxConcurrentRequests";


        /**
         * 配置服务降级策略是否启用: 默认true
         **/
        public static final String FALLBACK_ENABLED = "fallback.enabled";
    }


    /**
     * circuitBreaker配置 断路器用来控制HystrixCircuitBreaker
     *
     * @see com.netflix.hystrix.HystrixCircuitBreaker
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand#commandProperties()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
     **/
    public static class CircuitBreakerConstants {

        /**
         * 配置当服务请求命令失败时,是否使用断路器来跟踪其健康指标和熔断请求: 默认true
         **/
        public static final String CIRCUIT_BREAKER_ENABLED = "circuitBreaker.enabled";


        /**
         * 配置在滚动时间窗中,断路器的最小请求数: 默认20
         **/
        public static final String CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD = "circuitBreaker.requestVolumeThreshold";


        /**
         * 配置当断路器打开之后的休眠时间窗,休眠时间窗结束之后,会将断路器设置为"半开",<br/>
         * 尝试熔断的请求命令,如果依然失败就将断路器继续设置为"打开"状态,如果成功,就设置"关闭"<br/>
         * 默认5000ms
         **/
        public static final String CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS = "circuitBreaker.sleepWindowInMilliseconds";


        /**
         * 配置断路器打开的错误百分比条件: 默认50%<br/>
         * 当在滚动时间窗中,如果请求数量超过circuitBreaker.errorThresholdPercentage前提下<br/>
         * 如果错误请求数的百分比超过50%,就把断路器设置为"打开"状态
         **/
        public static final String CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE = "circuitBreaker.errorThresholdPercentage";


        /**
         * 如果该属性为true,断路器强制进入"打开"状态,拒绝所有请求,优于circuitBreaker.forceClosed.<br/>
         * 默认为false
         **/
        public static final String CIRCUIT_BREAKER_FORCE_OPEN = "circuitBreaker.forceOpen";


        /**
         * 如果该值设置为true,断路器强制进入"关闭"状态,它会接受所有请求,默认为true<br/>
         * 当配置了circuitBreaker.forceOpen,该属性配置无效
         **/
        public static final String CIRCUIT_BREAKER_FORCE_CLOSED = "circuitBreaker.forceClosed";
    }


    /**
     * metrics配置 主要度量HystrixCommand 和 HystrixObservableCommand 的执行指标信息
     *
     * @see HystrixCommand#run()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand#commandProperties()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
     **/
    public static class MetricsConstants {

        /**
         * 配置滚动时间窗的长度,单位毫秒: 默认 10000ms(10s).<br/>
         * 该时间用于断路器判断健康度时需要手机信息的持续时间.<br/>
         * 断路器在收集指标时会根据设置的时间窗拆分为多个"桶"来累计各度量值,<br/>
         * 每个"桶"记录了一段时间内的采集指标.<br/>
         * 该属性从Hystrix 1.4.12版本开始,只有在应用初始化的时候生效,<br/>
         * 通过动态刷新配置不会产生效果.避免出现运行期监测数据丢失的情况
         **/
        public static final String METRICS_ROLLING_STATS_TIME_IN_MILLISECONDS = "metrics.rollingStats.timeInMilliseconds";

        /**
         * 配置滚动时间窗统计信息时划分"桶"的数量: 默认10<br/>
         * metrics.rollingStats.timeInMilliseconds参数设置必须能被该参数整除,否则抛出异常.<br/>
         * 该属性从Hystrix 1.4.12版本开始,只有在应用初始化的时候生效,<br/>
         * 通过动态刷新配置不会产生效果.避免出现运行期监测数据丢失的情况.
         **/
        public static final String METRICS_ROLLING_STATS_NUM_BUCKETS = "metrics.rollingStats.numBuckets";

        /**
         * 配置对命令执行是否使用百分位数来跟踪和计算: 默认true<br/>
         * 如果配置<b>false</b>,所有概要统计均返回-1
         **/
        public static final String METRICS_ROLLING_PERCENTILE_ENABLED = "metrics.rollingPercentile.enabled";

        /**
         * 配置百分位统计的滚动窗口的持续时间: 默认:60000ms(60s)<br/>
         * 该属性从Hystrix 1.4.12版本开始,只有在应用初始化的时候生效,<br/>
         * 通过动态刷新配置不会产生效果.避免出现运行期监测数据丢失的情况.
         **/
        public static final String METRICS_ROLLING_PERCENTILE_TIME_IN_MILLISECONDS = "metrics.rollingPercentile.timeInMilliseconds";

        /**
         * 配置百分位统计滚动窗口中使用"桶"的数量: 默认6<br/>
         * metrics.rollingPercentile.timeInMilliseconds必须能被该参数整除,否则抛出异常<br/>
         * 该属性从Hystrix 1.4.12版本开始,只有在应用初始化的时候生效,<br/>
         * 通过动态刷新配置不会产生效果.避免出现运行期监测数据丢失的情况.
         **/
        public static final String METRICS_ROLLING_PERCENTILE_NUM_BUCKETS = "metrics.rollingPercentile.numBuckets";


        /**
         * 配置在执行过程中每个"桶"中保留的最大执行次数: 默认100<br/>
         * 如果在滚动时间窗内超过该设定值的执行次数,就从最初的位置开始重写<br/>
         * 增加该值的大小会增加内存量的消耗,并增加排序百分位数所需的计算时间<br/>
         * 该属性从Hystrix 1.4.12版本开始,只有在应用初始化的时候生效,<br/>
         * 通过动态刷新配置不会产生效果.避免出现运行期监测数据丢失的情况.
         **/
        public static final String METRICS_ROLLING_PERCENTILE_BUCKET_SIZE = "metrics.rollingPercentile.bucketSize";

        /**
         * 配置采集影响断路器状态的健康快照(请求的成功,错误百分比)的间隔等待时间: 默认500ms
         **/
        public static final String METRICS_HEALTH_SNAPSHOT_INTERVAL_IN_MILLISECONDS = "metrics.healthSnapshot.intervalInMilliseconds";
    }


    /**
     * hystrix request context 配置
     *
     * @see com.netflix.hystrix.strategy.concurrency.HystrixRequestContext
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand#commandProperties()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
     **/
    public static class RequestContextConstants {

        /**
         * 配置是否开启请求缓存: 默认为true
         *
         * @see com.netflix.hystrix.HystrixRequestCache
         **/
        public static final String REQUEST_CACHE_ENABLED = "requestCache.enabled";

        /**
         * 配置HystrixCommand的执行和事件是否打印日志到HystrixRequestLog: 默认为true
         *
         * @see com.netflix.hystrix.HystrixRequestLog
         **/
        public static final String REQUEST_LOG_ENABLED = "requestLog.enabled";
    }


    /**
     * hystrix collapser constants
     *
     * @see com.netflix.hystrix.HystrixCollapser
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
     **/
    public static class CollapserConstants {

        /**
         * 配置一次请求合并并批处理中允许最大请求数: 默认Integer.MAX_VALUE
         **/
        public static final String MAX_REQUESTS_IN_BATCH = "maxRequestsInBatch";

        /**
         * 配置批处理过程中每个命令延迟时间: 默认10ms
         **/
        public static final String TIMER_DELAY_IN_MILLISECONDS = "timerDelayInMilliseconds";

        /**
         * 配置批处理过程中是否开启请求缓存
         **/
        public static final String REQUEST_CACHE_ENABLED = "requestCache.enabled";
    }


    /**
     * hystrix command thread pool constants
     *
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand#threadPoolProperties()
     * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
     **/
    public static class ThreadPoolConstants {

        /**
         * 配置命令线程池的核心线程数,命令执行最大并发量: 默认10
         **/
        public static final String CORE_SIZE = "coreSize";

        /**
         * maximum size of thread pool: 默认10
         **/
        public static final String MAXIMUM_SIZE = "maximumSize";

        /**
         * 配置线程池的最大队列大小: 默认-1<br/>
         * 配置-1,线程池使用{@link java.util.concurrent.SynchronousQueue}实现的队列,<br/>
         * 否则使用{@link java.util.concurrent.LinkedBlockingQueue}
         **/
        public static final String MAXQUEUE_SIZE = "maxQueueSize";

        /**
         * 配置队列拒绝阈值.配置该参数,即使队列没有达到最大值也拒绝请求: 默认5<br/>
         * 当maxQueueSize=-1,该配置不生效
         **/
        public static final String QUEUE_SIZE_REJECTION_THRESHOLD = "queueSizeRejectionThreshold";

        /**
         * minutes to keep a thread alive: 默认1分钟(60s)
         **/
        public static final String KEEP_ALIVE_TIMEMINUTES = "keepAliveTimeMinutes";

        /**
         * should the maximumSize config value get read and used in configuring the threadPool
         * turning this on should be a conscious decision by the user, so we default it to false: 默认false
         **/
        public static final String ALLOW_MAXIMUM_SIZE_TO_DIVERGE_FROM_CORE_SIZE = "allowMaximumSizeToDivergeFromCoreSize";

        /**
         * 配置滚动时间窗的床都,单位ms: 默认10000(10s)<br/>
         * 该滚动时间窗的长度用于线程池的指标度量,分成多个"桶"统计指标
         **/
        public static final String METRICS_ROLLING_STATS_TIME_IN_MILLISECONDS = "metrics.rollingStats.timeInMilliseconds";

        /**
         * 配置滚动时间窗被划分成"桶"的数量: 默认10<br/>
         * metrics.rollingStats.timeInMilliseconds必须能被该参数整除,不然抛出异常
         **/
        public static final String METRICS_ROLLINGSTATS_NUMBUCKETS = "metrics.rollingStats.numBuckets";
    }
}
