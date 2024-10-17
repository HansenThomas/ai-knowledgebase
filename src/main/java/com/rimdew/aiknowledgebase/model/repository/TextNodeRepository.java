package com.rimdew.aiknowledgebase.model.repository;

import com.rimdew.aiknowledgebase.model.TextNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextNodeRepository extends Neo4jRepository<TextNode, Long> {
}
