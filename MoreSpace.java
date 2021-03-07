package _ch02;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Float;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoreSpace extends JFrame{
	
	public MoreSpace() {
		setSize(600,200);
		setTitle("2d");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel j = new MyPanel();
		add(j);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MoreSpace();
	}

}

class MyPanel extends JPanel{
	ArrayList<Shape> shapearr = new ArrayList<Shape>();
	
	public MyPanel() {
		
		Shape s;
		
		
		
		
		s= new Rectangle2D.Float(10,10,70,80);
		shapearr.add(s);
		
		s=new RoundRectangle2D.Float(110,10,70,80,20,20);
		shapearr.add(s);
		
		s=new Ellipse2D.Float(210,10,80,80);
		shapearr.add(s);
		
		s=new Arc2D.Float(310,10,80,80,90,90,Arc2D.OPEN);
		shapearr.add(s);
		
		s=new Arc2D.Float(410,10,80,80,0,180,Arc2D.CHORD);
		shapearr.add(s);
		
		s=new Arc2D.Float(510,10,80,80,45,90,Arc2D.PIE);
		shapearr.add(s);
	
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING	, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(3));
		
		GradientPaint gp = new GradientPaint(0, 10, Color.white, 0, 70, Color.red);
		
		
		for(Shape s : shapearr) {
			g2.setPaint(gp);
			g2.fill(s);
			g2.draw(s);
		}
	}
}
