package Example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CharacterStream {
	private String filename;

	public CharacterStream(String filename) {
		// TODO Auto-generated constructor stub
		this.filename = filename;
	}

	void write2File(int[] buffer) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fout = new FileWriter(filename);
		BufferedWriter dout = new BufferedWriter(fout);
		for (int i = 0; i < buffer.length; i++) {
			dout.write(buffer[i] + " ");
			if ((i + 1) % 10 == 0) {
				dout.newLine();
			}
		}
		dout.close();
		fout.close();
		System.out.println("�ɹ�д���ļ�" + filename);
	}

	void readFileContent() throws IOException {
		// TODO Auto-generated method stub
		FileReader fin = new FileReader(filename);
		BufferedReader din = new BufferedReader(fin);
		System.out.println("���ļ���ȡ" + filename);
		int count = 0;
		String aline = null;
		do {
			aline = din.readLine();
			if (aline != null) {
				System.out.println(aline);
				count++;
			}
		} while (aline != null);
		System.out.println("���ζ���" + count + "����");
		fin.close();
		din.close();
	}
}

public class Exa5 {
	public static void main(String[] args) throws IOException {
		int[] buffer = new int[100];
		for (int i = 0; i < 100; i++) {
			buffer[i] = (int) (Math.random() * 100);
		}
		CharacterStream fileStream = new CharacterStream("CharFile.dat");
		fileStream.write2File(buffer);
		fileStream.readFileContent();
	}
}
