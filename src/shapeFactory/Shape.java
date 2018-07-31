package shapeFactory;

public interface Shape {
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point point);
	String getType();
}
