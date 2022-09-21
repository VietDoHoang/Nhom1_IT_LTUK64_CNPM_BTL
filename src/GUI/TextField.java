package GUI;


import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

/*
 * Decorate all JTextField in the program
 * Author: Dinh Duc Lam
 */
public class TextField extends JTextField{
	
	public TextField() {
		// TODO Auto-generated constructor stub
		super();
		setBackground(UIManager.getColor("TextField.disabledBackground"));
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		setColumns(10);
	}
	
}
