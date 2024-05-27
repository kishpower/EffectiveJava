package org.example.chapter2.AvoidCreatingUnnecessaryObjects;

public class Main {
    public static void main(String[] args) throws Exception {
//        using static factory methods instead of constructors
//        staticFactories();


//        Reuse immutable objects
//        immutableObjects();


//        Avoid creating duplicate objects
//        duplicateObjects();


//        Prefer Primitive Types to Boxed Primitives:
//            preferPrimitives();

//        Consider Object Pools:
//        objectPools();
    }

    private static void objectPools() throws Exception {
        // Create a pool of 3 DatabaseConnection objects
        ObjectPool<DatabaseConnection> connectionPool = new ObjectPool<>(3, DatabaseConnection.class);

        // Borrow a connection from the pool
        DatabaseConnection connection1 = connectionPool.borrowObject();
        connection1.connect();

        // Return the connection to the pool
        connection1.disconnect();
        connectionPool.returnObject(connection1);

        // Borrow another connection
        DatabaseConnection connection2 = connectionPool.borrowObject();
        connection2.connect();

        // Return the connection to the pool
        connection2.disconnect();
        connectionPool.returnObject(connection2);
    }

    private static void preferPrimitives() {
        // Avoid this:
        Integer sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i; // Autoboxing creates unnecessary Integer objects
        }

// Prefer this:
        int sum1 = 0;
        for (int i = 0; i < 100; i++) {
            sum1 += i; // No autoboxing, uses primitive type
        }
    }

    private static void duplicateObjects() {
// Avoid this:
//        Integer int1 = new Integer(127);
//        Integer int2 = new Integer(127);

// Prefer this:
        Integer int3 = Integer.valueOf(127);
        Integer int4 = Integer.valueOf(127);

// int3 and int4 reference the same object
        System.out.println(int3 == int4); // true
    }


    private static void immutableObjects() {
// Avoid this:
        String s1 = new String("hello");
        String s2 = new String("hello");

// Prefer this:
        String s3 = "hello";
        String s4 = "hello";

//        s1 and s2 are different objects
        System.out.println(s1 == s2); // false

// s3 and s4 will reference the same object
        System.out.println(s3 == s4); // true
    }

    private static void staticFactories() {
        // Avoid this:
//        Boolean bool1 = new Boolean(true);
//        Boolean bool2 = new Boolean(true);

// Prefer this:
        Boolean bool3 = Boolean.valueOf(true);
        Boolean bool4 = Boolean.valueOf(true);
    }
}
