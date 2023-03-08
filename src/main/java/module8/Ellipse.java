package module8;

import java.util.Objects;

public class Ellipse extends Shape{
    private final double radius1;
    private final double radius2;

    public Ellipse(double radius1, double radius2, String color){
        super(color);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    @Override
    public double area() {
        return 3.14 * radius1 * radius2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return Double.compare(ellipse.radius1, radius1) == 0 && Double.compare(ellipse.radius2, radius2) == 0 && ellipse.getColor().equalsIgnoreCase(getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius1, radius2);
    }

}
