package com.absolom.kafkatutorial.controller;

import com.absolom.kafkatutorial.payload.Student;
import com.absolom.kafkatutorial.producer.KafkaJsonProducer;
import com.absolom.kafkatutorial.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="/api/v1/messages")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody String message
    ){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message queued format STRING");
    }

    @PostMapping(path="/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendJsonMessage(
            @RequestBody Student student
    ){
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("message queued format JSON");
    }
}
