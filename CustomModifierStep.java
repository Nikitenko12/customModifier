package com.example.gremlinplugin;

import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.step.map.MapStep;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class CustomModifierStep extends MapStep<Vertex, Vertex> {
    private final String propertyKey;
    private final String prefix;

    public CustomModifierStep(final Traversal.Admin traversal, String propertyKey, String prefix) {
        super(traversal);
        this.propertyKey = propertyKey;
        this.prefix = prefix;
    }

    @Override
    protected Vertex map(final Vertex vertex) {
        // Add a prefix to the specified property
        if (vertex.property(propertyKey).isPresent()) {
            String originalValue = vertex.value(propertyKey);
            vertex.property(propertyKey, prefix + originalValue);
        }

        // Add a new property to the vertex
        vertex.property("addedProperty", "exampleValue");

        // Increment an 'age' property by 1
        if (vertex.property("age").isPresent()) {
            int age = vertex.value("age");
            vertex.property("age", age + 1);
        }

        return vertex;
    }
}
