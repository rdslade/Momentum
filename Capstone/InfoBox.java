import javax.swing.*;
public class InfoBox extends JPanel
{
    private JLabel velLabel;
    private JTextField velField;
    private JLabel angleLabel;
    private JTextField angleField;
    private JButton submit;
    public InfoBox()
    {
        velLabel = new JLabel("Velocity (m/s):");
        velField = new JTextField(5);
        angleLabel = new JLabel("Angle (degrees): ");
        angleField = new JTextField(5);
        submit = new JButton("Submit");
    }
}