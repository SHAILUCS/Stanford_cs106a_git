package general;

public class Rational {
	private int num;
	private int den;

	public Rational(int num, int den) {
		this.num = num;
		this.den = den;
	}

	public Rational add(Rational r) {
		r.addNumber(1);
		int numResult = this.num * r.den + r.num * this.den;
		int denResult = this.den * r.den;
		Rational result = new Rational(numResult, denResult);
		return result;
	}
	
	public void addNumber(int number) {
		num+=number;
		den+=number;
	}

	public String toString() {
		return num + "/" + den;
	}

}
