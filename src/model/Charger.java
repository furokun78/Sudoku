package model;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *  Classe permettant de charger un
 *  Sudoku a partir d'un fichier .txt
 */
public class Charger {
	
	private int[][] tab; 
	private JFrame fenetre;
	
	public void charger(String nomfic, JFrame f){
		this.fenetre = f;
		tab = new int[9][9];
		BufferedReader entree;
		boolean continuer = true;

		try {
			entree = new BufferedReader(new InputStreamReader(new FileInputStream(nomfic)));
			do {
			
			for (int i = 0; i < 9; i++){
				String ligne = entree.readLine();
				if(ligne == null){
					continuer = false;
					break;
				}
				int j = 0,plop = 0;
				while(plop < 17)
					if(ligne.charAt(plop) == ' ')plop++;
					else{
						tab[i][j] = Integer.parseInt(ligne.charAt(plop)+"");
						j++;
						plop++;
					}
			}
			//mieux.affichage();
			} while (continuer);
			entree.close();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this.fenetre, "Fichier inexistant !", "Erreur de chargement", 1);
		} catch (IOException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this.fenetre, "Fichier incompatible !", "Erreur de chargement", 1);
		}
	}

	
	// fonction de chargement pour fichier sans les espaces !!!!
	/*public void charger(String nomfic){
			tab = new int[9][9];
			BufferedReader entree;
try {
	entree = new BufferedReader (new FileReader(nomfic));
	boolean eof = false;
	do {
	String ligne1 = entree.readLine();
	if (ligne1 != null){
		for (int i=0; i<=8; i++){
			tab[0][i] = Integer.parseInt(ligne1.charAt(i)+"");
		}
	}
	String ligne2 = entree.readLine();
	if (ligne2 != null){
		for (int i=0; i<=8; i++){
			tab[1][i] = Integer.parseInt(ligne2.charAt(i)+"");
		}
	}
	String ligne3 = entree.readLine();
	if (ligne3 != null){
		for (int i=0; i<=8; i++){
			tab[2][i] = Integer.parseInt(ligne3.charAt(i)+"");
		}
	}
	String ligne4 = entree.readLine();
	if (ligne4 != null){
		for (int i=0; i<=8; i++){
			tab[3][i] = Integer.parseInt(ligne4.charAt(i)+"");
		}
	}
	String ligne5 = entree.readLine();
	if (ligne5 != null){
		for (int i=0; i<=8; i++){
			tab[4][i] = Integer.parseInt(ligne5.charAt(i)+"");
		}
	}
	String ligne6 = entree.readLine();
	if (ligne6 != null){
		for (int i=0; i<=8; i++){
			tab[5][i] = Integer.parseInt(ligne6.charAt(i)+"");
		}
	}
	String ligne7 = entree.readLine();
	if (ligne7 != null){
		for (int i=0; i<=8; i++){
			tab[6][i] = Integer.parseInt(ligne7.charAt(i)+"");
		}
	}
	String ligne8 = entree.readLine();
	if (ligne8 != null){
		for (int i=0; i<=8; i++){
			tab[7][i] = Integer.parseInt(ligne8.charAt(i)+"");
		}
	}
	String ligne9 = entree.readLine();
	if (ligne9 != null){
		for (int i=0; i<=8; i++){
			tab[8][i] = Integer.parseInt(ligne9.charAt(i)+"");
		}
	}
	// traitement du tableau sudoku à insérer ici!!!!!!!!
	} while (entree.readLine() != null);
	entree.close();
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
}*/

	
	public int[][] getTab() {
		return tab;
	}


	public void setTab(int[][] tab) {
		this.tab = tab;
	}


	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < tab.length; i++) {
			for (int k = 0; k < tab.length; k++) {
				buf.append(tab [i][k]);
				if (k == 8){
					buf.append("\n");
				}
			}
		}
		String s = buf.toString();
		return s;
	}
	
	
	
	
	
	
}