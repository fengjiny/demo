package com.example.rocketmq;

import io.github.rhwayfun.springboot.rocketmq.starter.constants.RocketMqContent;
import lombok.Builder;
import lombok.Data;


@Data
public class DemoRocketMqContent extends RocketMqContent {
    private int cityId;
    private String desc;
}
