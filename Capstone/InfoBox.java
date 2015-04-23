import javax.swing.*;
import java.awt.Point;
import java.awt.Dimension;
public class InfoBox
{
    private JLabel velLabel;
    private JTextField velField;
    private JLabel angleLabel;
    private JTextField angleField;
    private JButton submit;
    private JFrame frame;
    public InfoBox(String n, JFrame m)
    {
        velLabel = new JLabel("Velocity (m/s):");
        velField = new JTextField(5);
        angleLabel = new JLabel("Angle (degrees): ");
        angleField = new JTextField(5);
        submit = new JButton("Submit");
    }
    public void draw(JFrame f)
    {
        JPanel info = new JPanel();
        info.setSize(200,200); 
        info.add(velLabel);
        info.add(velField);
        info.add(angleLabel);
        info.add(angleField);
        info.add(submit);
    }
}