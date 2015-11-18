package application;

public class Model {
	public long calculate(long number1, long number2, String operator) {
		switch (operator) {
		case "+":
			return number1 + number2;
		case "-":
			return number1 - number2;
		case "*":
			return number1 * number2;
		case "/":
			if (number2 == 0)
				return 0;

			return number1 / number2;
		}

		// System.out.println("Unknown operator - " + operator);
		return 0;
	}

	public double special(double number1, String op) {
		switch (op) {
		case "Sin":
			return Math.sin(number1);
		case "Cos":
			return Math.cos(number1);
		case "Log":
			return Math.log(number1);
		case "Square":
			return Math.pow(number1, 2);
		case "Sqr Root":
			return Math.sqrt(number1);
		case "e^":
			return Math.pow(Math.E, number1);
		}
		return 0;
	}
}
