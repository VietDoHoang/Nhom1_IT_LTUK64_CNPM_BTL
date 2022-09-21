package GUI;


import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Decorate all types of JButton in the program
 * Author: Dinh Duc Lam
 */
public class Button extends JButton{
	
	public static final int NOMAL_BUTTON = 0;
	public static final int CHOOSE_BUTTON = 1;
	
	public Button(int buttonType, ActionListener a, String text){
		if (buttonType == NOMAL_BUTTON) {
			setContentAreaFilled(false);
		}
		else if (buttonType == CHOOSE_BUTTON) {
			setForeground(SystemColor.info);
			setFont(new Font("Tahoma", Font.PLAIN, 14));
			setBackground(SystemColor.activeCaption);
			setBorder(null);
		}
		setText(text);
		addActionListener(a);
	}
	
	public Button(int buttonType, ActionListener a, String text, ImageIcon icon){
		this(buttonType, a, text);
		setIcon(icon);
	}
	
	public Button(ActionListener a, ImageIcon icon) {
		setIcon(icon);
		addActionListener(a);
		setBackground(SystemColor.activeCaption);
		setBorder(null);
	}
}
