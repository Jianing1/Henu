package Exa;

public class ��4_3 {
	private int startNum, sum, endNum;

	public void set(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}

	public void print() {
		System.out.println(this.startNum + "��" + this.endNum + "֮�����Ӻ�:");
	}

	public void whileEx() {
		while (startNum <= endNum) {
			sum += startNum;
			startNum++;
		}
		System.out.println("sum=" + sum + ",��������������һ��,ֵΪ" + startNum);
	}

	public static class TestWhile {
		public static void main(String[] args) {
			��4_3 e1 = new ��4_3();
			e1.set(1, 100);
			e1.print();
			e1.whileEx();

		}
	}

}
