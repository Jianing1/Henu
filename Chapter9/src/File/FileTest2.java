package File;

import java.io.File;
import java.io.IOException;

public class FileTest2 {
	public static void main(String[] args) throws IOException {
		File file1 = new File("C:\\Users\\Jianing\\Desktop\\a\\cc.txt");
		boolean rst = file1.createNewFile();
		// �ļ��Ѵ����򴴽�ʧ�ܣ�����false
		System.out.println(rst);// true

		File file2 = new File("dd.txt");
		// ���û��ָ���ļ�·������Ĭ������Ŀ·����
		boolean rst2 = file2.createNewFile();
		System.out.println(rst2);
		// creatNewFileʱ��·�����������׳�io�쳣
		File file3 = new File("C:\\Users\\Jianing\\Desktop\\aaaa\\cc.txt");
		boolean rst3 = file3.createNewFile();
		System.out.println(rst3);
	}
}
