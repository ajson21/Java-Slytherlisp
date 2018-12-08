package types;

import java.util.Map;

public class UserFunction {
	
	private SExpression params;
	private SExpression body;
	private Map environ;
	
	public UserFunction(SExpression params, SExpression body, Map environ) {
		
		this.params = params;
		this.body = body;
		this.environ = environ;
		
	}
	
	public void call() {
		
		
		
	}
	

}
