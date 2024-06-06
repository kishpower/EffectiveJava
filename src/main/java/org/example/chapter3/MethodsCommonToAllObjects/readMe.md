In Chapter 3 of "Effective Java" by Joshua Bloch, the focus is on methods that are common to all objects. This chapter deals with overriding and properly using methods inherited from the java.lang.Object class. Here is a summary of the key items discussed:

- Item 10: Obey the General Contract When Overriding equals

    - Symmetry: For any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
    - Reflexivity: For any non-null reference value x, x.equals(x) must return true.
    - Transitivity: For any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) must return true.
    - Consistency: For any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
    - Non-nullity: For any non-null reference value x, x.equals(null) must return false.

Example:

```java
public class Person {
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

```

- Item 11: Always Override hashCode When You Override equals

The hashCode method must be overridden to ensure that equal objects have equal hash codes. This is critical for the performance of hash-based collections like HashMap, HashSet, and Hashtable.

Guidelines:

    Use the same set of significant fields as in the equals method.
    Compute a hash code for each significant field and combine them using a formula such as the one proposed by Bloch.

Example:

```java
@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

- Item 12: Always Override toString

Override toString to provide a good representation of your objects, which can help during debugging and logging. The output should be concise, informative, and easy to read.

Example:

```java
@Override
public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
}

```

- Item 13: Override clone Judiciously

The clone method is intended for making copies of objects. If you decide to implement clone, follow these guidelines:

    - Implement Cloneable.
    - Use super.clone() for the actual cloning.
    - Ensure that the cloned object has no shared mutable references with the original.

Example:

```java
public class Person implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

- Item 14: Consider Implementing Comparable

Implement the Comparable interface to allow objects of your class to be sorted. The compareTo method should be consistent with equals.

Guidelines:

    - Ensure that compareTo returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
    - Ensure that compareTo is consistent with equals.

Example:
```java
public class Person implements Comparable<Person> {
    @Override
    public int compareTo(Person other) {
        int nameCmp = name.compareTo(other.name);
        return (nameCmp != 0 ? nameCmp : Integer.compare(age, other.age));
    }
}

```