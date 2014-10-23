package controller;

import javax.swing.*;

import model.Resolution;

import java.awt.event.*;

/**
 *  Classe permettant la resolution
 *  du Sudoku en cours.
 */
public class EcouteurResoudre implements ActionListener {
	
	private JButton[][] buttonSudoku;

	public EcouteurResoudre(JFrame fenetre, JButton[][] buttonSudoku) {
		super();
		this.buttonSudoku = buttonSudoku;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Initialisation de la solution");
			// on reaffiche sur le tableau de boutons la solution
		try{
			for (int i = 0; i < Resolution.tableauResolu.length; i++) {
				for (int j = 0; j < Resolution.tableauResolu.length; j++) {
				buttonSudoku[i][j].setText(Resolution.tableauResolu[i][j]+"");
				}
			}
			System.out.println("Solution affichée");
		}catch(NullPointerException npe){
			System.out.println("La grille est vide !");
		}
	}
}
