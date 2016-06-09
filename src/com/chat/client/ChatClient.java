package com.chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.chat.data.UserData;

public class ChatClient {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw;
		while (true) {
			System.out.print("请输入用户名：");
			String name = sc.next();

			Socket s = new Socket(UserData.HOST, UserData.POINT);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			pw.println(name);

			String res = br.readLine();
			if (res.equals("success")) {
				ReceiveMessage rm = new ReceiveMessage(br);
				new Thread(rm).start();
				break;
			}
		}

		while (true) {
			String msg = sc.nextLine();
			pw.println(msg);
		}

	}

}
