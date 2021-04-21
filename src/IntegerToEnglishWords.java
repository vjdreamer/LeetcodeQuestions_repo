
public class IntegerToEnglishWords {
	private static final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private static final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen"};
	private static final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	public static String numToWords(int num) {
		if (num == 0) return "Zero";
		return helper(num);
	}
	private static String helper(int num) {
		String res = new String();
		if (num < 10) res =  belowTen[num];
		else if (num < 20) res = belowTwenty[num - 10];
		else if (num < 100) res = belowHundred[num / 10] + " " + helper(num % 10);
		else if (num < 1000) res = helper(num / 100) + " Hundred " + helper(num % 100);
		else if (num < 1000000) res = helper(num / 1000) + " Thousand " + helper(num % 1000);
		else if (num < 1000000000) res = helper(num / 1000000) + " Million " + helper(num % 1000000);
		else res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
		return res.trim();
	}
	public static void main(String args[]) {
		System.out.println(numToWords(123));
	}
}
