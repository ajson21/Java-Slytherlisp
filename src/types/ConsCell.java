package types;

public class ConsCell {
	
	private Object car;
	private Object cdr;
	
	public ConsCell(Object car, Object cdr) {
		
		this.car = car;
		this.cdr = cdr;
		
	}
	
	Boolean equals(ConsCell first, ConsCell second) {
		
		if(first.getCar().equals(second.getCar()) && first.getCdr().equals(second.getCdr())){
			
			return true;
			
		}
		
		return false;
		
	}

	public Object getCar() {
		return car;
	}

	public void setCar(Object car) {
		this.car = car;
	}

	public Object getCdr() {
		return cdr;
	}

	public void setCdr(Object cdr) {
		this.cdr = cdr;
	}

	@Override
	public String toString() {
		return "(cons " + car + " " + cdr + ")";
	}

}
