package com.ley.springcloud.provider.utils;


import org.apache.commons.lang3.RandomUtils;

/**
 * 随机生成一个端口,并只生成一次
 */
public class RandomServerPort {

    /**
     * server port
     **/
    private int serverPort;

    private final int start = 0;

    private final int end = 65535;


    private final Object lock = new Object();

    public int nextValue(int start) {
        return nextValue(start, end);
    }

    public int nextValue(int start, int end) {
        start = start < this.start ? this.start : start;
        end = end > this.end ? this.end : end;

        //双重加锁
        //先判断serverPort==0
        if (serverPort == 0) {
            synchronized (lock) {
                if (serverPort == 0) {
                    //等于0,则生成随机数
                    serverPort = RandomUtils.nextInt(start, end);
                }
            }
        }
        return serverPort;
    }


}
