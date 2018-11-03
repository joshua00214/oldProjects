package joshua;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MServer implements Runnable{
private String ip, port;
Socket ss;
InetAddress inet;
private DataOutputStream output;
private DataInputStream input;
MGUI mgui;
String j;
int x = 0;
String name;
	public MServer(String ip, String port, String name, MGUI mgui) {
		this.ip = ip;
		this.port = port;
		this.name = name;
		this.mgui = mgui;
	}
		public void connect(){
			try {
				inet = InetAddress.getByName(ip);
				ss = new Socket(inet, Integer.parseInt(port));
				 output = new DataOutputStream(ss.getOutputStream());
				 input = new DataInputStream(ss.getInputStream());
				 j = (name + ": has connected");
				 send(j);
				Thread th = new Thread(this);
				th.start();
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void send(String b){
			try {
				
				System.out.println("before writing UTF");
				output.writeUTF(b);
				System.out.println("After writing UTF " + b);
				//mgui.recived(b);
				
			} catch (IOException e) {
				try{
					e.printStackTrace();
				output.close();
				input.close();
				ss.close();
				}
				catch(Exception r){
					System.out.println("error closeing stream");
				}
			}
		}
		@Override
		public void run() {
			while(true){
				try{
				mgui.recived(input.readUTF());
				
				}catch(Exception e){
					break;
	}
				
			}
		}
}
