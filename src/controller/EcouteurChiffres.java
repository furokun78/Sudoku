package controller;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

/**
 *  Classe permettant de modifier le chiffre
 *  de la case selectionnee sur le Sudoku
 *  
 */
public class EcouteurChiffres implements ActionListener {
	
	private JButton[][] buttonSudoku;
	
	
	public EcouteurChiffres(JFrame fenetre, JButton[][] buttonSudoku) {
		super();
		this.buttonSudoku = buttonSudoku;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
	//on récupère le bouton du sudoku sélectionné;
		JButton selected = new JButton();
		for (int i = 0; i < buttonSudoku.length; i++) {
			for (int j = 0; j < buttonSudoku.length; j++) {
				if (buttonSudoku[i][j].getBackground().getRGB() == Color.GRAY.getRGB()){
					 selected = buttonSudoku[i][j];
				}
			}
			
		}
		// on met à jour la valeur du bouton sélectionné
		JButton b = (JButton)e.getSource(); // le bouton sur lequel on a cliqué
		switch(Integer.parseInt(b.getText())){
		case 1:
			selected.setText("1");
			break;
			
		case 2: 
			selected.setText("2");
			break;
			
		case 3: 
			selected.setText("3");
			break;
			
		case 4: 
			selected.setText("4");
			break;
			
		case 5: 
			selected.setText("5");
			break;
			
		case 6: 
			selected.setText("6");
			break;
			
		case 7: 
			selected.setText("7");
			break;
			
		case 8: 
			selected.setText("8");
			break;
			
		case 9: 
			selected.setText("9");
			break;
			
		default:
			break;
		}
	

	}

}
