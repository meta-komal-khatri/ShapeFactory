package shapeFactory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class FactoryTest2 {

	@Test
	public void test() {
		Screen screen=new Screen(100,100);
		
		//circle object added to screen
		assertEquals(true,screen.addShape("Circle",new Point(5,5),new ArrayList<Integer>(Arrays.asList(5))));
		
		//point should be within range of screen resolution
		try{
		screen.addShape("Rectangle", new Point(102,102), new ArrayList<Integer>(Arrays.asList(5,4)));
		}
		catch(AssertionError error){
			System.out.println(error.getMessage());
		}
		//point should positive
		try{
			screen.addShape("Rectangle", new Point(-2,-3), new ArrayList<Integer>(Arrays.asList(5,5)));
			}
		catch(AssertionError error){
				System.out.println(error.getMessage());
		}
		//adding rectangle
		screen.addShape("Rectangle", new Point(6,7),new ArrayList<Integer>(Arrays.asList(6,6)) );
		
		//adding square
		screen.addShape("Square", new Point(6,7),new ArrayList<Integer>(Arrays.asList(4)) );
		
		//adding Circle
		screen.addShape("Circle", new Point(9,10),new ArrayList<Integer>(Arrays.asList(2)) );
		
		//adding Rectangle
		screen.addShape("Rectangle", new Point(11,10),new ArrayList<Integer>(Arrays.asList(4,5)));
			
		//check getArea function
		List<Float> expectedResult=new ArrayList<Float>(Arrays.asList(78.5f,36f,16f,12.56f,20f));
		
		int i=0;
		for(Entry<Shape,Date> shape:screen.shapesOnScreen.entrySet()){
			
			assertEquals(expectedResult.get(i), shape.getKey().getArea(),0.01);
			i++;
		}
		
		//check getPerimeter
		expectedResult=new ArrayList<Float>(Arrays.asList(31.4f,24f,16f,12.56f,18f));
		i=0;
		for(Entry<Shape,Date> shape:screen.shapesOnScreen.entrySet()){
			
			assertEquals(expectedResult.get(i), shape.getKey().getPerimeter(),0.01);
			i++;
		}
		
		//check isEnclosed
		List<Boolean> expected=new ArrayList<Boolean>(Arrays.asList(false,true,false,false,true));
		
		i=0;
		for(Entry<Shape,Date> shape:screen.shapesOnScreen.entrySet()){
			assertEquals(expected.get(i), shape.getKey().isPointEnclosed(new Point(11,12)));
			i++;
		}
				
		//check sort by area
		List<String> expectedSort=new ArrayList<String>(Arrays.asList(ShapeTypeEnum.Circle.toString(),ShapeTypeEnum.Square.toString(),
				ShapeTypeEnum.Rectangle.toString(),ShapeTypeEnum.Rectangle.toString(),ShapeTypeEnum.Circle.toString()));
		
		i=0;
		for(Entry<Shape,Date> shape : screen.sortByArea().entrySet()){
			assertEquals(expectedSort.get(i),shape.getKey().getType());
			i++;
		}
		//check sort by origin distance
		expectedSort=new ArrayList<String>(Arrays.asList(ShapeTypeEnum.Circle.toString(),
				ShapeTypeEnum.Rectangle.toString(),ShapeTypeEnum.Circle.toString(),ShapeTypeEnum.Rectangle.toString()));
	
		i=0;
		for(Entry<Shape,Date> shape : screen.sortByOriginDistance().entrySet()){
			assertEquals(expectedSort.get(i),shape.getKey().getType());
			i++;
		}
		
		//specific point enclosing shapes
		expectedSort=new ArrayList<String>(Arrays.asList(ShapeTypeEnum.Rectangle.toString(),ShapeTypeEnum.Rectangle.toString()));
		
		i=0;
		for(Shape shape :screen.shapesEnclosingSpecifiedObject(new Point(11,12)) ){
			assertEquals(expectedSort.get(i),shape.getType());
			System.out.println(shape.getType());
			i++;
		}
		//check deleteSpecificShape
		expectedSort=new ArrayList<String>(Arrays.asList(ShapeTypeEnum.Circle.toString(),ShapeTypeEnum.Square.toString(),
				ShapeTypeEnum.Circle.toString()));
		screen.addShape("Rectangle", new Point(2,3), new ArrayList<Integer>(Arrays.asList(4,5)));  
		screen.deleteSpecificShape("Rectangle");
		i=0;
		for(Entry<Shape,Date> shape : screen.sortByOriginDistance().entrySet()){
			assertEquals(expectedSort.get(i),shape.getKey().getType());
			i++;
		}
		
	}

}
