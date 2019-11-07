package com.weather;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class WeatherMain {

	JFrame f;
	JButton b;
	JList li;
	WeatherDAO dao;
	String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000";
	
	public WeatherMain() {
		dao = WeatherDAO.getInstance();
		createGUI();
		addEvent();
	}
	
	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		b.addActionListener(new ActionListener() {// 버튼을 클릭하면
			@Override
			public void actionPerformed(ActionEvent e) {
				showList(url);
			}
		});
	}

	// dao의 메소드 호출해서 데이터 받아온 후에 그 결과를 화면 (JList)에 뿌려주기
	protected void showList(String url) {
		List<Weather> list = dao.getWeatherList(url);
		li.removeAll();// 화면 한번 지워주기
		li.setListData(list.toArray());
	}

	private void createGUI() {
		f = new JFrame("Weather Info");
		b = new JButton("call Weather");

		li = new JList();
		JScrollPane pane = new JScrollPane(li);
		Container c = f.getContentPane();

		c.add(b, "North");
		c.add(pane, "Center");

		f.setSize(1200, 1200);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new WeatherMain();
	}

}
