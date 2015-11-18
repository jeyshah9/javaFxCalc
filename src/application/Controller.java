package application;

import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

	double sMemory;
	@FXML
	private Label num1, num2, op, num1S, num2S, opS;
	@FXML
	private TextArea history;
	private Model model = new Model();
	boolean Flag = true;

	@FXML
	private void processNumpad(ActionEvent event) {
		Button button = (Button) event.getSource();

		if (Flag) {
			op.setText("");
			num1.setText(num1.getText() + button.getText());
		} else {
			num2.setText(num2.getText() + button.getText());
		}
	}

	@FXML
	private void clearLast(ActionEvent actionEvent) {
		if (Flag) {
			num1.setText("");
			Flag = true;
		} else {
			num2.setText("");
		}
	}

	@FXML
	private void clearAll(ActionEvent actionEvent) {
		num1.setText("");
		num2.setText("");
		op.setText("");
		Flag = true;
	}

	@FXML
	private void deleteLastInput(ActionEvent actionEvent) {
		if (Flag) {
			String sLast = num1.getText();
			try {
				String sNewLast = sLast.substring(0, sLast.length() - 1);
				num1.setText(sNewLast);
			} catch (Exception e) {

			}
		} else {
			String sLast = num2.getText();
			try {
				String sNewLast = sLast.substring(0, sLast.length() - 1);
				num2.setText(sNewLast);
			} catch (Exception e) {

			}
		}

	}

	@FXML
	private void processOperator(ActionEvent event) {
		Button button = (Button) event.getSource();
		Flag = false;
		String operator = button.getText();
		if (operator.equals("=")) {
			Long number1 = Long.parseLong(num1.getText());
			Long number2 = Long.parseLong(num2.getText());
			String operation = op.getText().toString();

			String result = model.calculate(number1, number2, operation) + "";
			clearAll(event);
			op.setText(result);
			history.appendText(number1 + "" + operation + "" + number2 + "=" + result + "\n");
		} else {
			op.setText(operator);
		}
	}

	// For Scientific Cals
	@FXML
	private void scientific(ActionEvent actionEvent) {

		Button button = (Button) actionEvent.getSource();
		String s = button.getText().toString();
		if (!(num1S.getText()).equals("")) {
			double d = Double.parseDouble(num1S.getText().toString());
			double answer = model.special(d, s);
			history.appendText(s + "(" + num1S.getText() + ") =" + answer + "\n");
			clearAllS(actionEvent);
			opS.setText(answer + "");
		} else {
			double d = Double.parseDouble(num2S.getText().toString());
			double answer = model.special(d, s);
			history.appendText(s + "(" + num2S.getText() + ") =" + answer + "\n");
			clearAllS(actionEvent);
			opS.setText(answer + "");

		}
		Flag = true;
	}

	@FXML
	private void processNumpadS(ActionEvent event) {
		Button button = (Button) event.getSource();

		if (Flag) {
			opS.setText("");
			num1S.setText(num1S.getText() + button.getText());
		} else {
			num2S.setText(num2S.getText() + button.getText());
		}
	}

	@FXML
	private void clearLastS(ActionEvent actionEvent) {
		if (Flag) {
			num1S.setText("");
			Flag = true;
		} else {
			num2S.setText("");
		}
	}

	@FXML
	private void clearAllS(ActionEvent actionEvent) {
		num1S.setText("");
		num2S.setText("");
		opS.setText("");
		Flag = true;
	}

	@FXML
	private void deleteLastInputS(ActionEvent actionEvent) {
		if (Flag) {
			String sLast = num1S.getText();
			try {
				String sNewLast = sLast.substring(0, sLast.length() - 1);
				num1S.setText(sNewLast);
			} catch (Exception e) {

			}
		} else {
			String sLast = num2S.getText();
			try {
				String sNewLast = sLast.substring(0, sLast.length() - 1);
				num2S.setText(sNewLast);
			} catch (Exception e) {

			}
		}

	}

	@FXML
	private void processOperatorS(ActionEvent event) {
		Button button = (Button) event.getSource();
		Flag = false;
		String operator = button.getText();
		if (operator.equals("=")) {
			Long number1 = Long.parseLong(num1S.getText());
			Long number2 = Long.parseLong(num2S.getText());
			String operation = opS.getText().toString();

			String result = model.calculate(number1, number2, operation) + "";
			clearAllS(event);
			opS.setText(result);
			history.appendText(number1 + "" + operation + "" + number2 + "=" + result + "\n");
		} else {
			opS.setText(operator);
		}
	}

	@FXML
	private void Export(ActionEvent event) throws Exception {
		PrintWriter printWriter = new PrintWriter("Export.txt");
		printWriter.println(history.getText());
		printWriter.close();

	}

	@FXML
	private void Binary(ActionEvent actionEvent) {
		if (!(num1S.getText()).equals("")) {
			int i = Integer.parseInt(num1S.getText().toString());
			String bin = Integer.toBinaryString(i);
			history.appendText(i + "=" + bin + "\n");
			clearAllS(actionEvent);
			opS.setText(bin + "");
		} else {
			int i = Integer.parseInt(num2S.getText().toString());
			String bin = Integer.toBinaryString(i);
			history.appendText(i + "=" + bin + "\n");
			clearAllS(actionEvent);
			opS.setText(bin + "");

		}
		Flag = true;
	}

	@FXML
	private void Memory(ActionEvent actionEvent) {

	}
}
