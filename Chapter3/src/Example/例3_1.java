package Example;

public class 例3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setName("zhangsan");
		person.print();
	}

}

class Person {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void print() {
		System.out.println("Person`s name is " + this.getName());
	}
}