package types;

public class Quoted {

	private Object element;
	
	public Quoted(Object element) {
		
		this.element = element;
		
	}
	
	public Object getElement() {
		
		return element;
		
	}
	
	public boolean equals(Quoted second) {
		
		if(second.getElement().equals(this.getElement())) {
			
			return true;
			
		}
		
		return false;
		
	}
	
}
