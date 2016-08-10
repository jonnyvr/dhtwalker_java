package core.dht.msg.resp;

public abstract class Resp {
	protected String _from;
	protected String _t;
	protected String _y;
	protected String _r;
	
	
	public Resp() {
		this._t = "tt";
		this._y = "r";
		this._r = "";		
	}
	
	

	public abstract byte[] toData() ;
}
