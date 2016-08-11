package core.dht.bencode;

import core.dht.bencode.entity.Entity;
import core.dht.bencode.entity.EntityDictionary;
import core.dht.bencode.entity.EntityInt;
import core.dht.bencode.entity.EntityList;
import core.dht.bencode.entity.EntityString;

public class Test {
	public static void main(String[] args) {
		
		try {
			EntityString tmp_obj = new EntityString("dddddd");
			
			EntityInt tmp_obj1 = new EntityInt(32323);
			
			
			EntityList tmp_obj2 = new EntityList(tmp_obj, tmp_obj1);
			
			EntityList tmp_obj3 = new EntityList(tmp_obj2, tmp_obj, tmp_obj1);
			
			
			Entity tmp_obj6 = new EntityDictionary(new EntityList(new EntityString("1111")), new EntityString("2222"), new EntityInt(333));
			System.out.println(tmp_obj6.toString());
			//System.out.println(tmp_obj2.toString());
			
		}catch(Exception ee) {
			System.out.println(ee.toString());
		}
		
		
	}
}
