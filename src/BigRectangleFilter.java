import java.awt.*;

public class BigRectangleFilter implements Filter
{
    public boolean accept(Object x)
    {
        Rectangle r = (Rectangle) x;
        return 2 * (r.width + r.height) > 10;
    }
}
