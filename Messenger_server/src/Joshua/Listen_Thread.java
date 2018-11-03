package Joshua;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Listen_Thread implements Runnable{
//Write thread to listen for UTF
	DataInputStream input;
	Socket s;
	Server ss;
	String b;
	String name;
	String k;
	
	public Listen_Thread(DataInputStream input, Socket s, String name, Server sss){
		this.s = s;
		this.input = input;
		this.name = name;
		this.ss = sss;
	}
	@Override
	public void run() {
			while(true){
				try{
					System.out.println("before readUTF");
					b = input.readUTF();
					System.out.println("after readUTF" + b);
					k = name + ": " + b;
					ss.sendtoall(b);
				}
				catch(Exception e){
					try {
						e.printStackTrace();
						input.close();
						s.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("error");
					break;
				}
			}
	}
}
