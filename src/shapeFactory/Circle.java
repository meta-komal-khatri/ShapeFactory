package shapeFactory;

import java.util.InputMismatchException;

public class Circle implements Shape {
	//center point
	Point point;
	int radius;
	Circle(int radius,Point point){
		try {
		this.radius=radius;
		this.point=point;
		}
		catch(InputMismatchException exception) {
			System.out.println("Only numbers allowed");
		}
		validate();
	}
	/**
	 * check assertion error
	 */
	private void validate() {
		if(this.radius<0 || this.point.x<0 || this.point.y<0) {
			throw new AssertionError("Nagatives Are Not Allowed");
		}
		if(point.x>Screen.xMax || point.y>Screen.yMax) {
			throw new AssertionError("Must be within range of screen resolution");
		}
		
	}
	/**
	 * returns area of shape
	 */
	public double getArea() {
		double area=3.14*radius*radius;
		return area;
	}
	/**
	 * returns perimeter of shape
	 */
	public double getPerimeter() {
		double perimeter=3.14*2*radius;
		return perimeter;
	}
	/**
	 * returns origin of shape
	 * @return point
	 */
	public Point getOrigin() {
		Point interSectionPoint=new Point();
		//length from center to origin of screen
		float length=(float) Math.sqrt(Math.pow(point.x, 2)+Math.pow(point.y, 2));
		float ratioM=length-radius;
		float ratioN=radius;
		
		interSectionPoint.x=(ratioM*point.x)/(ratioM+ratioN);
		interSectionPoint.y=(ratioM*point.y)/(ratioM+ratioN);
		
		return interSectionPoint;
	}
	/**
	 * checks that point is inside shape or not
	 */
	public boolean isPointEnclosed(Point point) {
		float distance=(float) Math.sqrt(Math.pow(this.point.x-point.x, 2)+Math.pow(this.point.y-point.y,2));
		if(distance<=radius){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * returns type of shape
	 */
	public String getType(){
		return "Circle";
	}
	/**
	 * returns distance from origin of screen
	 */
	public float getOriginDistance() {
		return (float) Math.sqrt(Math.pow(getOrigin().x, 2)+Math.pow(getOrigin().y, 2));
	}
	
}
