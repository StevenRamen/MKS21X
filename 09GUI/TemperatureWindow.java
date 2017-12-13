import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TemperatureWindow extends JFrame implements ActionListener {
    private JTextField t;
    private JRadioButton f;
    private JRadioButton c;
    private JButton b;
    
    public TemperatureWindow() {
	this.setTitle("Temperature Converter");
	this.setSize(300,200);
	this.setLocation(100,50);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	t = new JTextField(20);

	f = new JRadioButton(Fahrenheit);
	f.setSelected(true);
	f.addActionListener(this);
	
	c = new JRadioButton(Celsius);
	c.addActionListener(this);

	ButtonGroup group = new ButtonGroup();
	group.add(f);
	group.add(c);
	
	b = new Jbutton("Convert");
	b.addActionListener(this);

	pane.add(t);
	
	pane.add(b);
	
    }
    
    public static void CtoF(double t) {
	return (t - 32) / 1.8;
    }
    
    public static void FtoC(double t) {
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
