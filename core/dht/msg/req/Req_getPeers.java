package core.dht.msg.req;

public class Req_getPeers extends Req {
	
	public Req_getPeers() {
		this._q = "get_peers";
		
	}
	
	public byte[] toData() {
		//"a":{"id":"abcdefghij0123456789","info_hash":"mnopqrstuvwxyz123456"}}
		return null;
	}
}
