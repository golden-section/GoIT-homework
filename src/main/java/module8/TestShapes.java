package module8;

public class TestShapes {
    public static void main(String[] args) {
        Shape rect = new Rectangle(10.0, 5.0, "Red");
        System.out.println(rect);

        Shape circle = new Circle(15.0, "Green");
        System.out.println(circle);

        Shape ellipse = new Ellipse(12.0, 7.0, "Blue");
        System.out.println(ellipse);

        Shape triangle = new RightTriangle(6.0, 9.0, "Brown");
        System.out.println(triangle);

        Shape square = new Square(8.0, "Purple");
        System.out.println(square);
    }
}
