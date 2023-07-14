package org.sp.app0714.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberMain extends JFrame{
	
	//서쪽 영역 구성 컴포넌트들
	JPanel p_west;
	JTextField t_id;
	JTextField t_name;
	JTextField t_phone;
	JButton bt_regist;
	
	//센터영역 구성 컴포넌트들
	JPanel p_center;
	JButton bt_select;
	JTextArea area;
	JScrollPane scroll;
	
	public MemberMain() {
		p_west = new JPanel();
		t_id = new JTextField();
		t_name = new JTextField();
		t_phone = new JTextField();
		bt_regist = new JButton("등록");
		
		p_center = new JPanel();
		bt_select = new JButton("조회");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		//스타일 지정 
		//p_west.setBackground(Color.YELLOW);
		p_west.setPreferredSize(new Dimension(120, 500));
		//p_center.setBackground(Color.CYAN);
		p_center.setPreferredSize(new Dimension(480, 500));
		
		Dimension d = new Dimension(110,40);
		t_id.setPreferredSize(d);
		t_name.setPreferredSize(d);
		t_phone.setPreferredSize(d);
		
		area.setPreferredSize(new Dimension(450, 420));
		
		//서쪽 영역 조립 
		p_west.add(t_id);
		p_west.add(t_name);
		p_west.add(t_phone);
		p_west.add(bt_regist);
		
		//센터영역 조립 
		p_center.add(bt_select);
		p_center.add(scroll);
		
		//패널을 윈도우에 부착 
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		setSize(600,500);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// db닫기, 각종 자원 닫기!
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new MemberMain();
	}
}















