package controller;
import javax.swing.*;

import model.Charger;
import model.Resolution;

import java.awt.Color;
import java.awt.event.*;

/**
 *  Classe permettant la gestion des
 *  differents niveaux preenregistres
 */
public class EcouteurNouveau implements ItemListener {

	private JFrame fenetre;
	private JButton[][] buttonSudoku;
	public static final Color vert = new Color(51,204,0);
	public static final Color jaune = new Color(255,204,0);
	public static final Color orange = new Color(255,153,0);
	public static final Color rouge = new Color(255,0,0);
	public static final Color cyan = new Color(0,194,238);

	public EcouteurNouveau(JFrame fenetre, JButton[][] buttonSudoku) {
		super();
		this.fenetre = fenetre;
		this.buttonSudoku = buttonSudoku;
	}

	/**
	 * Methode qui charge le Sudoku selectionne
	 * par l'utilisateur dans ceux proposes
	 * 
	 * @param niveau
	 * 		Le niveau selectionne par le joueur
	 * 		(facile, moyen, difficile, expert)
	 */
	public void sudokuPreCharger(int niveau){
		Charger chrg = new Charger();
		switch(niveau){
		case 0:
			chrg.charger("./grilles_test/facile.txt", fenetre); // chargement des données en mémoire
			int[][] tab = chrg.getTab();
			for (int i = 0; i < tab.length; i++) {	// affichage à l'utilisateur
				for (int j = 0; j < tab.length; j++) {
					buttonSudoku[i][j].setText(tab[i][j]+"");
				}
			}
			casePasModifiable(buttonSudoku,vert);
			break;
			
		case 1:
			chrg.charger("./grilles_test/moyen.txt", fenetre);
			int[][] tab2 = chrg.getTab();
			for (int i = 0; i < tab2.length; i++) {
				for (int j = 0; j < tab2.length; j++) {
					buttonSudoku[i][j].setText(tab2[i][j]+"");
				}
			}
			casePasModifiable(buttonSudoku,jaune);
			break;
			
		case 2:
			chrg.charger("./grilles_test/difficile.txt", fenetre);
			int[][] tab3 = chrg.getTab();
			for (int i = 0; i < tab3.length; i++) {
				for (int j = 0; j < tab3.length; j++) {
					buttonSudoku[i][j].setText(tab3[i][j]+"");
				}
			}
			casePasModifiable(buttonSudoku,orange);
			break;
			
		case 3:
			chrg.charger("./grilles_test/expert.txt", fenetre); 
			int[][] tab4 = chrg.getTab();
			for (int i = 0; i < tab4.length; i++) {
				for (int j = 0; j < tab4.length; j++) {
					buttonSudoku[i][j].setText(tab4[i][j]+"");
				}
			}
			casePasModifiable(buttonSudoku,rouge);
			break;
			
		default:
			break;
		}
	}

	/**
	 * Classe permettant de definir les cases
	 * que le joueur n'aura pas le droit de modifier,
	 * a savoir celles charger lors du choix du niveau.
	 * 
	 * @param buttonSudoku
	 * 		La grille du Sudoku sous forme d'un tableau
	 * @param c
	 * 		La couleur des cases a ne pas modifier
	 */
	public void casePasModifiable(JButton[][] buttonSudoku, Color c){
		
		for (int i = 0; i < buttonSudoku.length; i++) {
			for (int j = 0; j < buttonSudoku.length; j++) {
				buttonSudoku[i][j].setBackground(null);
				if (Integer.parseInt(buttonSudoku[i][j].getText()) != 0){ // les valeurs que l'ont ne peut modifier
					buttonSudoku[i][j].setBackground(c);
					// empécher que le bouton soit modifiable!!!
				}
			}
		}
	}

	/**
	 * Classe permettant de recuperer le choix du joueur
	 * sur le niveau qu'il souhaite charger.
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButtonMenuItem b = (JRadioButtonMenuItem)e.getItem();
		String level = b.getText();
		if (level.compareTo("facile") == 0){
			sudokuPreCharger(0);
		}
		else if (level.compareTo("moyen") == 0){
			sudokuPreCharger(1);
		}
		else if (level.compareTo("difficile") == 0){
			sudokuPreCharger(2);
		}
		else if (level.compareTo("expert") == 0){
			sudokuPreCharger(3);
		}
		
		// On résout le Sudoku directement apres l'avoir charge
		@SuppressWarnings("unused")
		Resolution res = new Resolution(buttonSudoku, fenetre);
		System.out.println("Résolution initiale initiée");
	}

}
