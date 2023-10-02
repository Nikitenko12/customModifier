package com.example.gremlinplugin;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.DefaultGraphTraversal;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class GraphTraversalExtensions extends DefaultGraphTraversal<Vertex, Vertex> {
    public GraphTraversalExtensions customModifier(String propertyKey, String prefix) {
        return (GraphTraversalExtensions) this.addStep(new CustomModifierStep(this.asAdmin(), propertyKey, prefix));
    }
}
