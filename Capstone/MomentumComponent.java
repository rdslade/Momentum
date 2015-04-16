import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
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
    private int screenWidth;
    private int screenHeight;
    public MomentumComponent(int w, int h)
    {
        ballsLeft = 2;
        screenWidth = w;
        screenHeight = h;
        this.addMouseListener(new MyMouseListener());
        start();
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (ballsLeft==1)
        {
            ball1.draw(g2);
            ball1.getVelocityArrow().draw(g2);
        }
        if (ballsLeft==0)
        {
            ball2.draw(g2);
        }
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
    class MyMouseListener implements MouseListener
    {
        public void mouseClicked(MouseEvent event)
        {
            if (ballsLeft == 2)
            {
                ball1 = new Ball(event.getX(),event.getY(),15,15,Color.RED);
                ballsLeft--;
                howMany.setText("You have "+ballsLeft+" balls left to insert on the screen");
                repaint();
            }
            else if (ballsLeft == 1)
            {
                ball2 = new Ball(event.getX(),event.getY(),15,15,Color.BLUE);
                ballsLeft--;
                howMany.setText("You have "+ballsLeft+" balls left to insert on the screen");
                repaint();
            }
        }
        public void mouseReleased(MouseEvent event){}
        public void mousePressed(MouseEvent event)
        {
            if (ballsLeft==0 && (ball1.getX()-25 < event.getX()&& event.getX() < ball1.getX()+25) &&
                 (ball1.getY()-15 <event.getY() && event.getY()< ball1.getY()+15))
            {
                
            }
            else if (ballsLeft==0 && (ball2.getX()-25 < event.getX()&& event.getX() < ball2.getX()+25) &&
                 (ball2.getY()-25 <event.getY() && event.getY()< ball2.getY()+25))
            {
                
            }
        }
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
    }
}