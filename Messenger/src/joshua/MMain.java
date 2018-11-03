package joshua;

import javax.swing.JFrame;

public class MMain {
	public static void main(String args[]){
		MGUI gui = new MGUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(200, 300);
		gui.setVisible(true);
	}
}
