package shapeFactory;

import java.util.List;

public class Shapefactory {
	static Shape shape;
	public static Shape createShape(String shapeType,Point point,List<Integer> shapeProperties) {
		ShapeTypeEnum shapeTypeEnum=ShapeTypeEnum.valueOf(shapeType);
		switch(shapeTypeEnum) {
		case Circle:
			
			shape=new Circle(shapeProperties.get(0),point);
			return shape;
			
		case Rectangle:
			
			shape=new Rectangle(shapeProperties.get(0),shapeProperties.get(1),point);
			return shape;
		case Square:
			shape=new Square(shapeProperties.get(0),point);
			return shape;
		case Triangle:
			shape=new Triangle(shapeProperties.get(0),shapeProperties.get(1),point);
			return shape;
		default:
			break;
		
		}
		return null;
	}
}
