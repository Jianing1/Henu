package File;

import java.io.File;

public class FileTest3 {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Jianing\\Desktop\\aa");
		boolean rst = file.mkdir();
		System.out.println(rst);
		// �÷������ܴ�������ļ���
		File file1 = new File("C:\\Users\\Jianing\\Desktop\\aa\\bb");
		boolean rst1 = file1.mkdir();
		System.out.println(rst1);
		// ���Դ�������ļ���
		boolean rst2 = file1.mkdirs();
		System.out.println(rst2);

		File file2 = new File("dd.txt");
		file2.delete();
		// deleteɾ�����ļ����²��������ļ���
		File file3 = new File("C:\\Users\\Jianing\\Desktop\\aa");
		boolean rst3 = file3.delete();
		System.out.println(rst3);

	}
}
