package Exa;

public class ��4_2 {
	private int grade;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void grade() {
		switch (grade / 10) {
		case 6:
			System.out.println(this.getGrade() + "�������ڼ���");
			break;
		case 7:
		case 8:
			System.out.println(this.getGrade() + "������������");
			break;
		case 9:
			System.out.println(this.getGrade() + "������������");
			break;
		case 10:
			System.out.println(this.getGrade() + "������������");
			break;
		default:
			System.out.println(this.getGrade() + "�������ڲ�����");
			break;
		}
	}

	public static class test {
		public static void main(String[] args) {
			��4_2 e1 = new ��4_2();
			e1.setGrade(76);
			e1.grade();
		}

	}

}
