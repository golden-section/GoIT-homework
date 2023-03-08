package module8;

public class TestShapes {
    public static void main(String[] args) {
        Shape rect = new Rectangle(10.0, 5.0, "Red");
        Shape circle = new Circle(15.0, "Green");
        Shape ellipse = new Ellipse(12.0, 7.0, "Blue");
        Shape triangle = new RightTriangle(6.0, 9.0, "Brown");
        Shape square = new Square(8.0, "Purple");

        System.out.println(rect);
        System.out.println(circle);
        System.out.println(ellipse);
        System.out.println(triangle);
        System.out.println(square);

        System.out.println(rect.name());
        System.out.println(circle.name());
        System.out.println(ellipse.name());
        System.out.println(triangle.name());
        System.out.println(square.name());
    }
}
