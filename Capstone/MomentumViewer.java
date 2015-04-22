import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Point;
import java.awt.Dimension;
/**
 * Class that contains the main method for the program and creates the frame containing the component
 * 
 * @author @rdslade
 * @version 13 April 2015
 */
public class MomentumViewer
{
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args)
    {
        // create and configure the frame (window) for the program
        JFrame frame = new JFrame();
        int width = 1000;
        int height = 500;
        frame.setSize(width /* x */, height /* y */);
        frame.setTitle("Momentum");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // a frame contains a single component; create the Cityscape component and add it to the frame
        MomentumComponent panel = new MomentumComponent(width,height,frame);
        frame.add(panel);
        frame.setVisible(true);
//         JDialog dialog = new JDialog(frame);
//         dialog.setTitle("Dialog created without extending JDialog class.");
//         dialog.setSize(new Dimension(400, 100));
//         dialog.setModal(true);
//         dialog.setVisible(true);
//         dialog.setAlwaysOnTop(true);
//         dialog.setLocationRelativeTo(frame);
//         dialog.setLocation(new Point(200,200));
        
    

    }

}
