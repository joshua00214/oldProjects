package Joshua;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private ServerSocket ss;
	private Socket s;
	private ArrayList<Socket> sockets = new ArrayList<Socket>();
	private DataOutputStream output;
	private ArrayList<DataOutputStream> outputs = new ArrayList<DataOutputStream>();
	private DataInputStream input;
	int x = 0;
	String name;
	int z = 0;
		public Server(int port){
			makeserver(port);
		}
		private void makeserver(int port) {
			try {
				ss = new ServerSocket(port);
				System.out.println(z++);
				while(true){
				s = ss.accept();
				System.out.println(z++);

				sockets.add(x, s);
				System.out.println(z++);

				output = new DataOutputStream(sockets.get(x).getOutputStream());
				System.out.println(z++);

				outputs.add(x++, output);
				System.out.println(z++);

				DataInputStream input = new DataInputStream(s.getInputStream());
				System.out.println(z++);
				name = input.readUTF();
				Thread a = new Thread(new Listen_Thread(input, s, name, this));
				System.out.println(z++);

				a.start();
				System.out.println(z++);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			public void sendtoall(String b){
			int y = x;
			for(int a = 0; y>a; a++){
				try {
					outputs.get(a).writeUTF(b);
				} catch (IOException e) {
					try {
						outputs.get(a).close();
						sockets.get(a).close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
}
