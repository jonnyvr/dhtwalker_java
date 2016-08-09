package core.dht.req;

public class Req_ping extends Req {
	
	public Req_ping(String tmp_nodeid_target) {
		this._q = "ping";
		this._a = "{}";
	}
}
