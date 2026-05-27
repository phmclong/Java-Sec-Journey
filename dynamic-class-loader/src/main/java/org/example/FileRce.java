package org.example;

import java.net.URL;
import java.net.URLClassLoader;

// URLClassLoader – load class via file:// protocol
public class FileRce {

    public static void main(String[] args) throws Exception {

        // Tạo URL trỏ tới thư mục chứa class
        URL[] urls = new URL[] {
                new URL("file:///D:/")
        };

        // Khởi tạo URLClassLoader
        URLClassLoader urlClassLoader = new URLClassLoader(urls);

        // Load class Calc
        Class<?> calcClass = urlClassLoader.loadClass(
                "org.example.Calc"
        );

        // Khởi tạo object (sẽ trigger static block / constructor)
        calcClass.newInstance();
    }
}