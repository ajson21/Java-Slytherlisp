package types;

public class SExpression extends ConsList{

	private Object car;
	private SExpression cdr;
	
	public SExpression(Object car) {
		super(car);
		this.car = car;
		this.cdr = null;
	}
	
	public SExpression(Object car, SExpression cdr) {
		
		super(car, cdr);
		this.car = car;
		this.cdr = cdr;
		
	}
	
}
