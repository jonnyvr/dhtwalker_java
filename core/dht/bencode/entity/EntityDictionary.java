package core.dht.bencode.entity;

public class EntityDictionary extends Entity{

	public EntityDictionary(Entity...tmp_v)  throws Exception{
		super(tmp_v);
	}
	
	@Override
	public String toString() {
		String tmp_str = this.travel(this._value);
		
		tmp_str = String.format("d%se", tmp_str);		
		return tmp_str;
	}
}
