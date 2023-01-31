package ex02_socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMainClass {

	
	public static void ex01() { // 그냥 이런 개념이 있구나~ 정도 이해하기..어차피 채팅서비스 만들 때 사용 안 되는 코드임.
		
		// SeverSocket서버가 사용하는 Socket
		ServerSocket serverSocket = null;
		
		try {
			
			serverSocket = new ServerSocket(); // IOException 처리가 필요하다.
			
			// InetSocketAddress : Socket 사용시 "호스트", "포트번호(데이터를 주고받기 위한 채널 개념)"를 관리하는 클래스
			InetSocketAddress address = new InetSocketAddress("localhost", 9090); // 완성되는 주소 - localhost:9090
			
			// bind : ServerSocket에 InetSocketAddress 정보 전달 - localhost:9090이 서버 주소이다.
			serverSocket.bind(address);
			
			// 무한루프로 serverSocket 구성
			
			while(true) {
				
				System.out.println("[서버] 클라이언트 접속을 기다리고 있습니다.");
				
				// 클라이언트의 접속 요청을 허용
				Socket clientSocket = serverSocket.accept(); // 누군가가 접속을 하면 이 메소드가 사용돈다.
															 // 누군가 localhost:9090 이 주소로 접속하기 전까지 무한루프가 계속 돈다.
				
				// 클라이언트의 접속 확인을 위해서 InetSocetAddress를 활용
				InetSocketAddress clientAddress =  (InetSocketAddress)clientSocket.getRemoteSocketAddress(); // 누군가 접속하면 이게 돈다.
				System.out.println("[서버]접속된 클라이언트 " + clientAddress.getHostName()); 
				
				// 클라이언트에게 welcome 메시지 보내기
				// DataOutputStream(한글 가능)을 clientSocket 달아줘야한다(클라이언트가 여러명일 경우 serverSocket에 달면 하나밖에 못 달기 때문에)
				DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
				out.writeUTF("어서오세요 환영합니다"); //writeUTF 메소드를 이용하면 바이트 스트림으로도 한글 깨짐 없이 데이터를 보낼 수 있다
				
				// 반갑습니다 받아서 출력하기
				
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String line = null;
				StringBuilder sb = new StringBuilder();
				
				while((line = in.readLine()) != null) {
					sb.append(line + "\n");
				}
				
				System.out.println("[서버]" + sb.toString());
				
				// 스트림 종료
				out.close();
				in.close();
				
				// 클라이언트 접속 종료
				clientSocket.close();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		ex01();
	}

}
