package com.metacube.get2019;

/**
 * It is a class used to evaluate infix expression.
 * @author Kritika
 *
 */
public class EvaluateInfix {
	StackUsingLinkList stackObj = new StackUsingLinkList();
	StackUsingLinkList stackObj1 = new StackUsingLinkList();
	
	/**
	 * It is a method used to convert infix into postfix expression.
	 * @param str infix expression as string.
	 * @return postfix expression as string.
	 */
	public String infixToPostfix(String str) {
		StringBuffer postfixStr = new StringBuffer(" ");
		String[] strArray = str.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			String str1 = strArray[i];
			int j = 0;
			if (j < str1.length() && str1.charAt(j) >= '0' && str1.charAt(j) <= '9' ) {
				StringBuffer sb = new StringBuffer("");
				while (j < str1.length() && str1.charAt(j) >= '0' && str1.charAt(j) <= '9' ) {
					sb.append(str1.charAt(j));
					j++;
				}
				postfixStr.append(sb);
				postfixStr.append(" ");
			}
			else if ("(".equals(str1) ) {
				stackObj.push(str1);
			}
			else if (")".equals(str1)) {
				while (!stackObj.isEmpty() && !"(".equals(stackObj.peek())) {
					postfixStr.append(stackObj.pop());
					postfixStr.append(" ");
				}
				if ("(".equals(stackObj.peek())) {
					stackObj.pop();
				}
			}
			else {
				while (!stackObj.isEmpty() && precedence(str1) >= precedence(stackObj.peek())) {
					postfixStr.append(stackObj.pop());
					postfixStr.append(" ");
				}
				stackObj.push(str1);
				while (stackObj.isEmpty() || precedence(str1) < precedence(stackObj.peek())) {
					stackObj.push(str1);
				}
			}
		}
		while (!stackObj.isEmpty()) {
			postfixStr.append(stackObj.pop());
			postfixStr.append(" ");
		}
		return postfixStr.toString();
	}
	
	/**
	 * It is a method used to evaluate postfix expression.
	 * @param str postfix expression.
	 */
	public void evaluatePostfix(String str) {
		String[] strArray = str.split(" ");
		for (int i = 1; i < strArray.length; i++) {
			String str1 = strArray[i];
			int j = 0;
			if (str1.charAt(j) >= '0' && str1.charAt(j) <= '9' ) {
				StringBuffer sb = new StringBuffer("");
				while (j < str1.length() && str1.charAt(j) >= '0' && str1.charAt(j) <= '9' ) {
					sb.append(str1.charAt(j));
					j++;
				}
				stackObj1.push(sb.toString());
			}
			else {
				String result = applyOperator(str1, stackObj1.pop(), stackObj1.pop());
				stackObj1.push(result);
			}
		}
		System.out.println("Value of infix expression : "+stackObj1.pop());
	}
	
	/**
	 * It is method to find precedence of operators.
	 * @param str Operator as a string.
	 * @return precedence value.
	 */
	private int precedence (String str) {
		
		switch (str) {
		case "/" :
		case "*" :
			return 1;
		case "+" :
		case "-" :
			return 2;
		case "<" :
		case ">" :
		case ">=" :
		case "<=" :
			return 3;
		case "==" :
		case "!=" :
			return 4;
		case "&&" :
			return 5;
		case "||" :
			return 6;
		case "(" :
			return 7;
		default :
			return -1;
		} 
	}
	
	/**
	 * It is a method used to applyOperator on 2 numbers.
	 * @param str1 operator as a string
	 * @param s1 first number as string
	 * @param s2 second number as string
	 * @return result as a string.
	 */
	private String applyOperator(String str1, String s1, String s2) {
		int firstNum, secondNum, result;
		String result1 = "";
		boolean answer, first, second;
		switch(str1) {
		case "+" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			result = (firstNum + secondNum);
			result1 = Integer.toString(result);
			break;
		case "-" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			result = (secondNum - firstNum);
			result1 = Integer.toString(result);
			break;
		case "*" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			result = (firstNum * secondNum);
			result1 = Integer.toString(result);
			break;
		case "/" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			try {
				result = (secondNum / firstNum);
				result1 = Integer.toString(result);
			} catch ( ArithmeticException e) {
				System.out.println(e.getStackTrace());
			}
			break;
		case "<" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			answer = (secondNum < firstNum);
			result1 = Boolean.toString(answer);
			break;
		case ">" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			answer = (secondNum > firstNum);
			result1 = Boolean.toString(answer);
			break;
		case "<=" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			answer = (secondNum <= firstNum);
			result1 = Boolean.toString(answer);
			break;
		case ">=" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			answer = (secondNum >= firstNum);
			result1 = Boolean.toString(answer);
			break;
		case "!=" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			answer = (secondNum != firstNum);
			result1 = Boolean.toString(answer);
			break;
		case "==" :
			firstNum = Integer.parseInt(s1);
			secondNum = Integer.parseInt(s2);
			answer = (secondNum == firstNum);
			result1 = Boolean.toString(answer);
			break;
		case "&&" :
			first = Boolean.parseBoolean(s1);
			second = Boolean.parseBoolean(s2);
			answer = second && first;
			result1 = Boolean.toString(answer);
			break;
		case "||" :
			first = Boolean.parseBoolean(s1);
			second = Boolean.parseBoolean(s2);
			answer = second || first;
			result1 = Boolean.toString(answer);
			break;
		default :
			System.out.println("Not avaiable operator ");
		}
		return result1;
	}
}