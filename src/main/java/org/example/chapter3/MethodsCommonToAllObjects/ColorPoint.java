package org.example.chapter3.MethodsCommonToAllObjects;


import java.awt.*;
import java.util.Objects;

public class ColorPoint extends Point{
    Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x,y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        // colorblind comparison
        if (!(o instanceof Point)) return false;
//        return o instanceof ColorPoint && super.equals(o) && ((ColorPoint) o).color == color;

//        doing color-blind comparison -> satisfies symmetry , violates transitivity
        if (!(o instanceof ColorPoint)) return o.equals(this);

//         o is a ColorPoint; do a full comparison
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

}
