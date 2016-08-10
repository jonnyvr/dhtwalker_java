package core;

import java.net.DatagramSocket;
import java.util.TimerTask;

import core.dht.msg.req.Req;

public class Timer_check_reqQueue extends TimerTask{
	private DatagramSocket s_server;
	
	public Timer_check_reqQueue(DatagramSocket tmp_server) {
		this.s_server = tmp_server;
	}
	
	public void run() {
//		// TODO Auto-generated method stub
//		try {
//			byte[] tmp_data_send = "hello".getBytes();
//			DatagramPacket tmp_pack_send = new DatagramPacket(tmp_data_send, tmp_data_send.length, InetAddress.getByName("127.0.0.1"), 10005);
//			s_server.send(tmp_pack_send);	
//		}catch(Exception eee) {
//			
//		}
		
		if(!Walker.s_req_queue.isEmpty()) {
			Req tmp_req = Walker.s_req_queue.getOnReq();
			
			Walker_task_send tmp_task_send = new Walker_task_send(s_server);
			Walker.s_walker_pool.addSendAction(tmp_task_send);			
			
		}
		
//		while(!Walker.s_req_queue.isEmpty()) {
//			Req tmp_req = Walker.s_req_queue.getOnReq();
//			
//			Walker_task_send tmp_task_send = new Walker_task_send(s_server);
//			Walker.s_walker_pool.addSendAction(tmp_task_send);
//		}
		
		System.out.println("in task");
	}
}
