package com.news;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class NewsMain {
	JFrame f;
	JButton b;
	JList li;
	
	NewsDAOImpl dao;
	String url = "http://api.newswire.co.kr/rss/industry/600";
	String url2 = "http://www.hani.co.kr/rss/";

	public NewsMain() {
		createGUI();// 화면 만드는 메소드
		addEvent();// 이벤트 처리를 위한 메소드
		// dao 생성
		dao = new NewsDAOImpl();
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
		List<News> list = dao.getNewsData(url);
		li.removeAll();// 화면 한번 지워주기
		li.setListData(list.toArray());
	}

	private void createGUI() {
		f = new JFrame("News Info");
		b = new JButton("call News");

		li = new JList();
		JScrollPane pane = new JScrollPane(li);
		Container c = f.getContentPane();

		c.add(b, "North");
		c.add(pane, "Center");

		f.setSize(1200, 1200);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new NewsMain();
	}

}
