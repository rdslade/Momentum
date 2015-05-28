import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Shape;
public class Arrow
{
    public Rectangle2D.Double theBody;
    public int height;
    public double x;
    public double y;
    public double angle;
    public static final int WIDTH = 50;
    public Arrow(int h, int x, int y)
    {
        this.height = h;
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics2D g2,int a)
    {
        theBody = new Rectangle2D.Double(x,y,WIDTH,height);
        g2.draw(theBody);
    }
    public int getHeight()
    {
        return this.height;
    }
    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }
    public void moveArrow(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}