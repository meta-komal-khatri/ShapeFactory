package shapeFactory;

import java.util.LinkedList;
import java.util.List;

public class Screen {
	int originX=0;
	int originY=0;
	int xMax;
	int yMax;
	List<Shape> shapesOnScreen=new LinkedList<Shape>();
	Screen(int xMax,int yMax){
		this.xMax=xMax;
		this.yMax=yMax;
		
	}
	public void addShape(String shapeType,Point point,List<Integer> shapeProperties) {
		Shape shape=Shapefactory.createShape(shapeType, point, shapeProperties);
		if(shape!=null) {
		shapesOnScreen.add(shape);
		}
	}
	public void deleteSpecificShape(String shapeType){
		for(Shape shape:shapesOnScreen){
			if(shape.getType().equals(shapeType)){
				shapesOnScreen.remove(shape);
			}
		}
	}
	
}
