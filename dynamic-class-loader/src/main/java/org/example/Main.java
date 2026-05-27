package org.example;

// Entry point class used to demonstrate the execution order
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        classLoader.loadClass("org.example.Person");
    }
}