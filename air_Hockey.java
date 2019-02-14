package airHockey;
import javax.swing.*;
public class air_Hockey {
	public static void main(String []args){
		JFrame obj = new JFrame();
		obj.setBounds(100,100,1200,800);
		playTable game = new playTable();
		obj.setTitle("Brickout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(game);			
	}
}
