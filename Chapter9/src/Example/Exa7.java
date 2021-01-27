package Example;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;

class DirFilterList {
	public DirFilterList(InnerFilter filter) {
		File dir = new File(".");
		// ��ǰĿ¼
		int count_dirs = 0, count_files = 0;
		// Ŀ¼�����ļ���
		long byte_files = 0;
		// �����ļ����ֽ���
		System.out.println(dir.getAbsolutePath() + " Ŀ¼\r\n");
		File[] files = dir.listFiles(filter);
		// ִ���Ͼ䣬��ȥ��accept()
		for (int i = 0; i < files.length; i++) {
			System.out.print(files[i].getName() + "\t"); // ��ʾ�ļ���
			if (files[i].isFile()) { // �ж�ָ��File�����Ƿ����ļ�
				System.out.print(files[i].length() + "B\t");
				// ��ʾ�ļ�����
				count_files++;
				byte_files += files[i].length();
			} else {
				System.out.print("<DIR>\t");
				count_dirs++;
			}
			System.out.println(new Date(files[i].lastModified()));
		}
		System.out.println("\r\n���� " + count_files + " ���ļ������ֽ���Ϊ " + byte_files);
		System.out.println("���� " + count_dirs + " ��Ŀ¼");
	}
}

class InnerFilter implements FilenameFilter {
	private String prefix; // �ļ���ǰ׺
	private String extend; // �ļ���չ��

	public InnerFilter(String filterStr) {
		this.prefix = "";
		this.extend = "";
		filterStr = filterStr.toLowerCase();
		int i = filterStr.indexOf('*');
		if (i > 0)
			this.prefix = filterStr.substring(0, i); // ���*֮ǰ���ַ���
		int j = filterStr.indexOf('.');
		if (j > 0) {
			this.extend = filterStr.substring(j + 1); // ���.֮����ļ���չ���ַ���
			if (this.extend.equals("*")) // ʶ��"*.*"
				this.extend = "";
		}
	}

	public InnerFilter() {
		this("*.*");
	}

	public boolean accept(File dir, String filename) {
		filename = filename.toLowerCase();
		return (filename.startsWith(this.prefix)) & (filename.endsWith(this.extend));
	}

}

public class Exa7 {
	public static void main(String[] args) {
		InnerFilter filter = new InnerFilter("*.java");
		new DirFilterList(filter);
	}

}