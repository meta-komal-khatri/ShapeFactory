package shapeFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class Screen {
	int originX=0;
	int originY=0;
	static int xMax;
	static int yMax;
	Map<Shape,Date> shapesOnScreen=new LinkedHashMap<Shape,Date>();
	Screen(int xMax,int yMax){
		if(xMax>0 && yMax>0){
		this.xMax=xMax;
		this.yMax=yMax;
		}
		
	}
	/**
	 * add a specific shape on screen 
	 * @param shapeType should be exactly the same as it is in enum
	 * @param point should always be positive
	 * @param shapeProperties 
	 * @return 
	 */
	public boolean addShape(String shapeType,Point point,List<Integer> shapeProperties) {
		if(point.x>xMax || point.y>yMax) {
			throw new AssertionError("Point must be within Screen");
		}
		if(point.x<0 || point.y<0){
			throw new AssertionError("Point must be positive");
		}
		if(shapeType==null){
			throw new AssertionError("Null value of shape type");
		}
		Shape shape=Shapefactory.createShape(shapeType, point, shapeProperties);
		if(shape!=null) {
		shapesOnScreen.put(shape,new Date());
		return true;
		}
		else {
			return false;
		}
	}
	/**
	 * deletes all shapes of specific shape type present on screen
	 * @param shapeType should be exactly the same as it is in enum
	 */
	public void deleteSpecificShape(String shapeType){
		if(shapeType==null){
			throw new AssertionError();
		}
		
		Iterator<Shape> it1 = shapesOnScreen.keySet().iterator();
		while (it1.hasNext()) {
			Shape key = it1.next();
			if(key.getType().equals(shapeType)){
				it1.remove();
			}
		}
			
	}
	public void deleteShape() {
		
	}
	/**
	 * sort according to time stamp of object in ascending 
	 * @return sorted map
	 */
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
	/**
	 * sort according to area of shape in ascending 
	 * @return sorted map
	 */
	public Map<Shape,Date> sortByArea() {
		   SortByArea sortByArea = new SortByArea();
		   Map<Shape, Date> sortedShapes = new TreeMap<Shape, Date>(sortByArea);
		   sortedShapes.putAll(shapesOnScreen);
		   return sortedShapes;
	}
	/**
	 * sort according to perimeter of shape in ascending 
	 * @return sorted map
	 */
	public Map<Shape,Date> sortByPerimeter() {
		   SortByPerimeter sortByPerimeter = new SortByPerimeter();
		   Map<Shape, Date> sortedShapes = new TreeMap<Shape, Date>(sortByPerimeter);
		   sortedShapes.putAll(shapesOnScreen);
		   return sortedShapes;
	}
	/**
	 * sort according to origin distance of shape in ascending 
	 * @return sorted map
	 */
	public Map<Shape,Date> sortByOriginDistance() {
		   SortByOriginDistance sortByOriginDistance = new SortByOriginDistance();
		   Map<Shape, Date> sortedShapes = new TreeMap<Shape, Date>(sortByOriginDistance);
		   sortedShapes.putAll(shapesOnScreen);
		   return sortedShapes;
	}
	/**
	 * finds shapes that encloses specific point
	 * @return list of shapes
	 */
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
