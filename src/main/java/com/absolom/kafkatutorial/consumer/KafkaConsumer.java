package com.absolom.kafkatutorial.consumer;

import com.absolom.kafkatutorial.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {
//    @KafkaListener(topics = "absolom", groupId = "myGroup")
    public void consumeMsg(String message) {
        log.info(format("======= Consuming a message from absolom topic : %s",message));

    }

    @KafkaListener(topics = "absolom", groupId = "myGroup")
    public void consumeMsg(Student student) {
        log.info(format("======= Consuming a message from absolom topic : %s",student.toString()));

    }

}
