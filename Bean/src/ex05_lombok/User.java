package ex05_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor 
@NoArgsConstructor // 디폴트 생성자
@ToString
@Builder

public class User {
	
	private String id;
	private String pw;

}
