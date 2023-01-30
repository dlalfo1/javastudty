package ex04_OutPutSteram;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


	/*
	 	- 이클립스에서 외부의 데이터를 입력받을 때는 입력 스트림(InputStream)
	
	    - 이클립스에서 외부에 데이터를 보낼 때는 출력 스트림(OutputStream)
	
	
	*/

public class MainClass {
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir , "ex01.bin");
		
		FileOutputStream fos = null; // 이클립스 -> 외부 파일로 연결되는 출력 스트림 fos를 열어준다.
										// (갈 수 있는 데이터는 int, byte[] 이다.)
		
		try {
			
			fos = new FileOutputStream(file); // dir경로에 "ex01.bin" file을 FileOutputStream을 통해서 보내준다.
			
			// 출력 단위
			// 1. int	 : 1개
			// 2. byte[] : 2개 이상
			 
			int c = 'A';
			String str = "pple"; // byte 배열로 바꿀 String을 준비한다.
			byte[] b = str.getBytes(); // getBytes 메소드를 사용해서 String 바이트 byte배열로 바꿔준다.
									   // 출력 스트림을 통해서 갈 수 있는 데이터는 int, byte[]이기 때문이다.
			
			// fos 스트림으로 c,b의 값을 보내준다.(write 메소드 사용)
			
			fos.write(c); // 출력 스트림을 통해서 생성된 "ex01.bin" 파일에 입력할 데이터들을 write메소드 기능을 사용해서 넣어준다.
			
			fos.write(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if(fos != null) {
				fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex02() {
		
		// 한글을 바이트 스트림으로 내보낼 때 인코딩해서 내보내는 방법 알아보기.
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex02.bin");
		
		
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			
			String str = "안녕하세요";
			
			// getBytes(CharSet charSet) 1.7버전 이상 사용가능하다
			byte[] b = str.getBytes(StandardCharsets.UTF_8); //  UTF-8 로 인코딩 해달라.
			
			// getBytes(String charsetName) 1.7버전 이하는 String을 사용해야 한다. 사실 오타만 나지 않으면 스트링값으로 "UTF-8" 적으면 된다.ㅏ        
			// byte [] b = str.getBytes("UTF-8"); 
			
			fos.write(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex02.bin 파일의 크기 : " + file.length() + "바이트"); // length 메소드 : 파일의 길이(byte)를 알 수 있다.
		
	}
		
	public static void ex03() {
		
		
		File dir = new File("C:" + File.separator + "storage"); 
		File file = new File(dir, "ex03.bin");
		// File file = new File(C:" + File.separator + "storage", "ex02.bin"); 이렇게 만들어도 된다.
		// 하지만 dir을 만들어두면 디렉토리 관련 작업도 할 수 있으니 만들어주는 것이다. 여기까진 파일 객체만 생성해두는거고
		
		
		BufferedOutputStream bos = null; 
		// FileOutputStream 선언 대신 BufferedOutputStream 만들면서 안에 넣어준다.
		try {
			bos = new BufferedOutputStream(new FileOutputStream(file)); // 여기서 파일이 생기는 것.
		    // new FileOutputStream(file)에 new BufferedOutputStream을 끼운 것이다.(메인스트림에 보조스트림을 끼운다)
			bos.write("반갑습니다\n또만나요".getBytes("UTF-8")); // \n : 1byte
			
			// bos.close(); 현실적으로 여기에 쓴다. 그럼 finally문이 아예 필요없다. 여기에 써도 딱히 문제되지는 않음.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
					bos.close(); // bos 스트림 닫는거 권장은 finally 문 안의 if문 안인데
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex03.bin 파일의 크기는 : " + file.length() + "바이트");
	}
	
	public static void ex04() {
		
		// 변슈를 그대로 출력하는 DataOutPutSteram
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex04.dat");
		
		DataOutputStream dos = null;
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(file));
			
			String name = "에밀리"; // 18바이트
			int age = 30; // 1바이트
			double height = 180.5; // 1바이트
			boolean isAlive = true; // boolean 크기를 정할 수없음..?
			
			// 출력(변수 타입에 따라서 메소드가 다름)
			dos.writeUTF(name); // UTF처리(다국어) 해서 내보내준다. 한글이니까 이걸로 하기.
			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeBoolean(isAlive);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) {
					dos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex04.dat 파일의 크기는 : " + file.length() + "바이트");
		
		
	}
	
	public static void ex05() {
		
		// 객체를 그대로 출력하는 ObjectOutPutStream
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex05.dat");
		
		ObjectOutputStream oos = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 출력할 객체
			List<Person> people = Arrays.asList(
					new Person("에밀리", 30, 180.5, true) ,
					new Person("제시카", 35, 190.5, true)
			);
			
			// 출력할 객체
			Person person = new Person();
			person.setName("제임스");
			person.setAge(40);
			person.setHeight(170.5);
			person.setAlive(false);
			
			oos.writeObject(people);
			oos.writeObject(person);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("ex05.dat 파일의 크기 : " + file.length() + "바이트");
		
	}

	public static void main(String[] args) {
		ex01();
	}

}
