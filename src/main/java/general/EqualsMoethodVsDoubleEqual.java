package general;

public class EqualsMoethodVsDoubleEqual {
	public static void main(String[] args) {
		String s = "Hello";
		String t = "Hello";
		String p = new String("Hello");

		System.out.println(s==t);
		System.out.println(s.equals(t));
		System.out.println(s==p);
		System.out.println(s.equals(p));
		
		
		Integer i = new Integer(10);
		System.out.println(i);
		callingMethod(i);
		System.out.println(i);

		System.out.println(Integer.toString(420, 8));
	}

	private static void callingMethod(Integer i) {
		i = new Integer(20);
		System.out.println(i);
	}
}
