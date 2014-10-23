package model;

import javax.swing.*;

import model.Verification;

/**
 * Classe permettant la resolution du Sudoku
 */
public class Resolution extends Thread {
	
	private JFrame f;
	private JButton[][] Sudoku;
	public static int[][] tableauResolu;
	
	public Resolution(JButton[][] sudoku, JFrame f) {
		super("Resolution");
		Sudoku = sudoku;
		this.f = f;
		super.start();
	}

	/**
	 * Methode resolvant le Sudoku actif sur la grille
	 */
	@Override
	public void run() {
		int[][] tab = new int[9][9];
		// on récupère les valeurs des boutons dans le tableau
		for (int i = 0; i < Sudoku.length; i++) {
			for (int j = 0; j < Sudoku.length; j++) {
				tab[i][j] = Integer.parseInt(Sudoku[i][j].getText());
			}
		}
		// On résout l'équation
		Verification verif = new Verification(tab);
		verif.estValide(0); // résolution du sudoku par le solveur
		if(!(verif.estValide(0))){
			JOptionPane.showMessageDialog(f, "Sudoku inresolvable !", "Resolution impossible", 1);
		}
		else{
			tableauResolu = verif.getSudoku();
		}
	}
	
	
	

	
}
