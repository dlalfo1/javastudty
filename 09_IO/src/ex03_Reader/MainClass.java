package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {
	
	
	 /*
		Reader
		1. 문자 기반의 입력 스트림이다.
		2. Reader로 끝나는 이름의 클래스는 모두 문자 기반의 입력 스트림이다.
		3. 문자를 읽어 들이는 스트림이다. (파일의 내용을 읽는다. 서버가 보낸 내용을 읽는다. 등등)
	 */
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex01.txt");
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(file); // 여기서 FileNotFoundException이 발생할 수 있는데
			
			int c; // 1글자를 저장할 변수
				   // 글자를 int타입으로 저장하는 이유는 char타입에 모든 문자를 저장할 수 없기때문이다. 그래서 범위가 더 큰 int를 써준다.
				  
			// 외우기
			StringBuilder sb = new StringBuilder();
			while((c = fr.read()) != -1) { // 문자 가져오는걸 반복하다보면 가져올 문자가 없을 때가 있을텐데 
										   // 그럴땐 -1이 출력된다. 그러니까 -1이 아니라면 계속 무한반복해라 = -1이되면 멈춤.
										   // 읽어올 때 int로 저장했기 때문에 char타입으로 출력해줘야 한다. 아니면 유니코드 숫자나온다.
				sb.append((char)c);
			}
				
		    System.out.print(sb.toString());
			
		
//			c = fr.read();
//			
//			StringBuilder sb = new StringBuilder();
			
			
		} catch(IOException e) { // 부모가 IOException이라 함께 처리된다.
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static void ex02() {
		
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex02.txt");
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(file);
			
			char[] cbuf = new char[5]; // 5글자를 읽어 들이는 배열
			int readCount = 0; // 실제로 읽은 글자의 개수
			StringBuilder sb = new StringBuilder();
			
			while((readCount = fr.read(cbuf)) != -1) {
									// FileReader 클래스의 read() 메소드는 인자로 입력받는 값의 파일의 데이터를 읽어 저장한다.
									// 그리고 파일에서 읽은 문자의 개수를 리턴한다.
									// read() 메소드를 사용하는 프로그래머는 리턴되는 숫자를 이용해서 버퍼에 있는 데이터를 String 객체로 생성해서 사용하게 된다.
									
				sb.append(cbuf, 0, readCount); // 인덱스 0부터 readCount개 글자를 추가하시오.
				
				// ex02.txt 읽는 과정
				//루프 readCount	cbuf
				// 1 	5			a b c d e
				// 2 	2 저장		f g c d e // 캐릭터버퍼가 fg가져와서 앞의 a b 를 덮어버림 그래서 for문 돌릴때 횟수를 리드카운터로 한거임 . 배열의길이가 아니라.
				// 3   -1
				
				// for(int i = 0; i < readCount; i++) {
				//	System.out.print(cbuf[i]);
				// }
			}
		
			System.out.println(sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if(fr != null)
				fr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	public static void ex03() {
		
		/*
			BufferedReader의 장점
			1. 속도가 빠르다
			2. readLine 메소드를 사용할 수 있다.
		
		*/
		
		// 이거말고 아래 예제 보기 이건 그냥 남겨둔거
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex03.txt");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			char [] cbuf = new char[5];
			int readCount = 0; 
			
			StringBuilder sb = new StringBuilder();
			
			while((readCount = br.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex04() {
		
		/*
		 
		BufferedReader의 장점
		1. 속도가 빠르다
		2. readLine 메소드를 사용할 수 있다.
		 
		 */
	
	
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex04.txt");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			// 왕중요
			
			String line = null; // line 메소드는 배열이고 뭐고 없음 그러니까 String값으로 받아서 저장함.
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
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
