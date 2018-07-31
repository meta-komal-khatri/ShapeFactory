package shapeFactory;

public class Rectangle implements Shape {
	int length;
	int width;
	Point point;
	Rectangle(int length,int width,Point point){
		this.length=length;
		this.width=width;
		this.point=point;
	}
	public double getArea() {
		double area=length*width;
		return area;
	}
	public double getPerimeter() {
		double perimeter=2*(length+width);
		return perimeter;
	}
	public Point getOrigin() {
		return point;
	}
	public boolean isPointEnclosed() {
		return false;
	}
	
}
