package joshua;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MGUI extends JFrame implements ActionListener{
private InetAddress inet;
private Socket s = new Socket();
private DataOutputStream output;
private DataInputStream input;
private JButton send;
private JTextArea tarea;
private JTextField tf;
private JTextField ip;
private JTextField port;
private JButton connect;
private JPanel one;
private JPanel two;
private CardLayout cardlayout;
private JPanel cards;
private JTextField uname;
private JScrollPane scroll;
String a;
MServer server;
public String name;
												//contructor
	public MGUI() {
		super("Messenger v2.0");
		
		cards = new JPanel(new CardLayout());
		tarea = new JTextArea(10,30);
		scroll = new JScrollPane(tarea);
		tf = new JTextField("type your message here", 20);
		send = new JButton("Send");
		ip = new JTextField("ip", 5);
		port = new JTextField("port", 5);
		connect = new JButton("Connect");
		uname = new JTextField("Type your username", 13);
		
		one = new JPanel();
		one();
		two = new JPanel();
		two();
		cards.add(one, "1");
		cards.add(two, "2");
		
		first();
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("before server.send");
					server.send(name + ": "+ tf.getText());
				} catch (Exception e1) {
					System.out.println("error running send method in object 'server' ");
				}
			}
		});
	}//end constructor
	
	
	
												//one method
	public void one(){
		one.add(ip);
		one.add(port);
		one.add(uname);
		one.add(connect);
		
	}//end one method
											//two method
	
	
	
	public void two(){
		two.add(scroll);
		two.add(tf);
		two.add(send);
		
	}//end two method
											//first method
	
	
	
	public void first(){
		add(cards);
		cardlayout = (CardLayout) cards.getLayout();
		cardlayout.show(cards, "1");
		
		connect.addActionListener(this);
		
	}//end first method
											//second method
	
	
	
	public void second(){
		cardlayout.show(cards, "2");
		setSize(400, 300);
	}//end second method
										//action performed
	public void recived(String j){
		String e = tarea.getText();
		String b = e + "\n" + j;
		tarea.setText(b);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == connect){
			second();
			String ip = this.ip.getText();
			String port = this.port.getText();
			name = uname.getText();
			server = new MServer(ip, port, uname.getText(), this);
			try {
				server.connect();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
			second();
		}
		/*
		if(e.getSource() == send){
			try {
				System.out.println("before server.send");
				server.send(name + ": "+ tf.getText());
			} catch (Exception e1) {
				System.out.println("error running send method in object 'server' ");
			}
		}
		*/
	}//end actionperformed
}