package Excercise;

import java.awt.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JRadioButtonMenuItem;

class Menu1 extends JFrame{
	public Menu1() {
		// TODO Auto-generated constructor stub
		super("Demo");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(100, 100, 200, 200);
		JMenuBar menubar=new JMenuBar();
		this.setJMenuBar(menubar);
		JMenu j1=new JMenu("�ļ�");
		JMenu j2=new JMenu("����");
		menubar.add(j1);
		menubar.add(j2);
		JMenuItem m1=new JMenuItem("��");
		JMenuItem m2=new JMenuItem("�ر�");
		JMenuItem m3=new JMenuItem("����");
		j1.add(m1);
		j1.add(m2);
		j1.add(m3);
		JCheckBoxMenuItem c1=new JCheckBoxMenuItem("����1");
		JCheckBoxMenuItem c2=new JCheckBoxMenuItem("����2");
		JRadioButtonMenuItem r1=new JRadioButtonMenuItem("��ʽ1");
		JRadioButtonMenuItem r2=new JRadioButtonMenuItem("��ʽ2");
		j1.addSeparator();
		j1.add(c1);
		j1.add(c2);
		j1.addSeparator();
		j1.add(r1);
		j1.add(r2);
		
	}
}
public class Menu {
public static void main(String[] args) {
	new Menu1();
}
}
