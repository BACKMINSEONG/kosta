package net.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServerTest {

	public static void main(String[] args) {
		int port = 5432;
		ServerSocket ss = null;
		String clientIP = null;
		try {
			//1. port 열기.
			ss = new ServerSocket(port);
			while(true) {
			//2. 클라이언트 기다리기. 소켓생성.
				Socket s = null;
				DataInputStream dis = null;
				try {
					s = ss.accept();
					InetAddress client = s.getInetAddress();
					clientIP = client.getHostAddress();
					dis = new DataInputStream(s.getInputStream());
					String receiveData = null;
					while(!(receiveData = dis.readUTF()).equals("quit")){
						System.out.println(clientIP+"가 보내준 내용:"+receiveData);
						
					}
				} catch (SocketException e) {
				
				} catch (IOException e) {
					
				} finally {
					try {
						s.close();
					}catch(IOException e) {
						
					}
					System.out.println(clientIP==null?"클라이언트":clientIP);
					System.out.println("클라이언트와 연결을 종료합니다");
				}	
			}
//			receiveData = dis.readUTF();
//			receiveData = dis.readUTF();
//			System.out.println("클라이언트가 보내준 내용:"+receiveData);
		} catch (BindException e) {
			System.out.println(port + "포트가 이미 사용중입니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ss != null) {
				try {
					ss.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	

}
