package com.example.rocketmq;

import io.github.rhwayfun.springboot.rocketmq.starter.common.DefaultRocketMqProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class DemoRocketMqProducer {

    @Resource
    private DefaultRocketMqProducer producer;

    @PostConstruct
    public void execute() {
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                DemoRocketMqContent content = new DemoRocketMqContent();
//                content.setCityId(1);
//                content.setDesc("城市1");
//                Message msg = new Message("TopicA","TagA", content.toString().getBytes());
//                boolean sendResult = producer.sendMsg(msg);
//                System.out.println("发送结果：" + sendResult);
//            }
//        },0,10000);
    }
}
