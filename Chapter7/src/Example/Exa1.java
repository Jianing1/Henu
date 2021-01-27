package Example;

public class Exa1 {
	public static void error() {
		int[] a = new int[5];
		for (int i = 0; i < a.length; i++) {
			try {
				a[i] = 10 / i;
			} catch (ArithmeticException e) {
				e.printStackTrace();
				// TODO: handle exception
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�±�Խ�紦Ϊ" + e.getMessage());
			} finally {
				System.out.println("ѭ������Ϊi=" + i);
			}
		}
	}

	public static void main(String[] args) {
		Exa1.error();
	}
}
