package org.example.chapter2.AvoidCreatingUnnecessaryObjects;

public class Resource implements AutoCloseable{
    public Resource() {
        // acquire resource
        System.out.println("resource acquired");
    }

    @Override
    public void close() throws Exception {
       // release resource
        System.out.println("released resource");
    }
}
