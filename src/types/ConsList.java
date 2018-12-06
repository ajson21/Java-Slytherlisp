package types;

import java.util.ArrayList;
import java.util.Stack;

public class ConsList extends ConsCell {

	private Object car;
	private ConsList cdr;

	public ConsList(Object car) {

		super(car, null);
		this.car = car;
		this.cdr = null;

	}

	public ConsList(Object car, ConsList cdr) {

		super(car, cdr);
		this.car = car;
		this.cdr = cdr;

	}

	public static ConsList fromIterable(Object[] array, int index) {

		if (index == array.length - 1) {

			return new ConsList(array[index]);

		} else {

			return new ConsList(array[index], fromIterable(array, index + 1));

		}

	}

	public static ConsList fromIterable(ArrayList<Object> arrayList, int index) {

		if (index == arrayList.size() - 1) {

			return new ConsList(arrayList.get(index));

		} else {

			return new ConsList(arrayList.get(index), fromIterable(arrayList, index + 1));

		}

	}

	public Object getItem(int index) {

		ConsList result = this;

		while (index > 0) {

			if (result.cdr == null) {

				return null;

			}

			result = result.cdr;
			index -= 1;

		}

		return result.car;

	}

	public boolean equals(ConsList second) {

		if (this.getCdr() != null && second.getCdr() != null) {

			if (this.getCdr() instanceof ConsList && second.getCdr() instanceof ConsList) {

				if (this.getCar().equals(this.getCar())) {

					return this.getCdr().equals(second.getCdr());

				}

				return false;

			}

		}

		if (this.getCar().equals(second.getCar())) {

			return true;

		}

		return false;

	}

	public ArrayList<Object> iterate() {

		ArrayList<Object> result = new ArrayList<Object>();
		ConsList temp = this;

		if (temp.car == null) {

			return result;

		}

		if (temp.cdr == null) {

			result.add(temp.car);
			return result;

		}

		while (temp.cdr != null) {

			result.add(temp.car);
			temp = temp.cdr;

		}

		result.add(temp.car);
		return result;

	}

	public ArrayList<Object> cells() {

		ArrayList<Object> result = new ArrayList<Object>();
		ConsList temp = this;

		if (temp.car == null) {

			return result;

		}

		if (temp.cdr == null) {

			result.add(temp);
			return result;

		}

		while (temp.cdr != null) {

			result.add(temp);
			temp = temp.cdr;

		}

		result.add(temp);
		return result;

	}

	public int length() {

		int result = 0;
		ConsList temp = this;

		if (temp.car == null) {

			return result;

		}

		if (temp.cdr == null) {

			result += 1;
			return result;

		}

		while (temp.cdr != null) {

			result += 1;
			temp = temp.cdr;

		}

		result += 1;
		return result;

	}

	public boolean contains(ConsList item) {

		ConsList temp = this;

		if (temp.car == null) {

			return false;

		}

		if (temp.cdr == null) {

			if (temp.equals(item)) {

				return true;

			}

			return false;

		}

		while (temp.cdr != null) {

			if (temp.equals(item)) {

				return true;

			}

			temp = temp.cdr;

		}

		if (temp.equals(item)) {

			return true;

		}

		return false;

	}
	
	public ArrayList<Object> reversed(){
		
		ArrayList<Object> result = new ArrayList<Object>();
		ConsList temp = this;
		Stack<Object> stack = new Stack<Object>();
		
		if (temp.car == null) {

		} else if (temp.cdr == null) {
			
			stack.push(temp.car);

		} else {
			
			while (temp.cdr != null) {
				
				stack.push(temp.car);
				temp = temp.cdr;

			}

			stack.push(temp.car);
			
		}
		
		while(!stack.isEmpty()) {
			
			result.add(stack.pop());
			
		}
		
		return result;
		
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

	@Override
	public String toString() {
		
		String result = "(list";
		ConsList temp = this;

		if (temp.car == null) {
			
		} else if (temp.cdr == null) {
			
			result += " " + temp.car.toString();

		} else {
			
			while (temp.cdr != null) {
				
				result += " " + temp.car.toString();
				temp = temp.cdr;

			}
			
		}
		
		result += " " + temp.car.toString();
		
		result += ")";	
		return result;
		
	}

}
