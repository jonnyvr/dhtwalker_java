package core;

import java.net.Socket;

public class Walker_worker extends Thread{
	private Socket s_sok;
	
	public Walker_worker(Socket tmp_sok) {
		this.s_sok = tmp_sok;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
