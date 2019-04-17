package TwoDimensionMatrices;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.Timer;

public class Listener implements KeyListener {
	
	TwoDimensionalFrame frame;
	
	public Listener (TwoDimensionalFrame temp) {
		frame = temp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == e.VK_RIGHT) {
			frame.rotate(10.0, "XZ");
		}
	 if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			frame.rotate(-10.0, "XZ");
		}
		 if (e.getKeyCode() == KeyEvent.VK_UP) {
			frame.rotate(10.0, "YZ");
		}
		 if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			frame.rotate(-10.0, "YZ");
		}
		 if (e.getKeyCode() == KeyEvent.VK_W) {
			frame.rotate(10.0, "XY");
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			frame.rotate(-10.0, "XY");
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
