package core.dht.bencode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			
			
			
//			System.out.println(Bencode.encode(tmp_obj6));
			
			
			Bencode.decode("dl4:1111e4:2222i333ee");
			
			
//			Pattern regex = Pattern.compile("i([1-9]\\d*)e");
			Pattern regex = Pattern.compile("[1-9]+");
			Matcher ret = regex.matcher("dl4:1111e4:2222i333ee");
			if(ret.matches()) {
				
				System.out.println(ret.group(0).toString());
//				System.out.println(ret.groupCount());	
			}
			else {
				System.out.println("no match");
			}
			
			
			
			/*
			 * 
			 * i([1-9]\d*)e
			 * ([1-9])+\:.{5}
			 * 
			 * 
			 */
			
		}catch(Exception ee) {
			System.out.println(ee.toString());
		}
		
		
	}
}
