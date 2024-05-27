## Key Points to Avoid Creating Unnecessary Objects

- Use Static Factory Methods Instead of Constructors:

  Static factory methods can return pre-existing instances instead of creating new ones each time.

    - Example 1: Static Factory Method
        Instead of creating a new Boolean object each time, use the static factory method Boolean.valueOf(boolean) which reuses the instances Boolean.TRUE and Boolean.FALSE.
```java
// Avoid this:
Boolean bool1 = new Boolean(true);
Boolean bool2 = new Boolean(true);

// Prefer this:
Boolean bool3 = Boolean.valueOf(true);
Boolean bool4 = Boolean.valueOf(true);
```

- Reuse Immutable Objects:

  Immutable objects, such as String and Integer, can often be reused safely.
    - Example 2: String Reuse.
    Strings are immutable and can be reused safely. Using string literals ensures that the same instance is reused.
```java
// Avoid this:
String s1 = new String("hello");
String s2 = new String("hello");

// Prefer this:
String s3 = "hello";
String s4 = "hello";

// s3 and s4 will reference the same object
System.out.println(s3 == s4); // true
```

- Avoid Creating Duplicate Objects:

  Avoid creating multiple objects that are logically equivalent.
  
```java
// Avoid this:
Integer int1 = new Integer(127);
        Integer int2 = new Integer(127);

// Prefer this:
        Integer int3 = Integer.valueOf(127);
        Integer int4 = Integer.valueOf(127);

// int3 and int4 reference the same object
        System.out.println(int3 == int4); // true
```

- Prefer Primitive Types to Boxed Primitives:

  Use primitives instead of their boxed counterparts (e.g., int instead of Integer) when possible to avoid unnecessary object creation.
  - Example 3: Avoid Unnecessary Boxing ,
    Using boxed types like Integer instead of primitive types can lead to unnecessary object creation.
```java
// Avoid this:
Integer sum = 0;
for (int i = 0; i < 100; i++) {
    sum += i; // Autoboxing creates unnecessary Integer objects
}

// Prefer this:
int sum = 0;
for (int i = 0; i < 100; i++) {
    sum += i; // No autoboxing, uses primitive type
}
```

- Consider Object Pools:

  For expensive-to-create objects, consider using object pools.
  - Example 4: Object Pooling
    For objects that are expensive to create, consider reusing objects through a pool.

```java
// Example of object pooling
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool<T> {
    private final BlockingQueue<T> pool;

    public ObjectPool(int size, Class<T> clazz) throws Exception {
        pool = new LinkedBlockingQueue<>(size);
        for (int i = 0; i < size; i++) {
            pool.offer(clazz.getDeclaredConstructor().newInstance());
        }
    }

    public T borrowObject() throws InterruptedException {
        return pool.take();
    }

    public void returnObject(T obj) {
        pool.offer(obj);
    }
}

// Usage
public class Main {
    public static void main(String[] args) throws Exception {
        ObjectPool<MyObject> pool = new ObjectPool<>(10, MyObject.class);

        MyObject obj1 = pool.borrowObject();
        // Use the object
        pool.returnObject(obj1);
    }
}

class MyObject {
    // Expensive-to-create object
}
```