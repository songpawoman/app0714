package org.sp.app0714.table2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MySQLMain extends JFrame{
	JTable table;
	JScrollPane scroll;
	String[][] data= {};
	String[] column= {"member_idx","id","name","phone"};
	String url="jdbc:mysql://localhost:3306/javase";
	String user="root";
	String pass="1234";
	Connection con;
	
	public MySQLMain() {
		table = new JTable(data,  column);
		scroll  = new JScrollPane(table);
		
		add(scroll);
		
		setSize(600,400);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(0);
			}
		});
		
		connect();
	}
	
	public void connect() {
		//드라이버 로드 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//접속
			con=DriverManager.getConnection(url, user, pass);
			if(con==null) {
				System.out.println("접속실패");
			}else {
				System.out.println("접속성공");
			}			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new MySQLMain();
	}
}









