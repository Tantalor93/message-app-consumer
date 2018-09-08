package com.github.tantalor93.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class MessageController {

    private List<String> list = new LinkedList<>();

    @KafkaListener(topics = "test")
    public void listen(String message) {
        list.add(message);
        System.out.println("Received Messasge in group foo: " + message);
    }

    @GetMapping
    public ResponseEntity<List<String>> getMessages() {
        return ResponseEntity.ok(list);
    }
}
