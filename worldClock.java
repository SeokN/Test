import java.text.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class worldClock extends JFrame {

    private JTextField textField;

    public worldClock() {
        super("WorldClock");
        JPanel panel = new JPanel(new GridLayout(2, 1));

        String[] world = {"Asia/Seoul", "JST", "America/Los_Angeles", "America/New_York", "Pacific/Honolulu"};
        JComboBox<String> combo = new JComboBox<>(world);
        panel.add(combo);

        textField = new JTextField();
        JScrollPane sp = new JScrollPane(textField);
        sp.setPreferredSize(new Dimension(250, 250));
        panel.add(textField);

        add(panel);
        setBounds(300, 200, 300, 100);
        setVisible(true);

        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedTimeZone = combo.getSelectedItem().toString();
                TimeZone timeZone = TimeZone.getTimeZone(selectedTimeZone);
                Date date = new Date();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (z Z)");
                df.setTimeZone(timeZone);
                textField.setText(df.format(date));
            }
        };

        combo.addActionListener(action);
    }

    public static void main(String args[]) {
        new worldClock();
    }
}
