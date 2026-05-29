package org.example;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class Person3 {
    public int age;
    public String name;

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    // Hoặc @JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS)
    public Sex sex;

    public Person3() {
        System.out.println("Person3 constructor");
    }
//    @Override
//    public String toString() {
//        return String.format("Person.age=%d, Person.name=%s, %s", age, name, sex == null ? "null" : sex);
//    }
}