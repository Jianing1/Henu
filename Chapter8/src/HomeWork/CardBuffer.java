package HomeWork;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//���Ƴ���
public class CardBuffer {

	private int value;
	private int order = 0;
	private boolean isEmpty;

	public synchronized void put(int i) {
		while (!isEmpty)// û�з��ƣ�valueֵΪ�գ��ȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {

			}
		isEmpty = false;// ���valueֵ��Ϊ��
		value = i;// value���һ����
		notifyAll();// �������еȴ����������߳�
	}

	public synchronized int get(int order) {
		while (isEmpty || (this.order != order))// ��ҵ���value�ǿջ���û���ֵ��Լ���ʱ��ȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {

			}
		isEmpty = true;// ���valueֵΪ��
		notifyAll();// �������������ȴ����߳�
		this.order = (this.order + 1) % 4;// ��1ʹ�ƵĴ�����ת
		return value;
	}

	public static void main(String arg[]) {
		new cardJFrame();
	}
}

//�ѵ��߳�ֻ���ѣ������߳�ֻ�ܷ���
class player extends Thread {

	private CardBuffer cB;
	private JTextArea text;
	private int order;// �ź�����Լ��ȡ���߳�

	public player(CardBuffer cB, JTextArea text, int order) {
		this.cB = cB;
		this.text = text;
		this.order = order;
	}

	public void run() {
		while (true) {
			text.append(" " + cB.get(this.order));// ��˳���ÿһ����Ҽ��Ϸ��˵���
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}
	}
}

class sender extends Thread {

	private CardBuffer cB;
	private int count;
	private java.util.ArrayList<Integer> list;// ���鼯��

	@SuppressWarnings("deprecation")
	public sender(CardBuffer cB, int count) {
		this.cB = cB;
		this.count = count;
		list = new ArrayList<Integer>();
		for (int i = 1; i <= this.count; i++) {
			list.add(new Integer(i));// ��1~52����������
			java.util.Random rand = new Random();
			java.util.Collections.shuffle(list, rand);// shuffleϴ���㷨
		}
	}

	public void run() {
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			cB.put((Integer) it.next());// ��52���Ʒ���ȥ
		}
	}
}

class cardJFrame extends JFrame {
	public cardJFrame() {
		super("����");
		this.setBounds(300, 240, 460, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3, 3));
		c.add(new JPanel());

		JTextArea text[] = new JTextArea[4];// 4�����
		Font f = new Font("Helvetia", Font.PLAIN, 16);// ����
		for (int i = 0; i < text.length; i++) {
			text[i] = new JTextArea();
			text[i].setLineWrap(true);// �����ı��Զ�����
			text[i].setEditable(false);// ���ɱ༭
			text[i].setFont(f);
			c.add(text[i]);
			c.add(new JPanel());
		}
		this.setVisible(true);
		CardBuffer cB = new CardBuffer();// ����
		sender s = new sender(cB, 52);// newһ�������߳�
		s.setPriority(10);// ����������ȼ�
		s.start();
		for (int i = 0; i < text.length; i++) {// ������η���
			(new player(cB, text[i], i)).start();
		}

	}

}
