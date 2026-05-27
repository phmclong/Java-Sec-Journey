package org.example;

// Class used to demonstrate the execution order of initialization blocks
public class Person {

    public static int staticVar;
    public int instanceVar;

    static {
        System.out.println("Static initialization block");
    }

    {
        System.out.println("Instance initialization block");
    }

    Person() {
        System.out.println("No-argument constructor");
    }

    Person(int instanceVar) {
        this.instanceVar = instanceVar;
        System.out.println("Parameterized constructor");
    }

    public static void staticAction() {
        System.out.println("Static method");
    }
}