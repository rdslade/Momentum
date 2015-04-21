import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Dimension;
import java.awt.Graphics2D;
public class Arrow
{
    public int height;
    public int x;
    public int y;
    public double angle;
    public static final int WIDTH = 50;
    public Arrow(int h, int x, int y)
    {
        this.height = h;
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics2D g2)
    {
        Rectangle2D.Double theBody = new Rectangle2D.Double(x,y,WIDTH,height);
        g2.draw(theBody);
    }
    public int getHeight()
    {
        return this.height;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public void moveArrow(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}