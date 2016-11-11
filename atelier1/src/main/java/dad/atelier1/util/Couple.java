package dad.atelier1.util;

public class Couple<T, U> {

	private T element1;
	private U element2;

	public Couple(T element1, U element2) {
		this.element1 = element1;
		this.element2 = element2;
	}

	public T getElement1() {
		return element1;
	}

	public U getElement2() {
		return element2;
	}

}
