package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.Fenetre;

import model.Resolution;

/**
 *  Classe permettant de gerer la demande 
 *  d'aide de l'utilisateur. Elle dévoile ainsi
 *  une valeur dans la grille du Sudoku.
 */
public class EcouteurHelp implements ActionListener {

	private JButton[][] buttonSudoku;
	private Fenetre f;
	
	public EcouteurHelp(JButton[][] buttonSudoku, Fenetre f) {
		super();
		this.buttonSudoku = buttonSudoku;
		this.f = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// récupération du tableau actuel
		int[][] tabActu = new int[9][9];
		for (int i = 0; i < buttonSudoku.length; i++) {
			for (int j = 0; j < buttonSudoku.length; j++) {
				tabActu[i][j] = Integer.parseInt(buttonSudoku[i][j].getText());
			}
		}
		boolean dejacorrige = false; // on ne va corriger qu'une seule erreur
		boolean corrigefaute = false;	// on corrige soit une faute soit on donne une valeur
		for (int i = 0; i < tabActu.length; i++) {
			for (int j = 0; j < tabActu.length; j++) {
				
				if ((tabActu[i][j] != Resolution.tableauResolu[i][j]) && (tabActu[i][j] != 0)){
					buttonSudoku[i][j].setForeground(Color.RED); // si la valeur de la case est fausse (et si ce n'est pas un 0) alors on le met en rouge
					corrigefaute = true;
				}
			}
		}
		for (int i = 0; i < tabActu.length; i++) {
			for (int j = 0; j < tabActu.length; j++) {
				// on va modifier le premier zéro qu'on trouve si on n'a pas déjà corrigé des valeurs
				 if (tabActu[i][j] == 0 && !dejacorrige && !corrigefaute){
					buttonSudoku[i][j].setText(Resolution.tableauResolu[i][j]+""); // on modifie à l'écran
					tabActu[i][j] = Resolution.tableauResolu[i][j]; // on modifie dans le modèle (mm si ça sert à rien)
					dejacorrige = true;
					buttonSudoku[i][j].setBackground(Color.YELLOW);

					JOptionPane.showMessageDialog(f, "Ligne :" + (i+1) + "\nColonne" + (j+1), "Case devoilee", 1);
					
					buttonSudoku[i][j].setBackground(null);
				}
			}
		}
		
	}

}
