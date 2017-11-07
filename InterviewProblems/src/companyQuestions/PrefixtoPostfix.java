package companyQuestions;
import java.util.Stack;

public class PrefixtoPostfix {
	public static void main(String[] args) {
		String[] s = {"*34", "+1*23"};
		System.out.println(prefixToPostfix(s));
		
		
		
	}
	
	static String[] prefixToPostfix(String[] prefixes) {
        String[] result = new String[prefixes.length];
        int j =0;
        for(String s : prefixes) {
            int n = s.length()-1;
            Stack<String> operand = new Stack<String>();
            for(int i = n; i>=0; i--) {
                if(Character.isDigit(s.charAt(i))) {
                    operand.push(s.charAt(i) + "");
                }
                if(isOperator(s.charAt(i))) {
                    String op1 = operand.pop();
                    String op2 = operand.pop();
                    String s1 = op1 + op2 + s.charAt(i);
                    operand.push(s1);
                }
                
            }
            StringBuilder sb = new StringBuilder();
                while(!operand.isEmpty()) {
                    sb.append(operand.pop());
                }
               result[j] = sb.toString();
               j++;
        }
        return result;
    }
    
    static boolean isOperator(char c) {
        if(c == '/' || c == '*' || c== '+' || c== '-')
            return true;
        return false;
    }
}
