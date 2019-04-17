package TwoDimensionMatrices;    

import java.awt.*;        

import java.awt.event.*;
import javax.swing.*;

public class TwoDimensionalMain {
	 public static void main(String[] args) {
		 JFrame window = new JFrame("2D Matrix Simulator");  
		 window.setSize(600, 480);
		 TwoDimensionalFrame frame = new TwoDimensionalFrame(window.getHeight(), window.getWidth());
		 Listener listener = new Listener(frame);
		 window.setContentPane(frame);
		 window.addKeyListener(listener);
		 
		
	     window.setLocation(100,100);
	     window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	     window.setResizable(false);  // User can't change the window's size.
	     window.setVisible(true);
	 }
}
