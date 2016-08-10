package core.dht.msg.req;

public class Req_ping extends Req {
	private String _nodeid_target;
	
	public Req_ping(String tmp_nodeid_target) {
		this._q = "ping";
		this._nodeid_target = tmp_nodeid_target;		
	}
	
	public byte[] toData() {
		//{"t":"aa", "y":"q","q":"ping", "a":{"id":"abcdefghij0123456789"}}
		return null;
	}
}
