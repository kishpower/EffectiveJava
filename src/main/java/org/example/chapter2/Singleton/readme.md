## Enforce the singleton property with a private constructor or an enum type.

There are 2 ways we can achieve singleton pattern.
- Private Constructor : this prevents initialisation of constructor from outside.
 ```java
public class Singleton {
// Private constructor prevents instantiation from other classes
private Singleton() { }

    // Singleton instance is created when the class is loaded
    private static final Singleton INSTANCE = new Singleton();

    // Public method to provide access to the singleton instance
    public static Singleton getInstance() {
        return INSTANCE;
    }

    // Other methods of the singleton class
    public void doSomething() {
        // Method implementation
    }
}

// usage
Singleton singleton = Singleton.getInstance();
singleton.doSomething();
```

- Enum: it provides serialization and thread-safety guarantees out of the box. This approach leverages the Java language feature that ensures any enum value is instantiated only once.

```java
public enum Singleton {
    INSTANCE;

    // Other methods of the singleton class
    public void doSomething() {
        // Method implementation
    }
}

// usage
Singleton singleton = Singleton.getInstance();
singleton.doSomething();

```
