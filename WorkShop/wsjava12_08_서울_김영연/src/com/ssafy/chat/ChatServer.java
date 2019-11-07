package com.ssafy.chat;

import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

class ServerThread extends Thread {
	private ObjectInputStream ois;
	private PrintWriter pw;
	private Map<PrintWriter, String> li;

	public ServerThread(ObjectInputStream ois, PrintWriter pw, Map<PrintWriter, String> li) {
		this.ois = ois;
		this.pw = pw;
		this.li = li;
	}

	public void run() {
		try {
			while (true) {
				String msg = (String) ois.readObject();
				System.out.println(msg);
				for (PrintWriter p : li.keySet()) {
					p.print(li.get(pw) + ":");
					p.println(msg);
					p.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ChatServer {

	private static Map<PrintWriter, String> li = new HashMap<>();
	private static int cnt = 0;

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1024);
			ChatServer cs = new ChatServer();
			while (true) {

				System.out.println("Ready... 1024");
				Socket s = ss.accept();
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())));
				cnt++;
				li.put(pw, "사용자" + cnt);
				new ServerThread(ois, pw, li).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}