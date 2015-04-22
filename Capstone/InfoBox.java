import javax.swing.*;
import java.awt.Point;
public class InfoBox extends JDialog
{
    private JLabel velLabel;
    private JTextField velField;
    private JLabel angleLabel;
    private JTextField angleField;
    private JButton submit;
    private JFrame frame;
    public InfoBox(String n)
    {
        velLabel = new JLabel("Velocity (m/s):");
        velField = new JTextField(5);
        angleLabel = new JLabel("Angle (degrees): ");
        angleField = new JTextField(5);
        submit = new JButton("Submit");
        setSize(200,200);
        setTitle(n);
        this.add(velLabel);
        this.add(velField);
        this.add(angleLabel);
        this.add(angleField);
        this.add(submit);
    }
    public void display(JFrame m)
    {
        m.add(this);
    }
}