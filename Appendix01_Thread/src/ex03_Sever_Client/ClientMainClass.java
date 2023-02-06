package ex03_Sever_Client;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMainClass {

	public static void main(String[] args) {
		
		Socket socket = null;
		BufferedWriter writer = null;
		Scanner sc = null;
		
		try {
			
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9090)); // 서버 주소는 localhost이고, 포트 번호는 9090이다.
			
			// socket 정보를 이용하는 클라이언드를 스레드로 생성
			Client client = new Client(socket); // localhost:9090 서버로 연결할 수 있는 socket 정보를 넘김.  
			client.start();
			
			sc = new Scanner(System.in);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.println(">>>");
				String message = sc.nextLine(); // 채팅 내용을 입력
				writer.write(message + "\n");   // 서버가 엔터까지를 입력으로 인식할 수 있도록 \n을 추가해서 보냄
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}