package controller;

import java.awt.event.*;
import javax.swing.*;

import model.Charger;
import model.Resolution;
	
	/**
	 *  Classe permettant de gerer la demande 
	 *  et le chargement d'un Sudoku (fichier .txt)
	 *  à l'aide de la classe Charger
	 *  
	 *  @see model.Charger
	 */
public class EcouteurCharger extends JPanel implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JFrame fenetre;
	private JButton[][] buttonSudoku;
	public static int[][] tableauResolu;
	
	public EcouteurCharger(JFrame fenetre, JButton[][] buttonSudoku) {
		super();
		this.fenetre = fenetre;
		this.buttonSudoku = buttonSudoku;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String fichier = JOptionPane.showInputDialog(fenetre, "Veuillez joindre votre fichier", "Chargement d'un Sudoku",
		JOptionPane.QUESTION_MESSAGE);
		try{
			Charger charg = new Charger();
			charg.charger(fichier, fenetre);
			// affichage sur la fenêtre 
			int[][] tab = charg.getTab();
			for (int i = 0; i < tab.length; i++) {
				for (int j = 0; j < tab.length; j++) {
					buttonSudoku[i][j].setBackground(null);
					buttonSudoku[i][j].setForeground(null);
					buttonSudoku[i][j].setText(tab[i][j]+"");
					if(tab[i][j] != 0){
						buttonSudoku[i][j].setBackground(EcouteurNouveau.cyan);
					}
				}
			}
			// on résout le Sudoku directement
			@SuppressWarnings("unused")
			Resolution res = new Resolution(buttonSudoku, fenetre);
		}catch(NullPointerException npe){
			JOptionPane.showMessageDialog(this.fenetre, "Fichier inexistant !", "Erreur de chargement", 1);
		}
	}


}

