package ex01_File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainClass {

	/*
		File 클래스
		1. java.io 패키지
		2. 파일, 디렉터리(폴더)를 관리하는 클래스이다.
		3.  객체 생성 방법
			1) new File(경로, 파일)
			2) new File(파일)
		4. 경로 구분 방법	
			1) 윈도우 : 백슬래시(\)
			2) 리눅스 : 슬래쉬(/)
	*/
	
	public static void ex01() {
			
		// File.separator : 플랫폼에 따라 자동으로 경로 구분자를 사용한다.
		
		// 디렉터리 관련 필수 작업
		 
		/* File(String fileName) : 주어진 문자열을 이름으로 갖는 파일을 위한 File 인스턴스를 생성한다.
		  
		   파일뿐만 아니라 디렉토리도 같은 방법으로 다룬다.
			
	       여기서 fileName은 주로 경로를 포함해서 지정해주지만, 파일 이름만 사용해도 프로그램이 실행되는 위치를 경로로 간주한다.
		*/

		File dir = new File("C:" + File.separator + "storage");  // C드라이브 아래 storage 폴더를 의미한다.
		// *주의* File 인스턴스를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다.			
		// 파일명이나 디렉토리명으로 지정된 문자열이 유효하지 않더라도 컴파일 에러나 예외를 발생시키지 않는다.
		
		if(dir.exists() == false) { // 없으면 만들고, 있으면 지운다.
			
			dir.mkdirs();
			System.out.println("C:" + File.separator + "storage 생성 완료");
		} else {
			// dir.deleteOnExit(); // JVM 실행이 끝나면 지운다
			dir.delete(); // 지금 바로 지운다.
			System.out.println("C:" + File.separator + "storage 삭제 완료");
		}
		
	}
	
	public static void ex02() throws IOException { // 예외 처리를 ex02 메소드를 호출한 곳으로 넘긴다.
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "myfile.txt");
		if(file.exists() == false) {
			file.createNewFile(); // 반드시 예외 처리가 필요한 코드
		} else {
			file.delete();
		}
	}

	
	public static void ex03() throws IOException {
		
		File dir = new File("C:" + File.separator + "storage");
		
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "myfile.txt");
		
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		// 파일의 정보 확인
		System.out.println("파일명 : " + file.getName());
		System.out.println("디렉터리명 :" + file.getParent()); // 파일은 자기가 속한 디렉토리(폴더)를 부모라 부른다.
		System.out.println("경로명" + file.getPath()); // 파일명 + 디렉터리명
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModified = file.lastModified(); // 최종 수정일의 타임 스탬프
		System.out.println("최종 수정일 :" + lastModified);
		
		String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(lastModified);
		System.out.println("최종 수정일 :" + lastModifiedDate);
		
		long size = file.length(); // 파일의 크기가 바이트 단위로 저장
		long kb = (size / 1024) + (size % 1024 != 0 ? 1 : 0);
		
		System.out.println("파일 크기 : " + kb + "KB"); // 킬로 바이트 출력(1024바이트 = 1킬로바이트)
	
		
	}
	
	public static void ex04()  {
		
		File dir = new File("C:" + File.separator + "Program Files");
		
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isHidden() == false) { // isHidden 메소드 : 숨긴 파일인지 확인
			System.out.println(files[i].getName()); // 즉 숨긴 파일 빼고 모두 이름을 가져와서 출력하다.
			}
		}
	}
	
	public static void main(String[] args) throws IOException { // main 메소드를 호출하는 곳으로 예외 처리를 넘긴다. (개발자가 try-catch 하지 않겠다.)
		
		ex04();
	}

}
