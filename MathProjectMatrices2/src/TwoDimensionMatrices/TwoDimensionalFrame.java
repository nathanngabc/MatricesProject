package TwoDimensionMatrices;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class TwoDimensionalFrame extends JPanel{
	
	//vertix[] vertices = new vertix[] {new vertix (50, 50, -50), new vertix (-50, 50, -50), new vertix (-50, -50, -50), new vertix (50, -50, -50), new vertix (50, 50, 50), new vertix (-50, 50, 50), new vertix (-50, -50, 50), new vertix (50, -50, 50)};
	//int[][] lines = new int[][] {{0,1}, {1,2}, {2,3}, {3,0}, {4,5}, {5,6}, {6,7}, {7,4}, {0,4}, {1,5}, {2,6}, {3,7}};

	//vertix[] vertices = new vertix[] {new vertix (-50, 50, -50), new vertix (50, 50, -50), new vertix (50, -50, -50), new vertix (-50, -50, -50), new vertix (0, 0, 100)};
	//int[][] lines = new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 4}, {1, 4}, {2, 4}, {3, 4}};
	
	vertix[] vertices = new vertix[] {new vertix (-56, 82, 0), new vertix (0, 34, 0), new vertix (56, 82, 0), new vertix (36, -2, 0), new vertix (110, -38, 0), new vertix (24, -38, 0), new vertix (0, -110, 0), new vertix (-24, -38, 0), new vertix (-108, -38, 0), new vertix (-36, -2, 0), new vertix (0, 0, 50), new vertix (0, 0, -50)};
	int[][] lines = new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 0}, 
								{0, 10}, {1, 10}, {2, 10}, {3, 10}, {4, 10}, {5, 10}, {6, 10}, {7, 10}, {8, 10}, {9, 10},
								{0, 11}, {1, 11}, {2, 11}, {3, 11}, {4, 11}, {5, 11}, {6, 11}, {7, 11}, {8, 11}, {9, 11}};
	
	RandomShape square = new RandomShape (vertices,vertices.length);
	
	int height, width;
	
	public TwoDimensionalFrame (int height, int width) {
		this.height = height;
		this.width = width;

	}
	
	private void addDimensions(int height, int width) {
		for (int i = 0; i < vertices.length; i++) {
			vertices[i].x+=width/2;
			vertices[i].y+=height/2;

		}
	}
	
	private void subDimensions(int height, int width) {
		for (int i = 0; i < vertices.length; i++) {
			vertices[i].x-=width/2;
			vertices[i].y-=height/2;

		}
	}

	public void paintComponent(Graphics g) {

		
 		Graphics2D g2 = (Graphics2D) g;
		addDimensions (height, width);
		
		for (int i = 0; i<lines.length; i++) {
			g2.draw(new Line2D.Double(vertices[lines[i][0]].x, vertices[lines[i][0]].y, vertices[lines[i][1]].x, vertices[lines[i][1]].y));
		}
		
		subDimensions (height, width);	
	}
	
	public void rotate(Double angle, String direction) {

		double[][] transformMatrixOne = square.rotate(angle, direction);

	
		repaint();
	}
	


}
