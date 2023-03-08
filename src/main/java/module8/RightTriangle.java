package module8;

import java.util.Objects;

public class RightTriangle extends Shape{
    private final double cathetus1;
    private final double cathetus2;

    public RightTriangle(double cathetus1, double cathetus2, String color){
        super(color);
        this.cathetus1 = cathetus1;
        this.cathetus2 = cathetus2;
    }
    @Override
    public double area() {
        return (cathetus1 * cathetus2) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RightTriangle triangle = (RightTriangle) o;
        return Double.compare(triangle.cathetus1, cathetus1) == 0 && Double.compare(triangle.cathetus2, cathetus2) == 0 && triangle.getColor().equalsIgnoreCase(getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cathetus1, cathetus2);
    }
}
