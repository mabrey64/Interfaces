/**
 * A filter that accepts strings that are less than 5 characters long.
 * Implement the Filter interface.
 */

public class ShortWordFilter implements Filter
{
        public boolean accept(Object x)
        {
                return x.toString().length() < 5;
        }
}
