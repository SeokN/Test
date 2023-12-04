/*
ProgressBarDemo

*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class verticalProgress extends JFrame {
	
	JProgressBar bar1 = new JProgressBar(JProgressBar.VERTICAL, 0, 1000);
	JProgressBar bar2 = new JProgressBar(JProgressBar.VERTICAL, 0, 1000);
	JProgressBar bar3 = new JProgressBar(JProgressBar.VERTICAL, 0, 1000);
	JButton name1 = new JButton("1");
	JButton name2 = new JButton("2");
	JButton name3 = new JButton("3");
	JPanel Firstpanel = new JPanel(new GridLayout(1, 3));
	JPanel Secondpanel = new JPanel(new GridLayout(1, 3));
	ProgressMonitor monitor;
	private int currentValue1 = 0;
	private int currentValue2 = 0;
	private int currentValue3 = 0;
	private int total = 0;
	
	public verticalProgress() {
		
		super("JProgressBar Test");

		Firstpanel.add(bar1);		
		Firstpanel.add(bar2);
        Firstpanel.add(bar3);
		Secondpanel.add(name1);
		Secondpanel.add(name2);
        Secondpanel.add(name3);
		
		
		add("Center", Firstpanel);
		add("South", Secondpanel);
		setSize(500,500);
		setVisible(true);

		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == name1) {
					currentValue1++;
				}
				if(e.getSource() == name2) {
					currentValue2++;
				}
				if(e.getSource() == name3) {
					currentValue3++;
				}
				total = currentValue1 + currentValue2 + currentValue3;
				bar1.setValue(1000*currentValue1/total);
				bar1.setStringPainted(true);
				
				bar2.setValue(1000*currentValue2/total);
				bar2.setStringPainted(true);
				
				bar3.setValue(1000*currentValue3/total);
				bar3.setStringPainted(true);
				
			}
		};

		name1.addActionListener(action);
		name2.addActionListener(action);
		name3.addActionListener(action);
	}
	
	// task inner class

		
	public static void main(String[] args) {
		new verticalProgress();		
	}
	
}