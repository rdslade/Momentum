import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.JFrame;
public class Ball
{
    private String name;
    private JFrame frame;
    private int width;
    private int height;
    private int x;
    private int y;
    private Color color;
    private Arrow velocity;
    private Arrow momentum;
    private InfoBox info;
    public Ball(int x, int y, int w, int h, Color c, String n, JFrame j)
    {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = c;
        this.velocity = new Arrow(100,x,y);
        this.info = new InfoBox(n,j);
    }
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double ball = new Ellipse2D.Double(x,y,width,height);
        g2.setColor(color);
        g2.draw(ball);
        g2.fill(ball);
    }
    public int getX()
    {
        return this.x;
    }
    public void moveBall(int x, int y)
    {
        this.x = x;
        this.y = y;
        velocity.moveArrow(x,y);
    }
    public int getY()
    {
        return this.y;
    }
    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
    }
    public Arrow getVelocityArrow()
    {
        return this.velocity;
    }
    public InfoBox getInfo()
    {
        return this.info;
    }
}
