package shapeFactory;



public class Circle implements Shape {
	//center point
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
		Point screenMinPoint=new Point(0,0);
		Point interSectionPoint=new Point();
		float slope=(float)point.y/point.x;
		float A,B,C,c,disc,x1,y1;
		  	c = slope * screenMinPoint.x + screenMinPoint.y;
	        B = (2 * point.x + 2 * point.y * slope  + 2 * c * slope);
	        A = (float) (1 + Math.pow(slope, 2));
	        C = (float) (Math.pow(point.x, 2) + Math.pow(c, 2) + 2 * point.y * c + Math.pow(point.y, 2) - Math.pow(radius, 2));
	        disc = (float) (Math.pow(B, 2) - (4 * A * C));

	        if (disc < 0){
	            return interSectionPoint;
	        }
	        else{
	        	if((-B + Math.sqrt(disc)) / (2 * A)<(-B - Math.sqrt(disc)) / (2 * A)){
	            x1 = (float) ((-B + Math.sqrt(disc)) / (2 * A));
	      	    y1 = slope * x1 - c;
	        	}
	        	else{
	        	x1=(float) ((-B - Math.sqrt(disc)) / (2 * A));
	            y1= slope * x1 - c;
	        	}
		    }
	       interSectionPoint.x=x1;
	       interSectionPoint.y=y1;
		return interSectionPoint;
	}
	public boolean isPointEnclosed(Point point) {
		float distance=(float) Math.sqrt(Math.pow(this.point.x-point.x, 2)+Math.pow(this.point.y-point.y,2));
		if(distance<=radius){
			return true;
		}
		else{
			return false;
		}
	}
	public String getType(){
		return "Circle";
	}
	
}
