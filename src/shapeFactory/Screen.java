package shapeFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class Screen {
	int originX=0;
	int originY=0;
	int xMax;
	int yMax;
	Map<Shape,Date> shapesOnScreen=new HashMap<Shape,Date>();
	Screen(int xMax,int yMax){
		this.xMax=xMax;
		this.yMax=yMax;
		
	}
	public void addShape(String shapeType,Point point,List<Integer> shapeProperties) {
		Shape shape=Shapefactory.createShape(shapeType, point, shapeProperties);
		if(shape!=null) {
		shapesOnScreen.put(shape,new Date());
		}
	}
	public void deleteSpecificShape(String shapeType){
		for(Entry<Shape,Date> shape:shapesOnScreen.entrySet()) {
			if(shape.getKey().getType().equals(shapeType)) {
				shapesOnScreen.remove(shape.getKey());
			}
		}
	}
	public void deleteShape() {
		
	}
	public Map<Shape,Date> sortByTimestamp() {
		  // Create a list from elements of HashMap shapesOnScreen
        List<Map.Entry<Shape, Date> > sortedlist =
               new LinkedList<Map.Entry<Shape, Date> >(shapesOnScreen.entrySet());
 
        // Sort the list
        Collections.sort(sortedlist, new Comparator<Map.Entry<Shape, Date> >() {
            public int compare(Map.Entry<Shape, Date> object1, 
                               Map.Entry<Shape, Date> object2)
            {
                return (object1.getValue()).compareTo(object2.getValue());
            }
        });
         
        // put data from sorted list to hash map 
    
        HashMap<Shape, Date> sortedShapesByTimestamp = new LinkedHashMap<Shape, Date>();
        for (Map.Entry<Shape, Date> shapesMap : sortedlist) {
        	sortedShapesByTimestamp.put(shapesMap.getKey(), shapesMap.getValue());
        }
        return sortedShapesByTimestamp;
	}
	public Map<Shape,Date> sortByArea() {
		   SortByArea sortByArea = new SortByArea();
		   Map<Shape, Date> sortedShapes = new TreeMap<Shape, Date>(sortByArea);
		   sortedShapes.putAll(shapesOnScreen);
		   return sortedShapes;
	}
	public Map<Shape,Date> sortByPerimeter() {
		   SortByPerimeter sortByPerimeter = new SortByPerimeter();
		   Map<Shape, Date> sortedShapes = new TreeMap<Shape, Date>(sortByPerimeter);
		   sortedShapes.putAll(shapesOnScreen);
		   return sortedShapes;
	}
	public Map<Shape,Date> sortByOriginDistance() {
		   SortByOriginDistance sortByOriginDistance = new SortByOriginDistance();
		   Map<Shape, Date> sortedShapes = new TreeMap<Shape, Date>(sortByOriginDistance);
		   sortedShapes.putAll(shapesOnScreen);
		   return sortedShapes;
	}
	public List<Shape> shapesEnclosingSpecifiedObject(Point point){
		List<Shape> shapesEnclosingSpecifiesObject=new LinkedList<Shape>();
		for(Map.Entry<Shape,Date> shapesMap:shapesOnScreen.entrySet()) {
			if(shapesMap.getKey().isPointEnclosed(point)) {
				shapesEnclosingSpecifiesObject.add(shapesMap.getKey());
			}
		}
		return shapesEnclosingSpecifiesObject;
	}
	
	
}
