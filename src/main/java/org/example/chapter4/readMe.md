Item 15: Minimize the Accessibility of Classes and Members

    - Key Points:

        - Make each class or member as inaccessible as possible.
        - Use the private modifier for fields and methods that are not intended to be used outside the class.
        - Use the package-private (no modifier) for members that need to be accessed only within the same package.
        - Use the protected modifier for members that need to be accessed in subclasses.
        - Use the public modifier sparingly and only for API elements that are intended for public use.

Example:

```java
public class Example {
    private int privateField;
    int packagePrivateField;
    protected int protectedField;
    public int publicField;

    private void privateMethod() {}
    void packagePrivateMethod() {}
    protected void protectedMethod() {}
    public void publicMethod() {}
}

```
***

Item 16: In Public Classes, Use Accessor Methods, Not Public Fields

    - Key Points:
        - Exposing fields directly makes it difficult to enforce invariants and maintain control over the internal state.
        - Use getter and setter methods to provide controlled access to fields.

Example:
```java
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

```

***
Item 17: Minimize Mutability

    Key Points:

    - Immutable objects are simpler, safer, and more robust.
    - To make a class immutable, follow these rules:
        - Don’t provide methods that modify the object’s state.
        - Ensure that the class can’t be extended.
        - Make all fields final and private.
        - Ensure exclusive access to any mutable components.

Example:

```java
public final class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

```

***
Item 18: Favor Composition Over Inheritance

    Key Points:

        - Composition provides greater flexibility and is more robust than inheritance.
        - Use composition to achieve code reuse by embedding an instance of another class.

Example :

```java
// Audio source interface
interface AudioSource {
    byte[] readAudio();
}

// Concrete audio sources
class MP3Source implements AudioSource {
    public byte[] readAudio() {
        // Implementation to read MP3 audio
        return new byte[0]; // Simplified for example
    }
}

class WAVSource implements AudioSource {
    public byte[] readAudio() {
        // Implementation to read WAV audio
        return new byte[0]; // Simplified for example
    }
}

// Audio effect interface
interface AudioEffect {
    byte[] apply(byte[] audio);
}

// Concrete audio effects
class VolumeAdjust implements AudioEffect {
    private double volumeLevel;

    public VolumeAdjust(double volumeLevel) {
        this.volumeLevel = volumeLevel;
    }

    public byte[] apply(byte[] audio) {
        // Implementation to adjust volume
        return audio; // Simplified for example
    }
}

class Echo implements AudioEffect {
    public byte[] apply(byte[] audio) {
        // Implementation to add echo
        return audio; // Simplified for example
    }
}

// Audio player using composition
class AudioPlayer {
    private AudioSource source;
    private List<AudioEffect> effects = new ArrayList<>();

    public AudioPlayer(AudioSource source) {
        this.source = source;
    }

    public void addEffect(AudioEffect effect) {
        effects.add(effect);
    }

    public void play() {
        byte[] audio = source.readAudio();
        for (AudioEffect effect : effects) {
            audio = effect.apply(audio);
        }
        // Code to send audio to output device
        System.out.println("Playing audio with " + effects.size() + " effects");
    }
}

/// Anti Pattern
class BasicPlayer {
    public void play() {
        // Basic implementation
    }
}

class MP3Player extends BasicPlayer {
    @Override
    public void play() {
        // MP3-specific implementation
    }
}

class MP3PlayerWithVolumeAdjust extends MP3Player {
    @Override
    public void play() {
        super.play();
        // Add volume adjustment
    }
}

class MP3PlayerWithVolumeAdjustAndEcho extends MP3PlayerWithVolumeAdjust {
    @Override
    public void play() {
        super.play();
        // Add echo
    }
}

```
***
Item 19: Design and Document for Inheritance or Else Prohibit It

    Key Points:

    - If a class is intended for inheritance, document its subclassing behavior and provide hooks for subclassing.
    - Otherwise, prohibit inheritance by making the class final or by making constructors private or package-private.

```java
// Class designed for inheritance
public abstract class AbstractShape {
    public abstract double area();
    public abstract double perimeter();
}
```
***
Item 20: Prefer Interfaces to Abstract Classes

    Key Points:

    - Interfaces provide a way to define a contract that classes can implement.
    - Interfaces allow for multiple inheritance of type, whereas abstract classes only allow single inheritance.

```java
interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

```
***
Item 21: Design Interfaces for Posterity

    Key Points:

    - Design interfaces to be flexible and to evolve without breaking existing implementations.
    - Provide default methods sparingly and thoughtfully.

```java
interface Shape {
    double area();
    double perimeter();

    default String getDescription() {
        return "This is a shape";
    }
}
```
***

Item 22: Use Interfaces Only to Define Types

    Key Points:

    - Use interfaces to define types that multiple classes can implement.
    - Avoid using interfaces to define constants; use enums or final classes instead.

Example:

```java
// Interface defining a type
interface Operable {
    void operate();
}

// Enum for constants
enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
```

***
Item 23: Prefer Class Hierarchies to Tagged Classes

    Key Points:

    - Avoid tagged classes, which are classes that have a tag field indicating their type.
    - Use class hierarchies to model different behaviors or states.

Example:
```java
// Tagged class - not recommended
class Figure {
    enum Shape { RECTANGLE, CIRCLE };

    final Shape shape;

    // Fields for rectangle
    double length;
    double width;

    // Fields for circle
    double radius;

    // Constructor for rectangle
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    // Constructor for circle
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    double area() {
        switch(shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * radius * radius;
            default:
                throw new AssertionError(shape);
        }
    }
}

// Preferred class hierarchy
abstract class Figure {
    abstract double area();
}

class Rectangle extends Figure {
    private final double length;
    private final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

class Circle extends Figure {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
```
***
Item 24: Favor Static Member Classes over Nonstatic

    Key Points:

    - Use static member classes unless the enclosing instance is required.
    - Non-static member classes have an implicit reference to their enclosing instance.

Example:
```java
public class OuterClass {
    // Static member class
    public static class StaticMemberClass {
        // Code
    }

    // Non-static member class
    public class NonStaticMemberClass {
        // Code
    }
}
```