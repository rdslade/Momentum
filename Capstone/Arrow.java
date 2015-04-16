import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Dimension;
import java.awt.Graphics2D;
public class Arrow
{
    public Dimension body;
    public int x;
    public int y;
    public static final int WIDTH = 25;
    public Arrow(Dimension d, int x, int y)
    {
        this.body = new Dimension(d);
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics2D g2)
    {
        Rectangle2D.Double theBody = new Rectangle2D.Double(x,y,body.getWidth(),body.getHeight());
        g2.draw(theBody);
    }
}