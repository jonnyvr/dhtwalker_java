package core.dht.bencode.entity;

public class EntityString extends Entity{	
	
	public EntityString(String tmp_v)  throws Exception{
		super(tmp_v);
	}
	
	@Override
	public String toString() {
		String tmp_v = this._value.toString();
		
		String tmp_str = String.format("%d:%s", tmp_v.length(), tmp_v);
		
		return tmp_str;
	}
}
