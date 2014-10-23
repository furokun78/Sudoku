package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Fenetre;

/**
 *  Classe permettant de gerer la sauvegarde d'un Sudoku
 *  que l'utilisateur souhaite reprendre plus tard (fichier .ser)
 *  
 */
public class EcouteurSauver implements ActionListener{
	
	private Fenetre f;

	public EcouteurSauver(Fenetre f) {
		super();
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Fenetre.sauvegarderPartie(f);
	}
	
	
	

}
