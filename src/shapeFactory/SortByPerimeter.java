package shapeFactory;

import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shape> {
	 
    public int compare(Shape shape1, Shape shape2) {
        return (int) (shape1.getPerimeter() - shape2.getPerimeter());
    }
}
