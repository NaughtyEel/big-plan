package com.yyf.bigplan.mq;

import com.yyf.bigplan.mq.sender.SenderTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 杨宇飞 2020-01-12 4:51 上午
 * @version 1.0
 * @apiNote <p>Rabbit MQ 测试类</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTestApplicationTests {

    @Autowired
    SenderTest sender;

    @Test
    public void contextLoads() {
        sender.send();
    }

}
