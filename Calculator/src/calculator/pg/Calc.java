package calculator.pg;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calc extends JFrame implements ActionListener {

	private Container container;

	private JLabel textBox;

	private static final Font SMALL_BUTTONS_FONT = new Font("Arial", Font.BOLD, 10);

	private static final String DEVIDE_BY_ZERO = "can't devide by zero !! press the clear button to continue";

	private static double doubleResultOfOperations;

	public static void main(String[] args) {

		Calc calculator = new Calc();

		calculator.start();
	}

	/**
	 * initialize all the things calculator needs to know
	 */
	private void start() {

		initCalc();
		InformationScreen();
		initOperatingButtons();
		initNumberickButtons();
		initCodingButtons();
		initTrigonometricOperations();
		initClearButton();

	}

	private JButton clear;

	/**
	 * initialize only the "clear" button with there size ,name,Font and
	 * specific Background color - RED , finally call another function to add
	 * them into the container and set them listeners
	 */
	private void initClearButton() {

		clear = new Button(310, 120, 50, 30, "C");
		clear.setBackground(Color.RED);
		clear.setFont(SMALL_BUTTONS_FONT);
		clear.addActionListener(this);
		container.add(clear);

	}

	JButton sin, cos, tng, cotg;

	/**
	 * initialize all trigonometric buttons with there size ,name,Font and
	 * finally call another function to add them into the container and set them
	 * listeners
	 */
	private void initTrigonometricOperations() {
		sin = new Button(20, 70, 80, 40, "sin");
		sin.setFont(SMALL_BUTTONS_FONT);
		cos = new Button(110, 70, 80, 40, "cos");
		cos.setFont(SMALL_BUTTONS_FONT);
		tng = new Button(200, 70, 80, 40, "tng");
		tng.setFont(SMALL_BUTTONS_FONT);
		cotg = new Button(290, 70, 80, 40, "cotg");
		cotg.setFont(SMALL_BUTTONS_FONT);
		addingButtonsToContainer(sin, cos, tng, cotg);

	}

	JButton bin, hex, oct;

	/**
	 * initialize all coding buttons with there size ,name,Font and finally call
	 * another function to add them into the container and set them listeners
	 */
	private void initCodingButtons() {
		bin = new Button(20, 120, 80, 40, "BIN");

		hex = new Button(110, 120, 90, 40, "HEX");
		oct = new Button(210, 120, 90, 40, "OCT");
		addingButtonsToContainer(bin, hex, oct);
	}

	private JButton zero, one, two, three, four, five, six, seven, eight, nine, point;

	/**
	 * initialize all numeric buttons with there size ,name,Font and finally
	 * call another function to add them into the container and set them
	 * listeners
	 */
	private void initNumberickButtons() {

		zero = new Button(20, 350, 110, 50, "0");
		point = new Button(140, 350, 50, 50, ".");
		one = new Button(20, 290, 50, 50, "1");

		two = new Button(80, 290, 50, 50, "2");
		three = new Button(140, 290, 50, 50, "3");
		four = new Button(20, 230, 50, 50, "4");
		five = new Button(80, 230, 50, 50, "5");
		six = new Button(140, 230, 50, 50, "6");
		seven = new Button(20, 170, 50, 50, "7");
		eight = new Button(80, 170, 50, 50, "8");
		nine = new Button(140, 170, 50, 50, "9");
		addingButtonsToContainer(zero, point, one, two, three, four, five, six, seven, eight, nine);
	}

	/**
	 * This method use for-each loop to add all the buttons and set them
	 * listeners
	 * 
	 * @param buttons
	 *            is array of buttons that has to be added to container
	 */
	private void addingButtonsToContainer(JButton... buttons) {

		for (JButton button : buttons) {
			container.add(button);
			button.addActionListener(this);
		}
	}

	private JButton equals, subtraction, multiplying, adding, plusMinus, partition, log, degrees;

	private boolean numberIsDouble;

	/**
	 * initialize all operating buttons with there size ,name,Font and finally
	 * call another function to add them into the container and set them
	 * listeners
	 */
	private void initOperatingButtons() {
		equals = new Button(300, 350, 50, 50, "=");
		subtraction = new Button(300, 290, 50, 50, "-");
		multiplying = new Button(300, 230, 50, 50, "x");
		adding = new Button(300, 170, 50, 50, "+");
		plusMinus = new Button(220, 170, 70, 50, "+-");
		partition = new Button(220, 230, 70, 50, "/");
		log = new Button(220, 290, 70, 50, "log");
		log.setFont(SMALL_BUTTONS_FONT);
		degrees = new Button(210, 350, 80, 50, "deg");
		log.setFont(SMALL_BUTTONS_FONT);
		addingButtonsToContainer(equals, subtraction, multiplying, adding, plusMinus, partition, log, degrees);

	}

	/**
	 * initialize calculator frame with his properties
	 */
	private void initCalc() {

		container = this.getContentPane();
		container.setLayout(null);
		container.setBackground(Color.gray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds(50, 50, 420, 470);
	}

	/**
	 * this initialize the textArea - where we show result
	 */
	private void InformationScreen() {
		textBox = new JLabel("0");
		textBox.setBounds(10, 20, 360, 40);
		textBox.setBackground(Color.GREEN);
		textBox.setForeground(Color.BLACK);
		textBox.setOpaque(true);

		container.add(textBox);

	}

	private boolean newNumber = false;
	private boolean firstNumber = true;

	/**
	 * Handles Action events of the buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Object button = e.getSource();

		if (button == clear) {
			textBox.setText("0");
			numberIsDouble = false;
			firstNumber = true;
			newNumber = true;
			doubleResultOfOperations = 0;
		}

		if (button == zero) {
			checkTextBox(0);
		}
		if (button == one) {
			checkTextBox(1);
		}

		if (button == two) {
			checkTextBox(2);
		}
		if (button == three) {
			checkTextBox(3);
		}
		if (button == four) {
			checkTextBox(4);
		}

		if (button == five) {
			checkTextBox(5);
		}
		if (button == six) {
			checkTextBox(6);
		}
		if (button == seven) {
			checkTextBox(7);
		}

		if (button == eight) {
			checkTextBox(8);
		}

		if (button == nine) {
			checkTextBox(9);
		}

		if (button == bin) {
			codingOperation("bin");
		}
		if (button == hex) {
			codingOperation("hex");
		}

		if (button == oct) {
			codingOperation("oct");
		}
		if (button == point) {
			numberIsDouble = true;
			checkTextBox(-1);
		}

		if (button == sin) {

			trigonometricOperations("sin");
		}
		if (button == cos) {

			trigonometricOperations("cos");
		}
		if (button == tng) {

			trigonometricOperations("tan");
		}
		if (button == cotg) {

			trigonometricOperations("cotg");
		}

		if (button == degrees) {
			// Calculate the number to DEGREES
			String num = textBox.getText();
			double number = Double.parseDouble(num);
			number = Math.toDegrees(number);
			textBox.setText(Double.toString(number));
		}

		if (button == log) {

			String num = textBox.getText();
			double number = Double.parseDouble(num);
			number = Math.log(number);
			textBox.setText(Double.toString(number));
		}

		if (button == plusMinus) {
			String num = textBox.getText();
			if (num.contains("-")) {
				num = num.substring(1, num.length());

			} else {
				num = "-" + num;
			}
			textBox.setText(num);
		}

		if (button == adding) {

			addingOperation();
			isAdding = true;
			isSubstraction = isMyltiplying = isPartition = false;
		}

		if (button == this.subtraction) {

			substractionOperation();
			isSubstraction = true;
			isAdding = isMyltiplying = isPartition = false;
		}

		if (button == this.multiplying) {

			multiplyingOperation();
			isMyltiplying = true;
			isAdding = isSubstraction = isPartition = false;

		}

		if (button == this.partition) {

			partitionOperation();
			isPartition = true;
			isAdding = isSubstraction = isMyltiplying = false;
		}

		if (button == this.equals) {
			if (isAdding) {
				this.addingOperation();
				isAdding = false;
			}

			if (isSubstraction) {
				substractionOperation();
				isSubstraction = false;
			}
			if (isMyltiplying) {
				multiplyingOperation();
				isMyltiplying = false;
			}
			if (this.isPartition) {
				partitionOperation();
				isPartition = false;
			}
		}
	}

	/**
	 * perform partition operation , and handles ArithmeticException also
	 */
	private void partitionOperation() {
		newNumber = true;
		String number = textBox.getText();

		if (firstNumber) {
			this.doubleResultOfOperations = Double.parseDouble(number);
			firstNumber = false;
			return;
		}
		try {

			double num = Double.parseDouble(number);
			if (num == 0) {
				throw new ArithmeticException();
			}
			this.doubleResultOfOperations /= num;

		} catch (ArithmeticException e) {

			textBox.setText(DEVIDE_BY_ZERO);
		}

	}

	/**
	 * perform multiplying operation
	 */
	private void multiplyingOperation() {
		newNumber = true;
		String number = textBox.getText();

		if (firstNumber) {
			this.doubleResultOfOperations = Double.parseDouble(number);
			firstNumber = false;
			return;
		}
		this.doubleResultOfOperations *= Double.parseDouble(number);
		textBox.setText(Double.toString(this.doubleResultOfOperations));

	}

	/**
	 * perform substraction operation
	 */
	private void substractionOperation() {
		newNumber = true;
		String number = textBox.getText();

		if (firstNumber) {
			this.doubleResultOfOperations = Double.parseDouble(number);
			firstNumber = false;
			return;
		}
		this.doubleResultOfOperations -= Double.parseDouble(number);
		textBox.setText(Double.toString(this.doubleResultOfOperations));

	}

	/**
	 * perform adding operation
	 */
	private void addingOperation() {
		newNumber = true;
		String number = textBox.getText();

		this.doubleResultOfOperations += Double.parseDouble(number);
		textBox.setText(Double.toString(this.doubleResultOfOperations));

	}

	// manage the buttons for Equals Button
	private boolean isAdding, isSubstraction, isMyltiplying, isPartition;

	/**
	 * perform trigonometric operations operation
	 */
	private void trigonometricOperations(String operation) {

		double doubleNumber;
		String number = textBox.getText();

		doubleNumber = Double.parseDouble(number);

		if (operation.equalsIgnoreCase("sin")) {
			doubleNumber = Math.sin(doubleNumber);
		}

		if (operation.equalsIgnoreCase("cos")) {
			doubleNumber = Math.cos(doubleNumber);
		}
		if (operation.equalsIgnoreCase("tan")) {
			doubleNumber = Math.tan(doubleNumber);
		}

		if (operation.equalsIgnoreCase("cotg")) {
			doubleNumber = Math.tan(doubleNumber);
		}
		textBox.setText(Double.toString(doubleNumber));
	}

	/**
	 * perform coding operation BIN,HEX,OCT also handles NumberFormatException -
	 * if number can't be converted
	 */
	private void codingOperation(String operation) {

		String number = textBox.getText();
		try {
			int n = Integer.parseInt(number);

			if (operation.equalsIgnoreCase("bin")) {
				textBox.setText(Integer.toBinaryString(n));
				return;
			}

			if (operation.equalsIgnoreCase("hex")) {
				textBox.setText(Integer.toHexString(n));
				return;
			}

			if (operation.equalsIgnoreCase("oct")) {
				textBox.setText(Integer.toOctalString(n));
				return;
			}
		} catch (NumberFormatException e) {
			textBox.setText("0");
		}

	}

	/**
	 * This method is called when user enters any number, if he enters point
	 * -"." then is called with number=-1
	 * 
	 * @param number
	 *            - the number that user has pressed
	 */
	private void checkTextBox(int number) {
		if (newNumber) {
			textBox.setText("0");
			newNumber = false;

		}
		String numberInTextBox = textBox.getText();

		if (number == -1) {
			if (numberInTextBox.contains(".")) {
				return;
			}
			numberInTextBox = numberInTextBox.concat(".");

		} else if (numberInTextBox == null || numberInTextBox.equals("0")) {
			numberInTextBox = Integer.toString(number);
		} else {
			numberInTextBox = numberInTextBox.concat(Integer.toString(number));

		}
		textBox.setText(numberInTextBox);

	}
}
