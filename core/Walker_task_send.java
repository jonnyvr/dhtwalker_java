package core;

import java.net.DatagramSocket;

public class Walker_task_send extends Thread{
	private DatagramSocket s_server;
	
	public Walker_task_send(DatagramSocket tmp_server) {
		this.s_server = tmp_server;
	}
	
	
	
	public void run() {
		
	}
}
