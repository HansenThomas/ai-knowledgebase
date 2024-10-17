package com.rimdew.aiknowledgebase.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Text")
@Getter
@Setter
public class TextNode {
    @Id
    @GeneratedValue
    private Long id;

    @Property("text")
    private String text;
    @Property("embedding")
    private float[] embedding;
}
