package shapeFactory;

import java.util.Comparator;

public class SortByArea implements Comparator<Shape> {
	 
	    public int compare(Shape shape1, Shape shape2) {
	        return (int) (shape1.getArea() - shape2.getArea());
	    }
	}

