package com.yyf.bigplan.mq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author 杨宇飞 2020-01-12 4:38 上午
 * @version 1.0
 * @apiNote <p>Rabbit MQ 生产者演示代码</p>
 */
@Component
public class SenderTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send() {
        String message = "这是一条测试消息，它的交换机是immediate_exchange_test1，路由key是immediate_routing_key_test1  " + new Date();
        System.out.println("Sender  " + message);
        rabbitTemplate.convertAndSend("immediate_exchange_test1", "immediate_routing_key_test1", message);
    }

}
