package core.dht.msg.req;

public class Req_findNode extends Req {
	
	
	public Req_findNode() {
		this._q = "find_node";		
	}
	
	public byte[] toData() {
		//{"t":"aa", "y":"q","q":"find_node", "a":{"id":"abcdefghij0123456789","target":"mnopqrstuvwxyz123456"}}
		return null;
	}
}
