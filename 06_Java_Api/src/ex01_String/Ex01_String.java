package ex01_String;

public class Ex01_String {

	public static void literal() {
		
		// 문자열 리터럴(Literal)
		String str1 = "hello";
		String str2 = "hello";
		
		// 문자열 리터럴은 Java에 의해서 최적화되기 때문에
		// 동일한 리터럴("hello")를 2번 이상 사용하면 
		// 기존에 사용한 리터럴을 재사용한다.("hello"라는 리터럴이 2개 이상 만들어지지 않는다.)
		
		/*
        |-------|
   str1 | 0x123 |
        |-------|
   str2 | 0x123 |
        |-------|
        |  ...  |
        |-------|
        |"hello"| 0x123
        |-------|
	*/
		
		// 참조값(0x123)이 같다는 의미이다. 저장된 문자열이 같다는 의미가 아니다.("hello"를 비교한게 아니다.)
		System.out.println(str1 == str2); // 둘의 번지수가 같기 때문에 true.
	}
	
	public static void stringObject() {
		
		// 문자열 객채(object)
		String str1 = new String("hello"); // "hello" 새로 만들어라
		String str2 = new String("hello"); // "hello" 또 새로 만들어라
		
		// 문자열 객체는 언제나 새로 생성된다.
		
	/*
		  
        |-------|
   str1 | 0x123 |
        |-------|
   str2 | 0x456 |
        |-------|
        |  ...  |
        |-------|
        |"hello"| 0x123
        |-------|
        | . . . |
        |-------|	 
	    |"hello"| 0x456
        |-------|
	*/	
		// 참조값(0x123)이 다르는 의미이다. 저장된 문자열이 다르다는 의미가 아니다.("hello"를 비교한게 아니다.)
		System.out.println(str1 == str2); // 둘의 번지수가 다르기 때문에 false
	}
	
	public static void equals() {
		
		// equals 메소드 (문자열 비교 메소드)
		// 비교하는 문자열이 동일하면 true, 아니면 false 반환
		
		String str1 = "hello";
		String str2 = new String("HELLO"); // 컨트롤 + 쉬프트 + s : 대문자 변환
		
		// 대소문자도 일치해야 함
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
		
		// 대소문자는 무시함.
		if(str1.equalsIgnoreCase(str2)) { // "hello"와 "HELLO"를 대소문자 구분없이 비교함. 둘다 헬로니까 true
				// 대소문자 case를 무시한다.
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
	}
	
	public static void length() {
		
		// length 메소드
		// 문자열의 길이(글자수)를 반환
		
		String str = "Hello\nWorld"; // \n 줄바꿈하는 이스케이프 문자도 한글자로 계산된다.
		int length = str.length(); // 메소드라 (); 괄호가 붙음. 배열의 길이는 arr.length 임.
		System.out.println("글자수 : " + length);
		
	}
	
	public static void charAt() {
		
		// charAt 메소드
		// 문자열의 특정 인덱스의 문자(Char)를 반환
		
		String name = "이미래";
		
		for(int i = 0; i < name.length(); i++) { 
							// 메소드를 여러번 호출해야 하기때문에 좋은 메서드는 아니다. 참조변수를 호출하는게 이득.
			System.out.println(name.charAt(i));
		}
	}
	
	public static void substring() {
		
		// substring 메소드
		// 문자열의 일부 문자열을 반환
		
		// substring 사용법
		// 1. substring(int begin) : 인덱스 begin부터 끝까지 반환
		// 2. substring(int begin, int end) : 인덱스 begin부터 end 이전까지 반환
		
		String name = "민경태";
		
		String familyName = name.substring(0,1);
		System.out.println(familyName); // 민
		String givenName = name.substring(1); // index 번호를 하나만 지정해주면 거기부터 끝까지라는 뜻.
		System.out.println(givenName); // 경태
	}
	
	public static void indexOf() {
	
		// indexOf
		// 특정 문자열의 인덱스 정보를 반환 (반환값은 int값)
		// 발견된 첫 번째 문자열의 인덱스 정보를 반환
		// 발견된 문자열이 없는 경우에는 -1을 반환
		
		// indexOf 사용법
		// 1. indexOf(String str) : 인덱스 0부터 str을 검색
		// 2. indexOf(String str, int index) : 인덱스 index부터 str을 검색
		
		String slogan = "걱정한다고 걱정이 없어지면 걱정이 없겠네";
		               // 0          6               15
		int idx1 = slogan.indexOf("걱정");
		int idx2 = slogan.indexOf("걱정", idx1 + 1); // 첫번째 걱정의 다음부터 찾아라
		int idx3 = slogan.indexOf("걱정", idx2 + 1); // 첫번째 걱정의 다음부터 찾아라
		
		int idx4 = slogan.indexOf("민경태"); // 민경태라는 글자는 없으므로 결과값 -1 출력.
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println(idx3);
		System.out.println(idx4);
		
	}
	
	public static void lastIndexOf() {
		
		// lastIndexOf
		// 발견된 마지막 문자열의 인덱스를 반환
		// 나머지 특성은 indexOf와 동일 
		
		String slogan = "걱정한다고 걱정이 없어지면 걱정이 없겠네";
		
		int idx1 = slogan.lastIndexOf("걱정");
		
		int idx2 = slogan.indexOf("민경태");
		
		System.out.println(idx1);
		System.out.println(idx2);
	}
	
	public static void starsWith() {
		
		// starsWith
		// 문자열이 지정된 정규식 패턴(Ragular Expression)으로 시작하면 true 반환
		
		String name = "민경태";
		
		if(name.startsWith("민")) { // "민" 으로 시작하냐
			System.out.println("민씨다");
		} else {
			System.out.println("민씨가 아니다");
		}
		
		// endsWith
		// 문자열이 지정된 정규식 패턴(Ragular Expression)으로 끝나면 true 반환 
		
		if(name.endsWith("태")) {
			System.out.println("태로 끝난다");
		} 
	
		// matches 
		// 문자열이 지정된 정규식 패턴(Ragular Expression)을 포함하면 true 반환
	
	}
	
	public static void contains() {
		
		// contains
		// 문자열이 지정된 CharSequence(문자열이라 생각하기. String, char[] 등)를 포함하면 true 반환
		
		// 참고
		// public interface CharSequence { }
		// public class String implements CharSequence { }
		
		String email = "mirae1213@daum.net";
		
		if(email.contains("@")) { // 문자열에 "@" 포함됐다면
			System.out.println("이메일이 맞다.");
		} else {
			System.out.println("이메일이 아니다");
		}
	}
	
	public static void toCase () {
		
		// toUpperCase
		// 대문자로 변환
		
		// toLowerCase
		// 소문자로 변환
		
		String str = "I am a boy";
		
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
	}
	
	public static void trim () {
		
		// trim
		// 문자열의 앞뒤에 포함된 공백 문자를 제거
		
		String str = "   hahaha   hohoho   ";
	
		System.out.println("(" + str + ")");
		System.out.println("(" + str.trim() + ")");
	}
	
	public static void replace () {
		
		// replace 
		// 기존 문자열을 새로운 문자열로 변환한 결과를 반환
		// 문자열 전부바꿔줌 . replaceAll만 다 바꿔주는거 아님.
		
		// replace 사용법
		// replace(String str1, String str2)
		// 모든 str1을 str2로 변환
		
		String str = "best of the best";
		String result = str.replace("best", "worst");
		
		System.out.println(result);
		
		// replaceAll
		// 정규식 패턴(Regular Expression)을 만족하는 부분을 변환한 결과를 반환
		
		String ip = "61.78.121.242";
		// String replacedIp = ip.replaceAll(".", "_"); // 61_78_121_242을 기대하지만 다른 정답이 나옴(정규식에서 마침표는 모든 문자를 의미함)
		String replacedIp = ip.replace(".", "_"); // 61_78_121_242
		System.out.println(replacedIp);
	}
	
	public static void isEmpty () {
		
		// isEmpty
		// 빈 문자열이면 true 반환, 아니면 false.
		// 빈 문자열("") : 문자열의 길이가 0이면 빈 문자열
		
		String str = " "; // 띄어쓰기 하나라도 들어가 있으면 빈 문자열이 아니다.
		
		if(str.trim().isEmpty()) { // 앞에 trim()을 실행해주면 띄어쓰기를 없애준다, 즉 빈 문자열이다.
			System.out.println("빈 문자열이다.");
		} else {
			System.out.println("빈 문자열이 아니다"); 
			
		}
		
		// isBlank
		// 빈 문자열이거나 공백 문자로만 구성되었다면 true 반환, 아니면 false.
		// JDK 11 이후에서만 사용 가능 
		
		if(str.isBlank()) {
			System.out.println("빈 문자열이다. ");
		} else {
			System.out.println("빈 문자열이 아니다.");
		}
	}
	
	public static void format () {
		
		// format
		// 문자열을 지정한 형식으로 반환
		
		//  숫자 형식 정하기
		int number = 1000;
		
		System.out.println(String.format("%o", number)); // %o : 8진수로 표시하시오.
		System.out.println(String.format("%d", number)); // %d : 10진수로 표시하시오.
		System.out.println(String.format("%x", number)); // %x : 16진수로 표시하시오. (0~9, a, b, c, d, e, f)
		System.out.println(String.format("%X", number)); // %X : 16진수로 표시하시오. (0~9, A, B, C, D, E, F)
		
		// 문자열 형식 지정하기
		String str = "hi";
		System.out.println(String.format("%s", str)); // %s : 문자열로 표시하시오.
		
		// 출력 폭 지정하기
		System.out.println(String.format("%10d", number)); // %10d : 10자리로 표시하시오. 숫자는 오른쪽에 표시하시오.
		System.out.println(String.format("%-10d", number)); // %-10d : 10자리로 표시하시오. 숫자는 왼쪽에 표시하시오.
		System.out.println(String.format("%5s", str)); // %5s : 5자리로 표시하시오. 숫자는 오른쪽에 표시하시오.
		System.out.println(String.format("%-5s", str)); // %-5s : 5자리로 표시하시오. 숫자는 왼쪽에 표시하시오.
	}
	
	public static void ex01() {
		
		String url = "https://comic.naver.com/webtoon/detail?titleId=758037&no=112&weekday=mon";
		
		// https://comic.naver.com/webtoon/detail 여기까지 출력하기 
		String requestURI = url.substring(0,url.indexOf("?")); // 인덱스 0번부터 "?" 문자열이 있는 인덱스 이전까지 출력.

		System.out.println(requestURI);
		
		String params = url.substring(url.indexOf("?") + 1); 
			
		System.out.println(params);
		}
	
	public static void ex02() {
		
		String fullName = "a.p.p.l.e.tar.gz";
		
		String fileName = "";
		String extName = "";

		if(fullName.endsWith("tar.gz")){
			fileName = fullName.substring(0, fullName.lastIndexOf(".tar.gz"));
			extName = ".tar.gz";
		} else {
			fileName = fullName.substring(0, fullName.lastIndexOf(".")); // apple
			extName = fullName.substring(fullName.lastIndexOf(".")); // .jpg
		}
		
		System.out.println(fileName);
		System.out.println(extName);
	}
	
	public static void main(String[] args) {
		format();
	}

}
