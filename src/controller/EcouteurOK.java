package controller;
import model.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *  Classe permettant de verifier que les
 *  resultats de la grille sont corrects.
 */
public class EcouteurOK implements ActionListener {
	
	private JFrame fenetre;
	private JButton[][] buttonSudoku;

	public EcouteurOK(JFrame fenetre, JButton[][] buttonSudoku) {
		super();
		this.fenetre = fenetre;
		this.buttonSudoku = buttonSudoku;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// On vérifie si le tableau est ok pour toutes les cases
		boolean bool = true;
		boolean rachid = false; // pour savoir si le sudoku résolu était simple
		Color vert = new Color(51,204,0);
		int[][] tab = new int[9][9];
		try{
			for (int i = 0; i < buttonSudoku.length; i++) {
				for (int j = 0; j < buttonSudoku.length; j++) {
					tab[i][j] =  Integer.parseInt(buttonSudoku[i][j].getText());
					if (tab[i][j] != Resolution.tableauResolu[i][j]) bool = false;
					if (buttonSudoku[i][j].getBackground().getRGB() == vert.getRGB()) rachid = true;
				}
			}
		}catch(NullPointerException npe){
			System.out.println("Grille vide !");
			bool = false;
		}
		
		if(bool){
			if(rachid){
				ImageIcon img = new ImageIcon("images/Rachid.png");
				JOptionPane.showMessageDialog(fenetre, "You won... But even Rachid\ncould have done it! ", "You won, like Rachid",
				JOptionPane.INFORMATION_MESSAGE, img);
			}
			else{
				ImageIcon img = new ImageIcon("images/sudoku_done.png");
				JOptionPane.showMessageDialog(fenetre, " You won... Good Game ", "You won",
				JOptionPane.INFORMATION_MESSAGE, img);
			}
			
		}
		else {
			ImageIcon img = new ImageIcon("images/failed.png");
			JOptionPane.showMessageDialog(fenetre, " You failed...Try again ", "You failed",
			JOptionPane.INFORMATION_MESSAGE, img);
		}

	}

}
