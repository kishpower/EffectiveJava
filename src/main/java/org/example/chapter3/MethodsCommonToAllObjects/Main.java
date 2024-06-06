package org.example.chapter3.MethodsCommonToAllObjects;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // EqualsAndHashCode
//        equalsAndHashCode();
//        equalsAndHashCode2();

//        todo : example of comparable
    }

    private static void equalsAndHashCode2() {
        // satisfies symmetry, violates transitive property
        ColorPoint p1 = new ColorPoint(1, 2, Color.red);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.blue);

        System.out.println("p1.equals(p2) = " + p1.equals(p2));
        System.out.println("p2.equals(p3) = " + p2.equals(p3));
        System.out.println("p1.equals(p3) = " + p1.equals(p3));
// Solution - Favour composition over inheritance use class ColorPoint{ Point p; Color c; }
    }
    private static void equalsAndHashCode() {
        // violates symmetry
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println("cis.equals(s) = " + cis.equals(s)); // true
        System.out.println("s.equals(cis) = " + s.equals(cis)); // false

        /* solution - change equals method in CaseInsensitiveString
    public boolean equals(Object obj) {
           return obj instanceof CaseInsensitiveString && s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
    }
         */

    }
}
