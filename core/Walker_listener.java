package core;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Timer;

public class Walker_listener extends Thread{
	private Config s_config;
	
	public Walker_listener(Config tmp_config) {
		this.s_config = tmp_config;
	}
	
	public void run() {
		try {
			DatagramSocket tmp_server = new DatagramSocket(this.s_config.s_bind_port);
			  
			new Timer().scheduleAtFixedRate(new Timer_check_reqQueue(tmp_server), 10000, 100);
			
			while(true) {
				System.out.println("begin received");
				
				DatagramPacket tmp_pack_recv = new DatagramPacket(new byte[this.s_config.s_pack_size_recv], this.s_config.s_pack_size_recv);				
				tmp_server.receive(tmp_pack_recv);
				
				System.out.println("received"+tmp_pack_recv.getData().toString());
				Walker_task_recv tmp_worker = new Walker_task_recv(tmp_pack_recv, tmp_server);
				
				Walker.s_walker_pool.addRecvAction(tmp_worker);				
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
