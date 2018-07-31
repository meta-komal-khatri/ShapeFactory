package shapeFactory;

public class Triangle implements Shape {
	int height;
	int base;
	Point point;
	Triangle(int height,int base,Point point){
		this.height=height;
		this.base=base;
		this.point=point;
	}
	public double getArea() {
		double area=0.5*height*base;
		return area;
	}
	public double getPerimeter() {
		double perimeter=3.14;
		return perimeter;
	}
	public Point getOrigin() {
		return point;
	}
	public boolean isPointEnclosed() {
		return false;
	}
	
}
