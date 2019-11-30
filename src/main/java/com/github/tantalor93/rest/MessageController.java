package com.github.tantalor93.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @GetMapping
    public ResponseEntity<List<String>> getMessages() {
        return ResponseEntity.ok(BenkyListener.LIST);
    }
}
