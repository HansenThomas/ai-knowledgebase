package com.rimdew.aiknowledgebase.service;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmbeddingService {
    private final EmbeddingModel embeddingModel;

    public EmbeddingService(OllamaApi ollamaApi, EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    //TODO: Embed text here
    public Map embedText(String text) {
        EmbeddingResponse embeddingResponse = embeddingModel.embedForResponse(List.of(text));
        return Map.of("embedding", embeddingResponse);
    }
}
