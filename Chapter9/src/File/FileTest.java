package File;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		// ����·���õ�һ��File����
		// Java��һ��\������ת���ַ���ʼ��־����ʾ·��Ҫ������\\��ʾ
		File file1 = new File("C:\\Users\\Jianing\\Desktop\\a\\b.txt");
		// �ļ�����һ��������ļ�,ֻ�����ļ����е��������������ļ��л��ļ�
		File file2 = new File("C:\\Users\\Jianing\\Desktop\\a", "b.txt");
		File file = new File("C:\\Users\\Jianing\\Desktop\\a");
		File file3 = new File(file, "b.txt");
	}
}
