package com.example.rocketmq;

import io.github.rhwayfun.springboot.rocketmq.starter.constants.RocketMqTopic;

public class DemoRocketMqTopic implements RocketMqTopic{

    @Override
    public String getTopic() {
        return "TopicA";
    }
}
