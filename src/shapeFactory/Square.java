package shapeFactory;

public class Square implements Shape {
	int width;
	Point point;
	Square(int width,Point point){
		this.width=width;
		this.point=point;
	}
	/**
	 * returns area of shape
	 */
	public double getArea() {
		double area=width*width;
		return area;
	}
	/**
	 * returns perimeter of shape
	 */
	public double getPerimeter() {
		double perimeter=4*width;
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
		if(pointP.x>=point.x && pointP.x<=point.x+width && pointP.y>=point.y && pointP.y<=point.y+width)
		{
			return true;
		}
		return false;
		
	}
	/**
	 * returns type of shape
	 */
	public String getType(){
		return "Square";
	}
	/**
	 * returns distance from origin of screen
	 */
	public float getOriginDistance() {
		return (float) Math.sqrt(Math.pow(getOrigin().x, 2)+Math.pow(getOrigin().y, 2));
	}
}

