package org.example;

import java.lang.reflect.Method;

public class InvokeTransformerTest1 {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Class c = Runtime.class;
        Method method = c.getDeclaredMethod("exec", String.class);
        method.setAccessible(true);
        method.invoke(runtime, "calc");
    }
}
