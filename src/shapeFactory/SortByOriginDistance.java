package shapeFactory;

import java.util.Comparator;

public class SortByOriginDistance implements Comparator<Shape> {
	 public int compare(Shape shape1, Shape shape2) {
	        return (int) (shape1.getOriginDistance() - shape2.getOriginDistance());
	    }
}
