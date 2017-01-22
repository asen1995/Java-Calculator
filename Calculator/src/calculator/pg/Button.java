package calculator.pg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * 
 * @author asen this class creates Button
 */
public class Button extends JButton {

	private static final Color BUTTON_BG_COLOR = Color.DARK_GRAY;
	private static final Color BUTTON_FG_COLOR = Color.YELLOW;
	private static final Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 25);

	/**g
	 * for each new buttons - set this default properties
	 */
	public Button(int beginX, int beginY, int width, int height, String nameOfButton) {
		setText(nameOfButton);
		setBounds(beginX, beginY, width, height);
		setBackground(BUTTON_BG_COLOR);
		setForeground(BUTTON_FG_COLOR);
		setFont(BUTTONS_FONT);
	}

}
