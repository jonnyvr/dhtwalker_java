package core.dht.bencode.entity;

public class EntityInt extends  Entity {
	
	public EntityInt(Integer tmp_v) throws Exception{
		super(tmp_v);
	}
	
	@Override
	public String toString() {
		
		String tmp_str = String.format("i%se", this._value.toString());
		
		return tmp_str;
	}
}
