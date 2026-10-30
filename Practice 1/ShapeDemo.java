/**
 * Demonstrates inheritance and polymorphism with geometric shapes.
 */
public class ShapeDemo {
    public static void main(String[] args) {
        Shape shape = new Shape(10, 5);
        Rectangle rectangle = new Rectangle(10, 5);
        Circle circle = new Circle(3);

        System.out.printf("Shape: width=%.2f, height=%.2f%n",
                shape.getWidth(), shape.getHeight());
        System.out.printf("Rectangle: width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f%n",
                rectangle.getWidth(), rectangle.getHeight(),
                rectangle.getArea(), rectangle.getPerimeter());
        System.out.printf("Circle: radius=%.2f, area=%.2f, circumference=%.2f%n",
                circle.getRadius(), circle.getArea(), circle.getCircumference());
    }
}
