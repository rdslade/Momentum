import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
public class MomentumComponent extends JPanel
{
    private int ballsLeft;
    private JLabel start;
    private JLabel howMany;
    private Ball ball1;
    private Ball ball2;
    private Ball selectedBall;
    private int screenWidth;
    private int screenHeight;
    public MomentumComponent(int w, int h)
    {
        ballsLeft = 2;
        screenWidth = w;
        screenHeight = h;
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMoverListenter());
        start();
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (ball1!=null)
        {
            ball1.draw(g2);
            ball1.getVelocityArrow().draw(g2);
        }
        if (ball2!=null)
        {
            ball2.draw(g2);
            ball2.getVelocityArrow().draw(g2);
        }
        repaint();
    }
    public void start()
    {
        int bold = Font.BOLD;
        start = new JLabel("Click on the screen to add the Momentum Balls");
        start.setFont(new Font("JasmineUPC", bold, 26));
        howMany = new JLabel("You have "+ballsLeft+" balls left to insert on the screen");
        howMany.setFont(new Font("JasmineUPC",bold,18));
        this.add(start);
        this.add(howMany);
    }
    public Ball ballSelected(String ball)
    {
        if (ball == "ball1")
        {
            return ball1;
        }
        else
        {
            return ball2;
        }
    }
    class MyMouseListener implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            if (ballsLeft == 2)
            {
                ball1 = new Ball(e.getX(),e.getY(),50,50,Color.RED);
                ballsLeft--;
                howMany.setText("You have "+ballsLeft+" balls left to insert on the screen");
                repaint();
            }
            else if (ballsLeft == 1)
            {
                ball2 = new Ball(e.getX(),e.getY(),50,50,Color.BLUE);
                ballsLeft--;
                howMany.setText("You have "+ballsLeft+" balls left to insert on the screen");
                repaint();
            }
        }
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
    }
    class MyMouseMoverListenter implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent e)
        {
               int dx = e.getX() - ball1.getX();
               int dy = e.getY() - ball1.getY();
               if ((ball1.getX() < e.getX()+50&& e.getX()+50 < ball1.getX()+100) &&
                 (ball1.getY() <e.getY()+50 && e.getY()+50< ball1.getY()+100))
                 {
                     ball1.moveBall(ball1.getX()+dx, ball1.getY()+dy);
                 }
               if ((ball2.getX() < e.getX()+50&& e.getX()+50 < ball2.getX()+100) &&
                 (ball2.getY() <e.getY()+50 && e.getY()+50< ball2.getY()+100))
                 {
                     ball2.moveBall(ball1.getX()+dx, ball1.getY()+dy);
                 }
               repaint();
        }
        public void mouseMoved(MouseEvent e){}
    }
}