package Example;

import java.io.IOException;

public class Exa1 {
	int count = 0;
	byte buffer[];

	private void stdIo() throws IOException {
		// TODO Auto-generated method stub
		do {
			System.out.println("�����룺");
			buffer = new byte[512];
			count = System.in.read(buffer);
			System.out.println("������ֽ�Ϊ��");
			for (int i = 0; i < count; i++) {
				System.out.print(buffer[i]);
				System.out.print(" ");
			}
			System.out.println();
			System.out.println("������" + count + "���ֽ�");
		} while (count != 2);
	}

	public static void main(String[] args) throws IOException {
		new Exa1().stdIo();
	}
}
