package core;


public class Walker {
	public static Walker_task_pool s_walker_pool;
	public static Req_queue s_req_queue = new Req_queue();
	
	
	public Config s_config = null;
	
	
	public void begin() {
		this.beginListen();
		
		
	}
	
	private void beginListen(){
		new Walker_listener(this.s_config).start(); 
	}

}
