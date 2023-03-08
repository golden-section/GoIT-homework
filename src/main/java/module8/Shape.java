package module8;

public abstract class Shape {
    private final String color;
    public Shape(String color){
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public String name() {
        return this.getClass().getSimpleName();
    }
    public abstract double area();

    @Override
    public String toString() {
        return String.format("The shape is %s %s with area %f", color, name(), area());
    }
}
