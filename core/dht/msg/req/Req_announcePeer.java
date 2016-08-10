package core.dht.msg.req;

public class Req_announcePeer extends Req {
	
	public Req_announcePeer() {
		this._q = "announce_peer";
		
	}
	
	public byte[] toData() {
		//"a":{"id":"abcdefghij0123456789","info_hash":"mnopqrstuvwxyz123456", "port":6881, "token": "aoeusnth"}}
		return null;
	}
}
