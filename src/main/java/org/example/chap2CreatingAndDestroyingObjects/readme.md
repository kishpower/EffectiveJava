# We want to build Nutritional Facts label for products.

Label should contain following properties :
- Nutrition Facts
  - servingSize
  - servings
  - calories
  - fat
  - sodium
  - carbs

- we will look at 3 approches
  - telescoping Constructor pattern
  - java bean pattern
  - builder pattern


****
Some theory:
#  static factory methods vs constructors

The advantages of using static factory methods over constructors when creating instances of a class. Here’s a detailed explanation along with examples to illustrate these points.
Static Factory Methods vs. Constructors
- Advantages of Static Factory Methods
  - Descriptive Names:
    - Static factory methods can have meaningful names, making the code more readable.
    - Constructors can only have the same name as the class, which can be less descriptive.
  - Example :

```java
// Constructor
public class User {
    private String name;
    public User(String name) {
        this.name = name;
    }
}

// Static factory method
public class User {
    private String name;
    private User(String name) {
        this.name = name;
    }
    public static User createWithName(String name) {
        return new User(name);
    }
}

// Usage
User user1 = new User("Alice");  // Constructor
User user2 = User.createWithName("Alice");  // Static factory method
```
  - Control Over Instance Creation:
    - Static factory methods can control the number of instances, for example by returning a cached instance.
```java
public class Boolean {
    private final boolean value;
    private static final Boolean TRUE = new Boolean(true);
    private static final Boolean FALSE = new Boolean(false);
    
    private Boolean(boolean value) {
        this.value = value;
    }

    public static Boolean valueOf(boolean b) {
        return b ? TRUE : FALSE;
    }
}

// Usage
Boolean trueValue = Boolean.valueOf(true);
Boolean falseValue = Boolean.valueOf(false);
```

  - Subtype Flexibility:
    - Static factory methods can return objects of any subtype of their return type.

Example:

```java
public class Shape {
    public static Shape newCircle() {
        return new Circle();
    }
    public static Shape newSquare() {
        return new Square();
    }
}

class Circle extends Shape { /*...*/ }
class Square extends Shape { /*...*/ }

// Usage
Shape circle = Shape.newCircle();
Shape square = Shape.newSquare();
```

  - Avoiding Repeated Object Creation:
     - They can avoid creating duplicate objects by caching and reusing instances.

Example :

```java
import java.util.HashMap;
import java.util.Map;

public class Color {
    private static final Map<String, Color> colors = new HashMap<>();
    private final String name;

    private Color(String name) {
        this.name = name;
    }

    public static Color valueOf(String name) {
        if (!colors.containsKey(name)) {
            colors.put(name, new Color(name));
        }
        return colors.get(name);
    }
}

// Usage
Color red1 = Color.valueOf("red");
Color red2 = Color.valueOf("red");
```
  - Return Different Types:
    - They can return different types based on input parameters.

Example:

```java
public class NumberParser {
    public static Number parse(String s) {
        if (s.contains(".")) {
            return Double.valueOf(s);
        } else {
            return Integer.valueOf(s);
        }
    }
}

// Usage
Number number1 = NumberParser.parse("123");    // Returns Integer
Number number2 = NumberParser.parse("123.45"); // Returns Double
```

  - Encapsulation of Constructor Parameters:
      - They can encapsulate and handle complex parameter logic.
    
Example:

```java
public class ComplexNumber {
    private final double real;
    private final double imaginary;

    private ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static ComplexNumber fromCartesian(double real, double imaginary) {
        return new ComplexNumber(real, imaginary);
    }

    public static ComplexNumber fromPolar(double modulus, double angle) {
        return new ComplexNumber(modulus * Math.cos(angle), modulus * Math.sin(angle));
    }
}

// Usage
ComplexNumber cartesian = ComplexNumber.fromCartesian(1, 1);
ComplexNumber polar = ComplexNumber.fromPolar(1, Math.PI / 4);
```      

- Disadvantages of Static Factory Methods
    - Not Instantly Recognizable:
        Static factory methods are not immediately distinguishable from other static methods in a class.
    - Hard to Subclass:
        Classes without public or protected constructors cannot be subclassed.
    - Verbose Syntax:
        They can sometimes lead to verbose code when compared to constructors.

