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
    public InfoBox(JFrame frame)
    {
        velLabel = new JLabel("Velocity (m/s):");
        velField = new JTextField(5);
        angleLabel = new JLabel("Angle (degrees): ");
        angleField = new JTextField(5);
        submit = new JButton("Submit");
        this.add(velLabel);
        this.add(velField);
        this.add(angleLabel);
        this.add(angleField);
        this.add(submit);
        this.frame = frame;
        setLocationRelativeTo(frame);
        setLocation(new Point(200,200));
    }
}