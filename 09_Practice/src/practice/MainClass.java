package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MainClass {

	
	
	// 문제1. 현재 시간을 이용하여 디렉터리를 생성하시오
	// 예시)
	// C:\14\31\30 실행하는 시간을 폴더로 만들기
	public static void ex01() {
		
		LocalTime now = LocalTime.now();	
		
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		String sep = File.separator;
		File dir = new File("C:" + sep + hour + sep + minute + sep + second);
		
		if(dir.exists() == false) {
			dir.mkdirs();
		} 
	}

	// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.
		
	/*
		2023-01-04  오후 02:19    <DIR>          bin
		2023-01-04  오후 02:19    <DIR>          conf
		2023-01-04  오후 02:19    <DIR>          include
		2023-01-04  오후 02:19    <DIR>          jmods
		2023-01-04  오후 02:19    <DIR>          legal
		2023-01-04  오후 02:19    <DIR>          lib
		2023-01-04  오후 02:19               160 README.html
		2023-01-04  오후 02:19             1,302 release
		               2개 파일               1,462 바이트
		*/
	
	public static void ex02() {
		
		
		File dir = new File("C:" + File.separator + "Program Files" + File.separator + "Java" + File.separator + "jdk-11.0.17");
		
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			int fileCount = 0;
			long totalFileSize = 0;
			for(File file : list) {
				if(file.isHidden()) {
					continue; // 숨김파일은 실행에서 제외한다.
				}
				String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd  a hh:mm").format(file.lastModified());
				String directory = file.isDirectory() ? "<DIR>" : "";
				String size = "";
				if(file.isFile()) {
					long length = file.length();
					size = new DecimalFormat("#,##0").format(length);
					fileCount++;
					totalFileSize += length;
				}
				String name = file.getName();
				String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name);
				System.out.print(result);
			}
			System.out.println(fileCount + "개 파일" + new DecimalFormat("#,##0").format(totalFileSize) + "바이트");
		}
	}	
	
	// 문제3. C:\storage 디렉터리를 삭제하시오.
	// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		
		/* 저장된 파일이 myfile.txt 뿐이라는 걸 알고 있어서 이런 코드가 나왔죠.
		File file = new File(dir, "myfile.txt");
		if(file.exists()) {
			file.delete();
		}
		*/

		// 이건 저장된 모든 파일을 지운다는 코드입니다.(디렉터리는 없다는 가정이요.)
		File[] files = dir.listFiles();
		if(files != null) {			
			for(File file : files) {
				if(file.isFile()) {
					file.delete();
				}
			}
		}
		
		if(dir.exists()) {
			dir.delete();
		}
		
	}
	
	// 문제4. 사용자로부터 입력받은 문자열을 C:\storage\diary.txt 파일로 보내시오.
	// 총 5개 문장을 입력받아서 보내시오.
	public static void ex04() {
		
		
		Scanner sc = new Scanner(System.in);
		String[] sentences = new String[5];
		System.out.println("5문장을 입력하세요.");
		
		sentences[0] += sc.nextLine();
		
		for(int i = 0; i < sentences.length; i++) {
			sentences[i] = sc.nextLine();
		}
		
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "diary.txt");
		
		try (PrintWriter out = new PrintWriter(file)){
		
			for(int i = 0; i < sentences.length; i++) {
			out.println(sentences[i]);
			
			}
			
			System.out.println("diary.txt 파일이 생성되었다.");
			} catch(IOException e) {
				e.printStackTrace();
			} 
			sc.close();			
	
	}
	
	// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생시간을 저장한 C:\storage\log.txt 파일을 생성하시오.
	// 예시)
	// 2023-01-26 12:08:30 / by zero
	public static void ex05() {
		
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("천 번째 정수를 입력하세요 >>> ");
			int number1 = sc.nextInt(); // 예외처리 발생구간 : 정수를 입력 안했을 때.
			
			System.out.println("두 번째 정수를 입력하세요 >>> ");
			int number2 = sc.nextInt();
			
			int add = number1 + number2;
			int sub = number1 - number2;
			int mul = number1 * number2;
			int div = (int)number1 / number2; // 예외처리 발생구간 : 정수를 0으로 나누면 무한대값이 뜸.
			
			System.out.println(number1 + "+" + number2 + "=" + add);
			System.out.println(number1 + "-" + number2 + "=" + sub);
			System.out.println(number1 + "*" + number2 + "=" + mul);
			System.out.println(number1 + "/" + number2 + "=" + div);
			
			sc.close();
			
			} catch(Exception e) {
				
				// 예외발생한 날짜 표기해주는 작업.
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String dateTime = dtf.format(now); 
				
				// 예외 발생한 클래스 이름
				String className = e.getClass().getName();
				
				// 예외 메세지
				String message = e.getMessage();
				
				// 로그 파일 만들기
				File dir = new File("C:" + File.separator + "storage");
				if(dir.exists() == false) {
					dir.mkdir();
				}
				
				File file = new File(dir, "log.txt"); 
				
				// 생성 모드(언제나 새로 만든다.) new FileWriter(file);
				// 추가 모드(기존 내용에 추가한다.) new FileWriter(file, true);
				
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
					
					bw.write(dateTime + " " +className + " " + message + '\n');
					// bw.nextLine(); \n을 대신할 수 있는 코드(BufferedWriter만 지원한다.)
					
					System.out.println("예외 메시지가 log.txt 파일에 기록되었습니다.");
					
				} catch(IOException e2) {
					e2.printStackTrace();
				}
		} 
		
	}
	
	// 문제6. C:\storage\diary.txt 파일을 C:\storage2\diary.txt 파일로 이동하시오.
	// 이동에 소요된 시간을 출력하시오.
	
			
//		public static void ex06() {
//		
//			File from = new File("C:" + File.separator + "storage", "diary.txt");		
//			
//			File toDir = new File("C:" + File.separator + "storage2");
//			if(toDir.exists() == false) {
//				toDir.mkdirs();
//			}
//			File to = new File(toDir, from.getName());
//			
//			BufferedReader br = null;
//			BufferedWriter bw = null;
//			
//			try {
//				
//				long startTime = System.currentTimeMillis();
//		
//				br = new BufferedReader(new FileReader(from));
//				bw = new BufferedWriter(new FileWriter(to));
//				
//				String line = null;
//				while((line = br.readLine()) != null) {
//					bw.write(line);
//					bw.newLine();
//				}
//				
//				bw.close();
//				br.close();
//				
//				if(from.length() == to.length()) {  // 복사 성공했다면 삭제
//					from.deleteOnExit();
//				}
//		
//				long stopTime = System.currentTimeMillis();
//		
//				System.out.println("이동에 걸린 시간 : " + (stopTime - startTime) + "밀리초");
//				
//			} catch(IOException e) {
//				e.printStackTrace();
//			} 
//		}

	// 문제7. System.in은 키보드로부터 바이트 데이터를 입력 받는 InPutStream이다.
	// System.in으로부터 문장 1개를 입력 받아서 출력하시오.
	// Scanner 대신 BufferedReader를 사용하시오.
	
	public static void ex07() {
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in)); // System.in은 InPut으로 받아줘야하는데 BufferedReader로 받을거니까
																	   // InputStreamReader가 필요하다.
			System.out.println("문장 입력 >>> ");
			String sentence = br.readLine();
			
			System.out.println("입력된 문장 : " + sentence);
			
		} catch(Exception e) {
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
	
	// 문제8. 키보드로부터 하나의 문장을 입력 받은 뒤 C:\storage\ex08.txt 파일에 출력하시오.
	// Scanner와 DataOutPutStream을 사용하시오
	
	public static void ex08() {

		Scanner sc = new Scanner(System.in);
		DataOutputStream dos = null;
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(new File("C:" + File.separator + "storage", "ex08.txt")));
			
			System.out.print("문장 입력 >>> ");
			String sentence = sc.nextLine();
			
			dos.writeUTF(sentence);
			
			sc.close();
			
		} catch(IOException e) {
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
		
	}
	
	
	// 문제9. C:\GDJ61\installer\eclipse-jee-2013-03-R-win32-x86_64.zip 파일을
	// C:\storage\eclipse.zip 으로 복사하시오
	
	public static void ex09() {
	
		//String spt = "File.separator";
		File from = new File("C:" + File.separator + "GDJ61" + File.separator + "installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File to = new File("C:" + File.separator + "storage", "eclipse.zip");
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			
			bin = new BufferedInputStream(new FileInputStream(from)); // 읽어오는거
			bout = new BufferedOutputStream(new FileOutputStream(to)); // 읽어온걸 쓰는거
			
			byte [] b = new byte[1024]; // 1킬로바이트
			int readByte = 0;
			
			while((readByte = bin.read(b)) != -1) {
				bout.write(b, 0, readByte); // 배열 b의 인덱스 0부터 readByte개 데이터를 사용한다.
			}

			System.out.println("복사 완료되었습니다.");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bin != null) {
					bin.close();
				}
				if(bout != null) {
					bout.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		ex09();
	}

}

		
	
			

