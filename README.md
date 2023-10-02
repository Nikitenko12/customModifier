# customModifier

1. Set up a Java project with Tinkerpop 3.6.x dependencies.
2. Add the above classes to the project.
3. Compile and package them into a JAR.
4. Include the JAR in the Gremlin Server's classpath.
5. Restart the Gremlin Server.
6. In your Gremlin client or console, you can use the step as:

g.V().inject('CustomModifierStep').customModifier("name", "Prefix_").toList();
