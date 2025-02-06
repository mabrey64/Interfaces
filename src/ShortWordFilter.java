public class ShortWordFilter implements Filter
{
        public boolean accept(Object x)
        {
                return x.toString().length() < 5;
        }
}
