package types;

import java.util.HashMap;
import java.util.Map;

public class LexicalVarStorage {
	
	private Map<String, Variable> environ;
	private Map<String, Variable> local;
	
	public LexicalVarStorage(Map<String, Variable> environ) {
		
		this.environ = environ;
		local = new HashMap<String, Variable>();
		local.clear();
		
	}
	
	public Map<String, Variable> fork() {
		
		Map<String, Variable> result = new HashMap<String, Variable>();
		
		for(String i: environ.keySet()) {
			
			result.put(i, environ.get(i));
			
		}
		
		for(String i: environ.keySet()) {
			
			result.put(i, environ.get(i));
			
		}
		
		return result;
		
	}
	
	public void put(String name, Variable value) {
		
		local.put(name, value);
		
	}
	
	public Variable getItem(String name){
		
		if(local.keySet().contains(name)) {
			
			return local.get(name);
			
		} else if(environ.keySet().contains(name)) {
			
			environ.get(name);
			
		}
		
		return null;
		
	}
	
}
