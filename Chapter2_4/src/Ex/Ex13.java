package Ex;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y, m, d;
		while (sc.hasNextInt()) {
			y = sc.nextInt();
			m = sc.nextInt();
			d = sc.nextInt();
			if (m == 1 || m == 2) {
				m += 12;
				y--;
			}
			int iWeek = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
			System.out.print(y + "��" + m + "��" + d + "����");
			switch (iWeek) {
			case 0:
				System.out.print("����һ");
				break;
			case 1:
				System.out.print("���ڶ�");
				break;
			case 2:
				System.out.print("������");
				break;
			case 3:
				System.out.print("������");
				break;
			case 4:
				System.out.print("������");
				break;
			case 5:
				System.out.print("������");
				break;
			case 6:
				System.out.print("������");
				break;

			}
		}
		sc.close();

	}

}
