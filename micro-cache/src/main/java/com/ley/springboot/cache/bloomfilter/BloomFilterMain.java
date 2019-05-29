package com.ley.springboot.cache.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class BloomFilterMain {

    public static void main(String[] args) {
        int total = 1000000;
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total
                , 0.0003f);

        //初始化数据
        for (int i = 0; i < total; i++) {
            bloomFilter.put("" + i);
        }

        //判断值是否在过滤器中
        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if (bloomFilter.mightContain("" + i)) {
                count++;
            }
        }
        System.out.println("匹配数量: " + count);
    }
}
