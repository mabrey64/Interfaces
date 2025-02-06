/**
 * A filter that accepts rectangles with a perimeter greater than 10.
 */

import java.awt.*;

public class BigRectangleFilter implements Filter
{
    /**
     * Accepts rectangles with a perimeter greater than 10.
     * @param x the object to be filtered
     * @return true if the perimeter is greater than 10, false otherwise
     */
    public boolean accept(Object x)
    {
        Rectangle r = (Rectangle) x;
        int perimeter = 2 * (r.width + r.height);
        return perimeter > 10;
    }
}
