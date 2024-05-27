package org.example.chapter2.AvoidCreatingUnnecessaryObjects;

public class DatabaseConnection {
    private boolean inUse;

    public DatabaseConnection() {
        // Simulate the expensive creation of a connection
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        inUse = false;
    }

    public void connect() {
        // Simulate connecting to a database
        System.out.println("Connecting to the database...");
    }

    public void disconnect() {
        // Simulate disconnecting from a database
        System.out.println("Disconnecting from the database...");
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}

