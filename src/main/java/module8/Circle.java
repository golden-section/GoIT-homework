package module8;

import java.util.Objects;

public class Circle extends Shape{
    private final double radius;

    public Circle(double radius, String color){
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14 * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && circle.getColor().equalsIgnoreCase(getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
