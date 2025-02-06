/**
 * This class is used to test the BigRectangleFilter class
 * It creates an array of rectangles and tests each one to see if it has a perimeter greater than 10
 * If it does, it prints out that the rectangle has a perimeter greater than 10
 */

import java.awt.*;

public class BigRectLister
{
    public static void main(String[] args)
    {
        BigRectangleFilter bigRectLister = new BigRectangleFilter();

        Rectangle[] rects = new Rectangle[5];
        rects[0] = new Rectangle(1, 2);
        rects[1] = new Rectangle(10, 3);
        rects[2] = new Rectangle(4, 4);
        rects[3] = new Rectangle(4, 1);
        rects[4] = new Rectangle(2, 2);
        for (int i = 0; i < rects.length; i++)
        {
            if (bigRectLister.accept(rects[i]))
            {
                System.out.println("Rectangle " + (i + 1) + " has a perimeter greater than 10");
            }
        }
    }
}
