package org.example;

import org.apache.commons.collections.functors.InvokerTransformer;

public class InvokeTransformerTest2 {
    public static void main(String[] args) throws Exception {
        // Get the Runtime instance
        Runtime runtime = Runtime.getRuntime();

        // Create an InvokerTransformer to call Runtime.exec("calc")
        InvokerTransformer invokerTransformer = new InvokerTransformer(
                "exec",
                new Class[]{String.class},
                new Object[]{"calc"}
        );

        // Trigger the transform (will execute the command)
        invokerTransformer.transform(runtime);
    }
}
