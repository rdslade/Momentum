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
    private double angle;
    private int width;
    private int height;
    private double x;
    private double y;
    private double deltaX;
    private double deltaY;
    private Color color;
    private Arrow velocity;
    private Arrow momentum;
    //private InfoBox info;
    public Ball(int x, int y, int w, int h, Color c, String n, JFrame j)
    {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = c;
        this.velocity = new Arrow(100,x,y);
        this.angle = 0;
        this.frame = j;
        this.deltaX = 0;
        this.deltaY = 0;
    }
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double ball = new Ellipse2D.Double(x,y,width,height);
        g2.setColor(color);
        g2.draw(ball);
        g2.fill(ball);
    }
    public double getX()
    {
        return this.x;
    }
    public void moveBall(double x, double y)
    {
        this.x = x;
        this.y = y;
        velocity.moveArrow(x,y);
    }
    public double getY()
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
    public void setAngle(double a)
    {
        this.angle = a;
        angle = Math.toRadians(angle);
    }
    public void setDX(int dx)
    {
        this.deltaX = dx;
    }
    public void setDY(int dy)
    {
        this.deltaY = dy;
    }
    public void runSimulation() 
    {
        if (deltaX == 0)
        {
            deltaX = Math.cos(angle);
            deltaY = Math.sin(angle);
        }
        if (this.x>0 && this.x<frame.getWidth() && this.y>125 && this.y<frame.getHeight())
        {
            this.x+=deltaX;
            this.y+=deltaY;
        } 
        else
        {
            if (this.x<0 || this.x>frame.getWidth())
            {
                deltaX = deltaX*-1;
                this.x+=deltaX;
            }
            if (this.y<125 || this.y>frame.getHeight()-650)
            {
                deltaY = deltaY*-1;
                this.y+=deltaY;
            }
        }
    }
}
