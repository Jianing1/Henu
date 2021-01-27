package Example;

import java.io.*;

class FileSort {
	private RandomAccessFile rafile;

	public FileSort(String filename) throws IOException {
		File file = new File(filename);
		if (file.exists())
			// ���ָ���ļ��Ѵ��ڣ���ɾ��
			file.delete();
		this.rafile = new RandomAccessFile(filename, "rw");
		// �����ļ����󣬿ɶ�д
	}

	public void sort(int k, long pos) throws IOException { // ��posλ�ÿ�ʼ��������k
		this.rafile.seek(pos); // �����ļ���ָ��
		boolean insert = false;
		while (true) // �ļ�δ����ʱ
			try {
				int temp = this.rafile.readInt(); // ��ȡһ������
				if (temp > k) {
					long currPos = this.rafile.getFilePointer();
					// ��õ�ǰλ��
					this.rafile.seek(currPos - 4);// ����4���ֽڣ���int����
					this.rafile.writeInt(k); // k���뵱ǰλ��
					this.sort(temp, currPos); // �ӵ�ǰλ�ÿ�ʼ����temp����
					insert = true;
				}
			} catch (EOFException ioe) { // ���񵽴��ļ�β�쳣
				if (insert == false) {
					this.rafile.writeInt(k);
					// д��k
				}
				break;
			}
	}

	public void append(int[] table) throws IOException { // ���ļ����������
		for (int i = 0; i < table.length; i++) {
			this.sort(table[i], 0);
		}
		System.out.println();
	}

	public void readFromFile() throws IOException { // ��ָ���ļ��ж�ȡ����
		this.rafile.seek(0);
		while (true) // �ļ�δ����ʱ
			try {
				System.out.print(this.rafile.readInt() + "  ");
			} catch (EOFException ioe) {
				System.out.println();
				this.rafile.close(); // �ر��ļ�
				break;
			}
	}
}

public class Exa8 {
	public static void main(String[] args) throws IOException {
		int[] table = { 5, 3, 1, 2, 5, 6, 10, 8 };
		FileSort fileSort = new FileSort("Random.dat");
		fileSort.append(table);
		fileSort.readFromFile();
	}
}
