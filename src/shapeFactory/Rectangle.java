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
	public boolean isPointEnclosed(Point pointP) {
		Point pointA=this.point;
		Point pointB=new Point(pointA.x+width,pointA.y);
		Point pointC=new Point(pointB.x,pointB.y+length);
		Point pointD=new Point(pointA.x,pointC.y);
		double area=getArea();
		double area1,area2,area3,area4;
		//area of triangle APB
		area1= (float) (pointA.x*(pointB.y-pointP.y)
				+pointB.x*(pointP.y-pointA.y)+pointP.x*(pointA.y-pointB.y))/2;
		//area of triangle BCP
		area2=(float) (pointB.x*(pointC.y-pointC.y)+
				pointC.x*(pointP.y-pointB.y)+pointP.x*(pointB.y-pointC.y))/2;
		//area of triangle CDP
		area3= (float) (pointC.x*(pointD.y-pointP.y)
				+pointD.x*(pointP.y-pointC.y)+pointP.x*(pointC.y-pointD.y))/2;
		//area of triangle DAP
		area4= (float)( pointD.x*(pointA.y-pointP.y)
				+pointA.x*(pointP.y-pointD.y)+pointP.x*(pointD.y-pointA.y))/2;
		//if P lies within rectangle ,area must be equal to sum of area of triangle APB,BCP,CDP,DAP
		if(area1+area2+area3+area4==area){
			return true;
		}
		return false;
	}
	public String getType(){
		return "Rectangle";
	}
	public float getOriginDistance() {
		return (float) Math.sqrt(Math.pow(getOrigin().x, 2)+Math.pow(getOrigin().y, 2));
	}
	
}
