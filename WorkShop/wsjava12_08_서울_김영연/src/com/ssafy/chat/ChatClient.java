package com.ssafy.chat;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient {
	private JFrame f;
	private JTextArea ta;
	private JButton b1;
	private JButton b2;
	private JScrollPane sp;
	private JTextField tf;
	private JPanel p;
	private Socket s;
	private ObjectOutputStream oos;
	private ChatClientThread ct;
	BufferedReader br;
	
	public ChatClient() {
		f = new JFrame("ChatClient");
		ta = new JTextArea("서버 전송 성공!!\n");
		sp = new JScrollPane(ta);
		tf = new JTextField();
		p = new JPanel();
		b1 = new JButton("Send");
		b2 = new JButton("Exit");
	}

	private void addEvent() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				ta.append(tf.getText() + "\n");
//				ta.setCaretPosition(ta.getDocument().getLength());
				try {
					oos.writeObject(tf.getText());
					oos.flush();
					tf.setText("");
					tf.requestFocus();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
		tf.addActionListener(al); // 엔터
		b1.addActionListener(al);
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f.dispose();
				ct.stopRun();
//				System.exit(0);
			}
		});
	}
	public void createGUI() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = f.getContentPane();

		ta.setEditable(false);
		cp.add(sp, "Center");

		p.setLayout(new GridLayout(10, 1));
		p.add(b1);
		p.add(b2);
		cp.add(p, "East");
		cp.add(tf, "South");

		f.setSize(500, 400);
		f.setVisible(true);
		tf.requestFocus();
	}

	public void go(String ip, int port, String name) {
		try {
			s = new Socket(ip, port);
			oos = new ObjectOutputStream(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			ct = new ChatClientThread(br);
			ct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class ChatClientThread extends Thread {
		private BufferedReader br;
		private boolean isRunning = true;

		public ChatClientThread(BufferedReader br) {
			this.br = br;
		}

		public void stopRun() {
			isRunning = false;
		}

		@Override
		public void run() {
			String msg;
			try {
				while (isRunning) {
					msg = br.readLine();
					System.out.println(msg);
					ta.append(msg + "\n");
					ta.setCaretPosition(ta.getDocument().getLength());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ChatClient cl = new ChatClient();
		cl.createGUI();
		cl.addEvent();
		cl.go("70.12.108.169", 1024, "hyejeong");
	}
}