/**
 * Base class for geometric shapes.
 */
public class Shape {
    private final double width;
    private final double height;

    public Shape(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than zero.");
        }

        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
