package core;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import core.dht.req.Req;

public class Req_queue {
	private Queue s_req_list = new LinkedBlockingQueue();
	
	
	public boolean isEmpty() {
		return this.s_req_list.size() > 0? false:true;
	}
	
	public void addReq(Req tmp_req) {
		this.s_req_list.add(tmp_req);
	}
	
	public Req getOnReq() {
		Req tmp_obj = null;
		try {
			if(!this.isEmpty()) {
				tmp_obj = (Req)this.s_req_list.remove();
			}	
		}catch(Exception e) {
			
		}				
		return tmp_obj;		
	}
	
}
