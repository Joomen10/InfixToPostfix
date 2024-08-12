package hw2;

import java.util.*;

public class Converter {

	private String infixExpression; // The infix expression to be converted.
	private List<String> tokens; // The tokens parsed from the infix expression.

	public Converter(String infixExpression) {
		this.infixExpression = infixExpression;
		this.tokens = ParserHelper.parse(infixExpression.toCharArray());
	}
	
	public static int findPrec(String operatorStack) { 
        if (operatorStack.equals("^")) {
            return 3;
        }
        if (operatorStack.equals("*") || operatorStack.equals("/")) {
            return 2;
        }
        if (operatorStack.equals("+")|| operatorStack.equals("-")) {
            return 1;
        }
            return 0;
    }
	
	/**
	 * Converts the infix expression to a postfix expression.
	 *
	 * @return the postfix expression as a String.
	 */
	public String toPostFix() {

		// ref: https://runestone.academy/ns/books/published/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html

		// the stack you will use to build the postfix expression
		ArrayStack<String> stack = new ArrayStack<>();

		// We will now introduce the stringbuilder class - ref https://www.simplilearn.com/tutorials/java-tutorial/stringbuilder-in-java
		StringBuilder postfix = new StringBuilder();

// Follow the steps below strictly to fill in the 2 parts below. The postfix expression is built via-
		
// 1. If the token is an operand, append it to the end of the postfix list.

// 2. If the token is a left parenthesis, push it on the stack.

// 3. If the token is a right parenthesis, pop the stack until the 
// corresponding left parenthesis is removed. Append each operator to the end of the postfix list.

// 4. Else : If the token is an operator, *, /, +, or -, push it on the stack. However, 
// first remove any operators already on the opstack that have higher or equal precedence and append them to the output list.
		
		// Iterate through tokens.
		for (String token : tokens) {
			if (Character.isDigit(token.charAt(0))) { // If token is a digit, append to postfix expression.
				postfix.append(token).append(" ");
			} else if (token.equals("(")) { // If token is "(", push onto stack.
				stack.push(token);
			} else if (token.equals(")")) {
				// Part 1: fill up this condition
				
	            while (!stack.isEmpty() && (!stack.top().equals("("))) {
	            	System.out.println(postfix);
	            	System.out.println(stack.top());
                    postfix.append(stack.top() + " ");
                    
                    stack.pop();
                    System.out.println(stack.top());
                }
	            System.out.println(stack.top());
	            stack.pop();
	            
				// end here
			} else {

				// Part 2: fill up this condition
				
				// Added "findPrec" method above for Precedence
				while (!stack.isEmpty() && (!stack.top().equals("(")) && (findPrec(token) <= findPrec(stack.top()))) {
					System.out.println(stack.top());
					postfix.append(stack.pop() + " ");
				}
				stack.push(token); 

				// end here
			}
		}
		while (!stack.isEmpty()) {
			postfix.append(stack.pop()).append(" ");
		}
		
		return postfix.toString().trim();
		
	}
}
