package org.example.chapter2.AvoidCreatingUnnecessaryObjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) throws Exception {
//        using static factory methods instead of constructors
//        staticFactories();
//        staticFactories2();


//        Reuse immutable objects
//        immutableObjects();


//        Avoid creating duplicate objects
//        duplicateObjects();


//        Prefer Primitive Types to Boxed Primitives:
//            preferPrimitives();

//        Consider Object Pools:
//        objectPools();


        // Eliminate Obsolete Object ref
//        eliminateObsoleteObjectRef();

        // Avoid Finalisers
//        avoidFinalizers();
    }

    private static void avoidFinalizers() {
        //

        try(BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir").concat("/src/main/java/org/example/chapter2/AvoidCreatingUnnecessaryObjects/avoidFinalisers.txt")))){
           String line;
           while ((line = reader.readLine()) != null){
               System.out.println("line = " + line);
           }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void eliminateObsoleteObjectRef() {
        // avoid this
        Stack stack = new Stack();
        stack.push(1);
        System.out.println(stack);

        //use this
        Stack1 stack1 = new Stack1();
        stack1.push(1);
        System.out.println("stack1 = " + stack1);
    }

    private static void staticFactories2() {
        // avoid this - Person class uses heavy memory
//        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        gmtCal.set(1950, 0 , 0 , 0, 0,0);
//        Person person = new Person(gmtCal.getTime());
//        gmtCal.set(1980, 0 , 0 , 0, 0,0);
//        Person person1 = new Person(gmtCal.getTime());
//        System.out.println("person.isBabyBoomer() = " + person.isBabyBoomer());
//        System.out.println("person1.isBabyBoomer() = " + person1.isBabyBoomer());

        // try this - Person1 class uses static block
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1950, 0 , 0 , 0, 0,0);
        Person1 person = new Person1(gmtCal.getTime());
        gmtCal.set(1980, 0 , 0 , 0, 0,0);
        Person1 person1 = new Person1(gmtCal.getTime());
        System.out.println("person.isBabyBoomer() = " + person.isBabyBoomer());
        System.out.println("person1.isBabyBoomer() = " + person1.isBabyBoomer());

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
