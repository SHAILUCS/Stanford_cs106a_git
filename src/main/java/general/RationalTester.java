package general;

public class RationalTester {
	public static void main(String[] args) {
		Rational r1 = new Rational(1, 2);
		Rational r2 = new Rational(1, 3);
		System.out.println(r1);
		System.out.println(r2);
		r1.add(r2);
		System.out.println(r1);
		System.out.println(r2);
		
		//**************************************
		
		String str = "Prafull";
		System.out.println(str);
		str.concat(" Barve");
		System.out.println(str);
	}
}
