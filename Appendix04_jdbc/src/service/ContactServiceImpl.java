package service;

import java.util.List;
import java.util.Scanner;

import dao.ContactDAO;
import dto.ContactDTO;

// ContactService 인터페이스를 구현한 ContactServiceImpl 클래스
public class ContactServiceImpl implements ContactService {

	/************ 1. field **************/
	private Scanner sc;
	private ContactDAO dao; 
	
	
	/************ 2. constructor  **************/
	public ContactServiceImpl() {
		sc = new Scanner(System.in);
		dao = ContactDAO.getInstance();
	}
	
	/************ 3. method  **************/

	@Override
	public void addContact() {
		
		System.out.println("===== 연락처 추가하기 =====");
		
		System.out.print("신규 연락처 이름 >>>");
		String name = sc.next();
		System.out.print("신규 연락처 번호 >>>");
		String tel = sc.next();
		System.out.print("신규 연락처 이메일 >>>");
		String email = sc.next();
		System.out.print("신규 연락처 주소 >>>");
		String address = sc.next();
		
		ContactDTO contact = new ContactDTO(); // 디폴트로 객체 생성 => 세터게터로 초기화 하겠다.
		
		// 스캐너로 입력받은걸 contact에 넣어준다.
		contact.setName(name);
		contact.setTel(tel);
		contact.setEmail(email);
		contact.setAddress(address);

		// 필드에 ContactDAO클래의 dao를 선언해줬으니 insertContact메소드를 가져다 쓸 수 있다.
		int addResult = dao.insertContact(contact); 
		
		// 필드에 dao를 선언해서 dao 메소드 갖다 쓴건 알겠는데 애초에 dao는 프라이빗인데 어케 갖다쓰지..?
		// 자 이건.... ContactServiceImpl 클래스가 ContactService를 인터페이스 함.
		// ContactService 인터페이스엔 public void addContact(); 추상메소드가 있음..
		// 그러니까 ContactServiceImpl 클래스에서 저 추상메소드를 재정의 해주는거임..
		// 거기서 ContactDTO contact = new ContactDTO(); 이렇게 ContactDTO객체를 생성함.
		// ContactDTO 클래스의 필드를 스캐너 객체로 입력받은 내용을 통해 set 메소드로 초기화시켜준다.
				
		System.out.println(addResult + "개의 연락처가 등록되었습니다.");		
		
	}
	
	@Override
	public void removeContact() {
		
		System.out.println("==== 연락처 삭제하기====");
		
		System.out.println("삭제할 연락처 이름 >>> ");
		String name = sc.next();
		
		List<ContactDTO> contactList = dao.selectContactsByName(name);
		
		System.out.println("<<< 조회된 연락처 목록 >>>");
		for(ContactDTO contact : contactList) {
			System.out.println(contact);
		}
		
		System.out.println("삭제할 연락처 No >>> ");
		int contact_no = sc.nextInt();
		
		int removeResult = dao.deleteContact(contact_no);
		
		System.out.println(removeResult + "개의 연락처가 삭제되었습니다.");
		
		// 위 코드는 트랜잭션 대상이 아니다
		// SELECT는 트랜잭션 대상이 아니고 DELETE도 하나만 있기 때문에!
		
		
	
		
	}
	
	@Override
	public void modifyContact() {

		System.out.println("==== 연락처 수정하기 ====");
		
		System.out.println("수정할 연락처 이름 >>> ");
		String name = sc.next();
		
		List<ContactDTO> contactList = dao.selectContactsByName(name);
		System.out.println("<<< 조회된 연락처 목록>>>");
		for(ContactDTO contact : contactList) {
			System.out.println(contact);
		}
		
		System.out.println("수정할 연락처 No >>>");
		int contact_no = sc.nextInt();
		ContactDTO contact = dao.selectContactByNo(contact_no); 
		// 수정하기 전의 내용을 가지고 있는 contact이다.
		// 5개의 값이 전부 차 있다.
		
		System.out.println("수정할 항목 선택(1.이름 2.전화 3.이메일 4.주소)  >>>");
		// 연락처 번호는 고유 번호라 수정불가
		
		String choice = sc.next();
		switch(choice){
		case "1":
			System.out.println("수정할 이름 입력 >>> ");
			contact.setName( sc.next() );
			// 원래 값을 다 가지고 있는 contact의 값들 중 입력 받은 값만 set메소드를 통해서 바꿔주는것.
			break;
		case "2":
			System.out.println("수정할 전화 입력 >>> ");
			contact.setTel( sc.next() );
			break;
		case "3":
			System.out.println("수정할 이메일 입력 >>> ");
			contact.setEmail( sc.next());
			break;
		case "4":
			System.out.println("수정할 주소 입력 >>> ");
			contact.setAddress( sc.next());
			break;
		default:
			System.out.println("잘못된 입력입니다. 수정을 취소합니다.");
			return; // 메소드를 종료한다.
		
		}
		
		int modifyResult = dao.updateContact(contact);
		
		System.out.println(modifyResult + "개의 연락처가 수정되었습니다.");
		
	}

	@Override
	public void findContactsByName() {

		System.out.println("==== 연락처 조회하기 ====");
		
		System.out.println("조회할 연락처 이름 >>>");
		String name = sc.next();
		
		List<ContactDTO> contactList = dao.selectContactsByName(name);
		for(ContactDTO contact : contactList) {
			System.out.println(contact);
		}
	}

	@Override
	public void findAllContacts() {
		System.out.println("==== 전체 연락처 목록 ====");
		for(ContactDTO contact : dao.selectAllContacts()) { 
										// ArrayList라고 생각하면 된다.
			System.out.println(contact);
		}
	}
}
