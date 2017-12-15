import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TemperatureWindow extends JFrame implements ActionListener {
    private Container pane;
    private JTextField t;
    private JButton FtoC;
    private JButton CtoF;
    
    public TemperatureWindow() {
	this.setTitle("Temperature Converter");
	this.setSize(300,200);
	this.setLocation(100,50);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	t = new JTextField(20);
	FtoC = new JButton("Fahrenheit to Celsius");
	CtoF = new JButton("Celsius to Fahrenheit");

	FtoC.addActionListener(this);
	CtoF.addActionListener(this);

	pane.add(t);
	pane.add(FtoC);
	pane.add(CtoF);
	
    }
    
    public static double CtoF(double t) {
	return (t - 32) / 1.8;
    }
    
    public static double FtoC(double t) {
	return t * 1.8 + 32;
    }

    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();
	if (event.equals("Convert")) {
	    // do event
	}
    }
    
    public static void main(String[] args) {
	
    }
}
