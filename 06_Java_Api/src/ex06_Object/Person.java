package ex06_Object;

public class Person {
	
	private String name;
	
	public Person() {
		
	}
	
	public Person(String name) {
		
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("먹는다");
	}	
	
	public void sleep() {
		System.out.println("잔다");
	}

	// equals 오버라이드 고를 때 name을 선택함(name이 같으면 같은걸로 해라~)
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
	
	
	
	
	
}
