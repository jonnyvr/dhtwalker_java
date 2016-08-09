package core;

import java.net.ServerSocket;
import java.net.Socket;

public class Walker_listener extends Thread{
	private Config s_config;
	
	public Walker_listener(Config tmp_config) {
		this.s_config = tmp_config;
	}
	
	public void run() {
		try {
			ServerSocket tmp_server = new ServerSocket(this.s_config.s_bind_port);
			
			while(true) {
				Socket tmp_sok = tmp_server.accept();
				Walker_worker tmp_worker = new Walker_worker(tmp_sok);
				
				Walker.s_walker_pool.addRecvAction(tmp_worker);				
				
			}
			
			
		}catch(Exception e) {
			
		}
	}
	
	
	
}
