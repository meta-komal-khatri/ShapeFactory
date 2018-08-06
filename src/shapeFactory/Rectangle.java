package shapeFactory;

public class Rectangle implements Shape {
	int length;
	int width;
	//left corner of edge
	Point point;
	Rectangle(int length,int width,Point point){
		this.length=length;
		this.width=width;
		this.point=point;
		validate();
	}
	/**
	 * check assertion error
	 */
	private void validate() {
		if(this.length<0 || this.width<0 || this.point.x<0 || this.point.y<0) {
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
		double area=length*width;
		return area;
	}
	/**
	 * returns perimeter of shape
	 */
	public double getPerimeter() {
		double perimeter=2*(length+width);
		return perimeter;
	}
	/**
	 * returns origin of shape
	 * @return point
	 */
	public Point getOrigin() {
		return point;
	}
	/**
	 * checks that point is inside shape or not
	 */
	public boolean isPointEnclosed(Point pointP) {
		if(pointP.x>=point.x && pointP.x<=point.x+width && pointP.y>=point.y && pointP.y<=point.y+length)
		{
			return true;
		}
		return false;
		
	}
	/**
	 * returns type of shape
	 */
	public String getType(){
		return "Rectangle";
	}
	/**
	 * returns distance from origin of screen
	 */
	public float getOriginDistance() {
		return (float) Math.sqrt(Math.pow(getOrigin().x, 2)+Math.pow(getOrigin().y, 2));
	}
	
}
