package shapeFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ShapeFactoryTest {

	@Test
	void test() {
		Screen screen=new Screen(100,100);
		//test for circle class
		List<Integer> properties=new LinkedList<Integer>();
		properties.add(98);
		
		//when circle is created it returns true
		assertEquals(true,screen.addShape("Circle", new Point(5,5),properties ));
		
		//if point is greater than size it throws assertion error
		try {
		screen.addShape("Circle", new Point(101,101), properties);
		}
		catch(AssertionError e) {
			System.out.println(e.getMessage());
		}
		//Rectangle
		properties=new LinkedList<Integer>();
		properties.add(4);
		properties.add(5);
		
		//
		for(Shape shape1:screen.shapesOnScreen.keySet()) {
			assertEquals(1.464,shape1.getOrigin().x,.001);
		}
		
		
	}

}
