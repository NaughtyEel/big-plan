package com.yyf.bigplan.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author 杨宇飞 2020-01-12 4:50 上午
 * @version 1.0
 * @apiNote <p>Rabbit MQ 消费者演示代码</p>
 */
@Component
public class ReceiverTest {

    @RabbitHandler
    @RabbitListener(queues = "immediate_queue_test1")
    public void immediateProcess(String message) {
        System.out.println("Receiver：我收到消息啦。消息是 " + message);
    }

}
