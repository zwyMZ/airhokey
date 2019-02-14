package airHockey;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
public class playTable extends JPanel implements  ActionListener,KeyListener{
	private int ScoreP1, ScoreP2=0;
	private Timer timer;
	private int delay=8;
	private Rectangle hockey;
	private int Width=1200;
	private int Height=800;
	private int Player1=300;
	private int Player2=300;
	private boolean start,end;
	private int hockeyposX=Width/2-10;
	private int hockeyposY=Height/2-10;
	private int ballXdir=-10;
	private int ballYdir=-2;
	private boolean p1win;
	
	public playTable(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		
	}
	public void paint(Graphics g){
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, Width, Height);
		//hockey
		g.setColor(Color.yellow);
		g.fillOval(hockeyposX, hockeyposY,20, 20);
		//border
		g.setColor(Color.green);
		g.fillRect(0, 0, Width, 3);
		g.setColor(Color.green);
		g.fillRect(0, 768, Width,3);
		//hockey stick
		g.setColor(Color.red);
		g.fillRect(1100, Player1, 8, 200);
		g.setColor(Color.blue);
		g.fillRect(100, Player2, 8, 200);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",1,20));
		if(!start){
			g.drawString("Press to start!",Width/2,Height/2-50);
		}
		if(end){
			if(p1win){
				g.drawString("P1 Win !!!    Press Space to restart",Width/2-50,Height/2-50);
			}else{
				g.drawString("P2 Win !!!    Press Space to restart",Width/2-50,Height/2-50);
			}
		}
		g.dispose();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();
		if(start){
			hockeyposX+=ballXdir;
			hockeyposY+=ballYdir;
			if(new Rectangle(hockeyposX,hockeyposY,20,20).intersects(new Rectangle(100,Player2,8,200))){
				ballXdir=-ballXdir;
			}
			if(new Rectangle(hockeyposX,hockeyposY,20,20).intersects(new Rectangle(1100,Player1,8,200))){
				ballXdir=-ballXdir;
			}
			if(hockeyposY<0){
				ballYdir=-ballYdir;
			}
			if(hockeyposY>762){
				ballYdir=-ballYdir;
			}
			if(hockeyposX<=0 ){
				end=true;
			}
			if(hockeyposX>=1200){
				end=true;
				p1win=true;
			}
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
			if(Player1>=560){
				Player1=560;
			}else{
				shiftDown();
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_UP){
			if(Player1<=10){
				Player1=10;
			}else{
				shiftUp();
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_S){
			if(Player2>=560){
				Player2=560;
			}else{
				shiftDown2();
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_W){
			if(Player2<=10){
				Player2=10;
			}else{
				shiftUp2();
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
			if(end){
				hockeyposX=Width/2-10;
				hockeyposY=Height/2-10;
				end=false;
				start=false;
			}
		}

	}
	public void shiftDown(){
		start=true;
		Player1+=20;
	}
	public void shiftUp(){
		start=true;
		Player1-=20;
	}
	
	public void shiftDown2(){
		start=true;
		Player2+=20;
	}
	public void shiftUp2(){
		start=true;
		Player2-=20;
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
