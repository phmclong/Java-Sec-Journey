package org.example;
// Ví dụ code đúng để minh họa cơ chế ủy quyền cha–con
public class Student {

    public String toString() {
        return "Hello";
    }

    public static void main(String[] args) {
        Student student = new Student();

        // In ra class loader đã nạp class này
        System.out.println(student.getClass().getClassLoader());
        System.out.println(student.toString());
    }
}