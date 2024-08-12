package hw2;

public class PostfixCalculator {
	
	public static double evaluate(String postfix) {
		ArrayStack<Double> stack = new ArrayStack<>(); // Stack to hold operands.
		String[] tokens = postfix.split(" "); // Split the postfix expression into tokens.
		double answer = 0.0;
		
		// Iterate through tokens.
		for (String token : tokens) {

			// Part 3 : fill up this function/section
			// the final element in the stack is the calculated result, and so it is popped and returned.
			
			if ((token).equals(" ")) {
	            continue;
			}
			
			else if (Character.isDigit(token.charAt(0))) {

	            stack.push(Double.parseDouble(token));
	        }
			
			else {
	            double b = stack.pop();
                double a = stack.pop();
                if (token.equals("+")){
                    answer = a+b;
                    stack.push(answer);
                }
                else if (token.equals("-")){
                    answer = a-b;
                    stack.push(answer);
                }
                else if (token.equals("*")){
                    answer = a*b;
                    stack.push(answer);
                }
                else if (token.equals("/")){
                    answer = a/b;
                    stack.push(answer);
                }
                else if (token.equals("^")){
                    answer = Math.pow(a, b);
                    stack.push(answer);
                }
            }
	    }
			
			// for hints, ref: https://runestone.academy/ns/books/published/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html
			
		
		
		return stack.pop(); 
		

	}
}
