package _ch02;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class P0305 extends JPanel implements ActionListener {
	/*
	 * 
	 */
	private  int WIDTH=300, HEIGHT=300;
	private BufferedImage image;
	private Timer timer;
//	int x1,y1;
	private int x,y;
	private final int Start_x=0,Start_y=250;
	boolean warx=true;
	boolean wary=true;
	
	public P0305() {
		//이미지파일 을 읽어서 image객체로 생성
		//20ms 마다 이벤트를 발생시키는 timer객체를 생성하고 timer를 start시킴 
		File file = new File("src\\spacedong.png");
		try {
			image=ImageIO.read(file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
		x= Start_x;
		y= Start_y;
		timer = new Timer(1,this);
		//this->actionlistner이다
		timer.start();
	}
	
	
	 @Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
//		System.out.println("sdsd");
//		g.drawImage(image, x, y, this);
		//x,y좌표에 이미지를 그린다.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//x,y 좌표 변경
//		if((x<300)&&(y>0)) {
//			x+=1;
//			y-=1;
//		}else if((x>=300)&&(y<250)) {
//			x+=1;
//			y+=1;
//		}else if((x<=600)&&(y>=250)) {
//			x-=1;
//			y+=1;
//		}else if((x<300)&&(y<=500)) {
//			x-=1;
//			y-=1;
//		}
		//x=400
		
		if(x==700) {
			warx=false;
		}else if(x==0) {
			warx=true;
		}
		
		if(y==0) {
			wary=true;
		}else if(y==500) {
			wary=false;
		}
		
		if(warx) {
			x+=1;
		}else {
			x-=1;
		}
		
		if(wary) {
			y+=1;
		}else {
			y-=1;
		}
//		x1=x+1;//x1==401
//		y1=y-1;
//		x=x1;//x==401
//		y=y1;
//		if((x>300)&&(y<0)) {
//			y1=(y+1);
//			x1=(x+1);//x1==402
//		}else if((x>600)&&(y>250)) {
//			x1=(x-1);
//			y1=(y+1);
//		}else if((x<300)&&(y>500)) {
//			x1=(x-1);
//			y1=(y-1);
//		}else if((x>0)&&(y<250)) {
//			x1=(x+1);
//			y1=(y-1);
//		}
			
		
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new P0305());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,800);
		frame.setVisible(true);
	}

}


