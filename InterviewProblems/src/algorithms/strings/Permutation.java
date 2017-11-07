package algorithms.strings;
public class Permutation {
	public static void main(String[] args) {
		
		permute("abcdef");
		
	}

	private static void permute(String string) {
		permute(string, 0, string.length()-1);
	}

	private static void permute(String string, int l, int r) {
		if(l == r) 
			System.out.println(string);
		else {
			for(int i = l ; i<=r; i++) {
				string = swap(string, l, i);
				permute(string, l+1, r);
				string = swap(string, l, i);
			}
		}
	}

	private static String swap(String string, int l, int i) {
		char[] str = string.toCharArray();
		char temp = str[l];
		str[l] = str[i];
		str[i] = temp;
		return String.valueOf(str);
	}
}
