package com.rimdew.aiknowledgebase.controller;

import com.rimdew.aiknowledgebase.handeler.EmbeddingHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/embedding")
public class EmbeddingController {
    private final EmbeddingHandler embeddingHandler;

    @GetMapping("/text")
    public ResponseEntity embedText(@RequestParam(value = "text") String text) {
        return embeddingHandler.handleTextEmbedding(text);
    }
}
