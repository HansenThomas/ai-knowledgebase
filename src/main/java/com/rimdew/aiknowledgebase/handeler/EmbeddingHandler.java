package com.rimdew.aiknowledgebase.handeler;

import com.rimdew.aiknowledgebase.model.TextNode;
import com.rimdew.aiknowledgebase.model.repository.TextNodeRepository;
import com.rimdew.aiknowledgebase.service.EmbeddingService;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmbeddingHandler {
    private final EmbeddingService embeddingService;
    private final TextNodeRepository textNodeRepository;

    public EmbeddingHandler(EmbeddingService embeddingService, TextNodeRepository textNodeRepository) {
        this.embeddingService = embeddingService;
        this.textNodeRepository = textNodeRepository;
    }

    public ResponseEntity handleTextEmbedding(String text) {
        Map map = embeddingService.embedText(text);
        EmbeddingResponse embeddingResponse = (EmbeddingResponse)map.get("embedding");
        if (map.containsKey("embedding")) {
            TextNode textNode = new TextNode();
            textNode.setText(text);
            textNode.setEmbedding(embeddingResponse.getResults().getFirst().getOutput());
            textNodeRepository.save(textNode);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
