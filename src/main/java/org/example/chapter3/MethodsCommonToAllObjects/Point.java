package org.example.chapter3.MethodsCommonToAllObjects;

import java.util.Objects;

public class Point {
    int x;

    int y;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
