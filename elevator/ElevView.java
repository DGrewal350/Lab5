package elevator;

/**
 *
 * @author daniel.grewal090
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ElevView {
    public static final int WIDTH = 200;
    public static final int HEIGHT = 150;
    public static final int PADDING = 25;
    public static final int INDENT = 40;
    
    private JFrame frame;
    private JLabel floor = new JLabel();
    private JLabel passengers = new JLabel();
    private JLabel direction = new JLabel();
    
    public ElevView() {
        frame = new JFrame("Elevator Status");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        JPanel main = new JPanel();
        main.setBorder(new EmptyBorder(PADDING, PADDING + INDENT, PADDING, -INDENT));
        GridLayout grid = new GridLayout(3,2);
        grid.setHgap(60);
        grid.setVgap(10);
        main.setLayout(grid);
        main.add(new JLabel("Current Floor"));
        main.add(floor);
        JLabel passLabel = new JLabel("Number of Passengers");
        main.add(new JLabel("Number of Passengers"));
        main.add(passengers);
        main.add(new JLabel("Direction"));
        main.add(direction);
        
        
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(main, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    
    // Sets the all fields
    public void updatePane(int current_floor, int pass_num, boolean direct)
    {
        floor.setText(""+current_floor);
        passengers.setText(""+pass_num);
        if (direct) /* true == moving_up */
            direction.setText("UP");
        else
            direction.setText("DOWN");
        frame.repaint();
    }
}
