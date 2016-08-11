package core.dht.bencode.entity;

import java.util.ArrayList;

public class EntityList extends Entity{

	public EntityList(Entity...tmp_v)  throws Exception{
		super(tmp_v);
	}
	
	@Override
	public String toString() {
		String tmp_str = this.travel(this._value);
				
		tmp_str = String.format("l%se", tmp_str);		
		return tmp_str;
	}
}
