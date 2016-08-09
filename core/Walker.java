package core;


public class Walker {
	public static WalkerPool s_walker_pool;
	
	
	
	public Config s_config = null;
	
	
	public void begin() {
		this.beginListen();
		
		
	}
	
	private void beginListen(){
		new Walker_listener(this.s_config).start(); 
	}

}
