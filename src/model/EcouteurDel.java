package model;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 * Classe permettant de gerer le bouton
 * de remise a zero d'une case du Sudoku
 */
public class EcouteurDel implements ActionListener {
	
	private JButton[][] buttonSudoku;

	public EcouteurDel(JButton[][] buttonSudoku) {
		super();
		this.buttonSudoku = buttonSudoku;
	}

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//on récupère le bouton du sudoku sélectionné;
				JButton selected = new JButton();
				for (int i = 0; i < buttonSudoku.length; i++) {
					for (int j = 0; j < buttonSudoku.length; j++) {
						if (buttonSudoku[i][j].getBackground().getRGB() == Color.GRAY.getRGB()){
							 selected = buttonSudoku[i][j];
						}
					}
				}
				selected.setText("0"); //on met sa valeur à 0
					

	}

}
