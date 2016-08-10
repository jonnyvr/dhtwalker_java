package core.dht.msg.resp;

import core.dht.msg.Msg_base;

public abstract class Resp extends Msg_base{
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
