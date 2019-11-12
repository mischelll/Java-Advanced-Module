package javaooplabs.shapes;

public class Circle extends Shape {
    public final Double getRadius() {
        return radius;
    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    private Double radius;

    @Override
    protected Double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    protected Double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
