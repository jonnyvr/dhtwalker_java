package core.dht.bencode.entity;

import java.util.ArrayList;

import core.dht.bencode.exception.Error_init;

public abstract class Entity {
	protected Object _value = null;
	
	public Entity(Object... tmp_v) throws Exception{
		if(tmp_v.length == 1) {
			this._value = tmp_v[0];	
			
		}
		else {
			this._value = new ArrayList<Entity>();
			for(int i=0; i < tmp_v.length; i++) {
				if(tmp_v[i] != null) {
					if(tmp_v[i] instanceof Entity) {
						((ArrayList<Entity>)this._value).add((Entity)tmp_v[i]);
					}
				}
				else {
					throw new Error_init();								
				}
			}			
		}
	}
	
	private ArrayList<Entity> init_v(Entity tmp_obj) {
		ArrayList<Entity> tmp_list = new ArrayList<Entity>();
		if(tmp_obj instanceof EntityInt || tmp_obj instanceof EntityString) {
			tmp_list.add(tmp_obj);
		}
		else {
			if(tmp_obj instanceof EntityDictionary || tmp_obj instanceof EntityList) {
				
			}
			else {
				
			}
		}
		return tmp_list;
	}
	
	protected String travel(Object tmp_obj) {
		String tmp_str = "";
		
		if(tmp_obj != null) {			
			if(tmp_obj instanceof Entity) {
				tmp_str += tmp_obj.toString();
			}
			else {
				if(tmp_obj instanceof ArrayList) {
					for(int i=0; i < ((ArrayList<Entity>)tmp_obj).size(); i ++) {
						Object tmp_obj_tmp =((ArrayList<Entity>)tmp_obj).get(i); 
						tmp_str += travel(tmp_obj_tmp);		
					}
				}				
				else {
					
				}
			}	
		}	
		
		
		return tmp_str;
	}
	
	public Object get_value() {
		return this._value;
	}
	
	public abstract String toString();	
	
}
