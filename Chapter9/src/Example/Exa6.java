package Example;

import java.io.File;
import java.util.Date;

class DirList {
	public DirList() {
		// TODO Auto-generated constructor stub
		File dir = new File(".");
		int count_dirs = 0;
		int count_files = 0;
		long byte_files = 0;
		System.out.println(dir.getAbsolutePath() + "Ŀ¼\r\n");
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.print(files[i].getName() + "\t");
			if (files[i].isFile()) {
				System.out.print(files[i].length() + "B\t");
				count_files++;
				byte_files += files[i].length();
			} else {
				System.out.print("<DIR>\t");
				count_dirs++;
			}
			System.out.println(new Date(files[i].lastModified()));
		}
		System.out.println("\r\n���� " + count_files + " ���ļ������ֽ�Ϊ:" + byte_files);
		System.out.println("���� " + count_dirs + " ��Ŀ¼");
	}
}

public class Exa6 {
	public static void main(String[] args) {
		new DirList();
	}
}
