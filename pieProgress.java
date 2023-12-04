import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pieProgress extends JFrame {

    JButton name1 = new JButton("1");
    JButton name2 = new JButton("2");
    JButton name3 = new JButton("3");
    JPanel Secondpanel = new JPanel(new GridLayout(1, 3));

    private int currentValue1 = 0;
    private int currentValue2 = 0;
    private int currentValue3 = 0;
    private double angle1 = 0;
    private double angle2 = 0;
    private double angle3 = 0;
    private int total = 0;

    public pieProgress() {
        super("JProgressBar Test");

        Secondpanel.add(name1);
        Secondpanel.add(name2);
        Secondpanel.add(name3);

        add("South", Secondpanel);
        setSize(500, 500);
        setVisible(true);

        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == name1) {
                    currentValue1++;
                }
                if (e.getSource() == name2) {
                    currentValue2++;
                }
                if (e.getSource() == name3) {
                    currentValue3++;
                }

                total = currentValue1 + currentValue2 + currentValue3;
                angle1 = (360.0 * currentValue1 / total);
                angle2 = (360.0 * currentValue2 / total);
                angle3 = (360.0 * currentValue3 / total);

                repaint();
            }
        };

        name1.addActionListener(action);
        name2.addActionListener(action);
        name3.addActionListener(action);
    }

    public void paint(Graphics g) {
        super.paint(g);

        int x = 100;
        int y = 100;
        int width = 200;
        int height = 200;

        g.setColor(Color.RED);
        g.fillArc(x, y, width, height, 0, (int) angle1);
        g.setColor(Color.GREEN);
        g.fillArc(x, y, width, height, (int) angle1, (int) angle2);
        g.setColor(Color.BLUE);
        g.fillArc(x, y, width, height, (int) (angle1 + angle2), (int) angle3);
    }

    public static void main(String[] args) {
        new pieProgress();
    }
}
