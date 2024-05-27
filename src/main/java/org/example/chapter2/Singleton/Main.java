package org.example.chapter2.Singleton;

public class Main {
    public static void main(String[] args) {
//        privateConstructor();
        enumImplementation();
    }

    private static void enumImplementation() {
        EnumElvis INSTANCE = EnumElvis.INSTANCE;
        INSTANCE.setGuitarName("slicker");
        INSTANCE.doSomething();
    }

    private static void privateConstructor() {
        PrivateConstructorElvis INSTANCE = PrivateConstructorElvis.getInstance();
        PrivateConstructorElvis instance = PrivateConstructorElvis.INSTANCE;
        System.out.println("is instance1 == instance2 " + (instance == INSTANCE));
        INSTANCE.setGuitarName("Rocker");
        INSTANCE.doSomething();
    }
}
