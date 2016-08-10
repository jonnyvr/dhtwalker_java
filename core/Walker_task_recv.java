package core;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Walker_task_recv extends Thread{
	private DatagramPacket s_datapac;
	private DatagramSocket s_server;
	
	public Walker_task_recv(DatagramPacket tmp_pack, DatagramSocket tmp_server) {
		this.s_datapac = tmp_pack;
		this.s_server = tmp_server;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		DatagramPacket tmp_data_toresp = null;
		
		synchronized (Config.s_lock_sender) {
			try {
//				this.s_server.send(tmp_data_toresp);
				
				//this.s_server.sen
				
			}catch (Exception ee) {
				
			}			
		}
	}

}
