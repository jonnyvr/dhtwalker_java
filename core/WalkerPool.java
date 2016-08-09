package core;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WalkerPool {
	protected static ExecutorService s_pool_recv = Executors.newFixedThreadPool(Config.s_count_workers);
	protected static ExecutorService s_pool_send = Executors.newFixedThreadPool(Config.s_count_sender);
	
	
	public static void addRecvAction(Thread tmp_action) {
		if(tmp_action != null) {
			s_pool_recv.execute(tmp_action);
		}
	}
	
	public static void addSendAction(Thread tmp_action) {
		if(tmp_action != null) {
			s_pool_send.execute(tmp_action);
		}
	}
	
	public static void shutDown() {
		try {
			s_pool_recv.shutdown();
			s_pool_send.shutdown();
		}catch(Exception e) {
			
		}
	}
}
