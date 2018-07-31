package shapeFactory;

public class Square implements Shape {
	int width;
	Point point;
	Square(int width,Point point){
		this.width=width;
		this.point=point;
	}
	public double getArea() {
		double area=width*width;
		return area;
	}
	public double getPerimeter() {
		double perimeter=4*width;
		return perimeter;
	}
	public Point getOrigin() {
		return point;
	}
	public boolean isPointEnclosed() {
		return false;
	}
	
}

