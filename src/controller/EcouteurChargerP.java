package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Fenetre;

/**
 *  Classe permettant de gerer le chargement d'un Sudoku
 *  que l'utilisateur avait sauvegarder (fichier .ser)
 *  
 */
public class EcouteurChargerP implements ActionListener{
	
	private Fenetre f;

	public EcouteurChargerP(Fenetre f) {
		super();
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Fenetre.chargerPartie(f);
		f.repaint();
	}
	
	
	

}
