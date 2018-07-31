package shapeFactory;

public class Circle implements Shape {
	Point point;
	int radius;
	Circle(int radius,Point point){
		this.radius=radius;
		this.point=point;
	}
	public double getArea() {
		double area=3.14*radius*radius;
		return area;
	}
	public double getPerimeter() {
		double perimeter=3.14*2*radius;
		return perimeter;
	}
	public Point getOrigin() {
		return point;
	}
	public boolean isPointEnclosed() {
		return false;
	}
	
}
