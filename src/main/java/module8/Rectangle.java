package module8;

import java.util.Objects;

public class Rectangle extends Shape{
    private final double width;
    private final double height;

    public Rectangle(double width, double height, String color){
        super(color);
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return width * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.height, height) == 0 && rectangle.getColor().equalsIgnoreCase(getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
