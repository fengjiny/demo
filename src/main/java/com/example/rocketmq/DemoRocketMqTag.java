package com.example.rocketmq;

import io.github.rhwayfun.springboot.rocketmq.starter.constants.RocketMqTag;

public class DemoRocketMqTag implements RocketMqTag{
    @Override
    public String getTag() {
        return "TagA";
    }
}
