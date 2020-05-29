import java.net.*;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import java.io.*;


public class Server{
	
	
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	private static ServerSocket server;
	private static Socket conn;
	public static boolean playerjoined =false;
		public Server() {
			
		}
		public static void runServer() {
			try {
				server = new ServerSocket(6666,100);
				while(true) {
					try {
						waitConn();
						streams();
						Participants();
						processConn();
					}
					catch(EOFException e){
						dispMessage("\nServer Terminated Conn\n");
					}
					finally {
						closeConn();
					}
				}
			}
			catch(IOException e) {
				
			}
		}
		public static void drawdata() throws IOException{
			oos.writeByte(2);
			int info[] = new int[5];



		}
		private static void Participants() throws IOException{
			String Nickname =Source.Nickname;
			oos.writeObject(Nickname);
			try {
				Nickname = (String) ois.readObject();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			gameScreen.participantScreen.append(Nickname);
		}
		private static void waitConn() throws IOException{
			dispMessage("Please wait...\n");
			conn = server.accept();
			dispMessage("New Player Has Joined The Room!!\n");
			playerjoined =true;
			
		}
		private static void streams() throws IOException {
			oos = new ObjectOutputStream(conn.getOutputStream());
			oos.flush();
			
			ois = new ObjectInputStream(conn.getInputStream());
		}
		private static void processConn() throws IOException{
			String msg = "";
			do {
				try {
					byte a = ois.readByte();
					if (a == 1) {
						msg = (String) ois.readObject();
						dispMessage(msg);
					}
				}catch(ClassNotFoundException e){
					dispMessage("Unknown");
					
				}
				
			} while(!msg.equals("C:ExitTheSystem"));
		}
		private static void closeConn() {
			dispMessage("\nTerminating Conn\n");
			
			try {
				oos.close();
				ois.close();
				conn.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		public static void send(String Nickname, String text) {
			try {
				oos.writeByte(1);
				oos.writeObject(Nickname+": "+text+"\n");
				oos.flush();
				dispMessage(Nickname + ": " +text+"\n");
			}
			catch(IOException e){
				gameScreen.chatScreen.append("\nError"); //jt is text area
				
			}
		}
		private static void dispMessage(final String string) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					gameScreen.chatScreen.append(string);
					
				}
			});
			
		}
		public static void sendpaintinfo(int m,int x,int y,int ox,int oy){
			int[] a = new int[4];
			try {

				a[0]=m;
				a[1]=x;
				a[2]=y;
				a[3]=ox;
				a[4]=oy;
				oos.writeByte(2);
				oos.writeObject(a);
				oos.flush();



			}
			catch (IOException e)
			{
				System.out.println("error at sending mouse cords: "+e);
			}
		}
}