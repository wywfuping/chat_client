package com.chat.client;

import java.io.BufferedReader;
import java.io.IOException;

public class ReceiveMessage implements Runnable {
	BufferedReader reader;

	public ReceiveMessage(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(reader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
