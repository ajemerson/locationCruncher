import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	private JTextField distanceParameter;
	private JTextField timeParameter;
	private JButton calculateInteractions;
	private Color randomColor = new Color(254, 191, 26);	//Color of PatientZero yellow
	
	public ControlPanel(int x_dimension, int y_dimension) {
		this.setSize(x_dimension,y_dimension);
		this.setBackground(randomColor);
		
		distanceParameter = new JTextField("Distance (in km)");
		timeParameter = new JTextField("Time (in ms)");
		calculateInteractions = new JButton("Calculate Interactions");
		
		distanceParameter.addActionListener(new JTextFieldListener());
		timeParameter.addActionListener(new JTextFieldListener());
		calculateInteractions.addActionListener(new JButtonListener());
		
		this.add(distanceParameter);
		this.add(timeParameter);
		this.add(calculateInteractions);
	}
	
	private class JTextFieldListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class JButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			InteractionHandler interactions = 
					new InteractionHandler(Double.parseDouble(distanceParameter.getText()),
							Long.parseLong(timeParameter.getText()));
			interactions.createCSV();
		}
	}
}