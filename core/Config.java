package core;

public class Config {
	
	public static String s_bind_ip = "127.0.0.1";
	public static int s_bind_port = 8007;
	
	
	public static int s_count_workers = 10;
	
	public static int s_count_sender = 30;
	
	public static int s_pack_size_recv = 1024*64;
	
	public static Object s_lock_sender = new Object();
	
	
	
}
