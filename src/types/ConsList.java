package types;

import java.util.ArrayList;

public class ConsList extends ConsCell{

	private Object car;
	private ConsList cdr;
	
	public ConsList(Object car) {
		
		super(car,null);
		this.car = car;
		this.cdr = null;
		
	}
	
	public ConsList(Object car, ConsList cdr) {
		
		super(car, cdr);
		this.car = car;
		this.cdr = cdr;
		
	}
	
	public static ConsList fromIterable(Object[] array, int index) {
		
		if(index == array.length - 1) {
			
			return new ConsList(array[index]);
			
		}else {
			
			return new ConsList(array[index], fromIterable(array,index+1));
			
		}
		
	}
	
	public static ConsList fromIterable(ArrayList<Object> arrayList, int index) {
		
		if(index == arrayList.size() - 1) {
			
			return new ConsList(arrayList.get(index));
			
		}else {
			
			return new ConsList(arrayList.get(index), fromIterable(arrayList,index+1));
			
		}
		
	}
	
	public Object getItem(int index) {
		
		ConsList result = this;
		
		while(index > 0) {
			
			result = result.cdr;
			
		}
		
		return result.car;
		
	}
	
	public boolean equals(ConsList second) {
		
		if(this.getCdr() != null && second.getCdr() != null) {
			
			if(this.getCdr() instanceof ConsList && second.getCdr() instanceof ConsList) {
				
				if(this.getCar().equals(this.getCar())){

					return this.getCdr().equals(second.getCdr());
					
				} 
				
				return false;
				
			}
			
		}
		
		if(this.getCar().equals(second.getCar())) {
			
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

	public ConsList getCdr() {
		return cdr;
	}

	public void setCdr(ConsList cdr) {
		this.cdr = cdr;
	}
	
}
