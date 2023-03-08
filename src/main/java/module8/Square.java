package module8;

import java.util.Objects;

public class Square extends Shape{
    private final double side;

    public Square(double side, String color){
        super(color);
        this.side = side;
    }
    @Override
    public double area() {
        return side * side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0 && square.getColor().equalsIgnoreCase(getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}
