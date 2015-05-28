import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
public class MomentumComponent extends JPanel
{
    private int ballsLeft;
    private JFrame master;
    private JPanel angleP;
    private JLabel start;
    private JLabel howMany;
    private JLabel angleL;
    private JTextField angleT;
    private JButton angleS;
    private JButton stop;
    private int angle;
    private Ball ball1;
    private Ball ball2;
    private Ball selectedBall;
    private int screenWidth;
    private int screenHeight;
    private Rectangle2D.Double barrier;
    public MomentumComponent(int w, int h, JFrame f)
    {
        angle = 0;
        ballsLeft = 2;
        screenWidth = w;
        screenHeight = h;
        angleS = new JButton("Start Simulation!");
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMoverListenter());
        angleS.addActionListener(new ButtonListener());
        this.master = f;
        barrier = new Rectangle2D.Double(0,125,1000,10);
        start();
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.draw(barrier);
        g2.fill(barrier);
        if (ball1!=null)
        {
            ball1.draw(g2);
            ball1.getVelocityArrow().draw(g2,angle);
        }
        if (ball2!=null)
        {
            ball2.draw(g2);
            ball2.getVelocityArrow().draw(g2,angle);
        }
        if (angle!=0)
        {
            ball1.runSimulation();
            ball2.runSimulation();
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
        angleP = new JPanel();
        angleL = new JLabel("Angle: ");
        angleL.setFont(new Font("Consolas", bold, 24));
        angleT = new JTextField(3);
        angleP.add(angleL);
        angleP.add(angleT);
        angleP.add(angleS);
        this.add(angleP);
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
    public void reset()
    {
        master.remove(this);
    }
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (angle!=0)
            {
                angle = Integer.parseInt(angleT.getText());
            }   
            if (e.getActionCommand()=="Start Simulation!")
            {
                if (ball1!=null && ball2!=null && angleT.getText().trim()!="")
                {
                    angle = Integer.parseInt(angleT.getText());
                    howMany.setText("Angle is: "+angle);
                    ball1.setAngle(angle);
                    ball2.setAngle(angle);
                    stop = new JButton("Stop Simulation");
                    add(stop);
                    stop.addActionListener(new ButtonListener());
                }
                else if (ball1!=null && ball2!=null)
                {
                    howMany.setText("You must set an angle to a value other than 0 and press /'Start Simulation!/'");
                }
                else
                {
                    howMany.setText("You must add all of your Momentum Balls to the screen before setting the angle");
                }
            }
            if (e.getActionCommand() =="Stop Simulation")
            {
                ball1 = null;
                ball2 = null;
                ball1 = new Ball(200,400,50,50,Color.RED,"Ball 1",master);
            }
        }
    }
    class MyMouseListener implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            if (ballsLeft == 2)
            {
                ball1 = new Ball(e.getX(),e.getY(),50,50,Color.RED, "Ball 1",master);
                ballsLeft--;
                howMany.setText("You have "+ballsLeft+" balls left to insert on the screen");
                repaint();
            }
            else if (ballsLeft == 1)
            {
                ball2 = new Ball(e.getX(),e.getY(),50,50,Color.BLUE, "Ball 2",master);
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
               double dxBall = e.getX() - ball1.getX();
               double dyBall = e.getY() - ball1.getY();
               double dxArrow = e.getX() - ball1.getVelocityArrow().getX();
               double dyArrow = e.getY() - ball1.getVelocityArrow().getY();
               if ((ball1.getX() < e.getX()+50&& e.getX()+50 < ball1.getX()+100) &&
                 (ball1.getY() <e.getY()+50 && e.getY()+50< ball1.getY()+100))
                 {
                     ball1.moveBall(ball1.getX()+dxBall, ball1.getY()+dyBall);
                 }
               if ((ball2.getX() < e.getX()+50&& e.getX()+50 < ball2.getX()+100) &&
                 (ball2.getY() <e.getY()+50 && e.getY()+50< ball2.getY()+100))
                 {
                     ball2.moveBall(ball1.getX()+dxBall, ball1.getY()+dyBall);
                 }
               repaint();
        }
        public void mouseMoved(MouseEvent e){}
    }
}