package model;

/**
 * Classe permettant la verification
 * des donnees sur la grille
 */
public class Verification {
	
	private int[][] sudoku;
	
	

	public Verification(int[][] sudoku) {
		super();
		this.sudoku = sudoku;
	}
	
	/**
	 * Classe verifiant si un chiffre
	 * est present ou non dans une ligne
	 * 
	 * @param k
	 * 		Valeur dont on verifie l'absence
	 * @param i
	 * 		Ligne sur laquelle on effectue la verification
	 * @return boolean
	 * 		Presence ou non de k sur i
	 */
	public boolean absentDeLigne (int k, int i) // k, la valeur a testé
	{
	    for (int j=0; j < 9; j++)
	        if (sudoku[i][j] == k)
	            return false;
	    return true;
	}

	/**
	 * Classe verifiant si un chiffre
	 * est present ou non dans une colonne
	 * 
	 * @param k
	 * 		Valeur dont on verifie l'absence
	 * @param j
	 * 		Colonne sur laquelle on effectue la verification
	 * @return boolean
	 * 		Presence ou non de k sur j
	 */
	public boolean absentDeColonne (int k, int j)
	{
	    for (int i=0; i < 9; i++)
	        if (sudoku[i][j] == k)
	            return false;
	    return true;
	}

	/**
	 * Classe verifiant si un chiffre
	 * est present ou non dans un bloc
	 * 
	 * @param k
	 * 		Valeur dont on verifie l'absence
	 * @param i
	 * 		Bloc dans lequelle on effectue la verification
	 * @return boolean
	 * 		Presence ou non de k dans le bloc
	 */
	public boolean absentDeBloc (int k, int i, int j)
	{
	    int _i = i-(i%3), _j = j-(j%3);  // ou encore : _i = 3*(i/3), _j = 3*(j/3);
	    for (i=_i; i < _i+3; i++)
	        for (j=_j; j < _j+3; j++)
	            if (sudoku[i][j] == k)
	                return false;
	    return true;
	}
	
	/**
	 * Classe qui remplace les 0 de la grille par
	 * les bonnes valeurs en testant toutes les
	 * possibilites pour chaque case
	 * 
	 * @param position
	 * 		La valeur servant a parcourir le tableau
	 * @return boolean
	 * 		Vrai si le Sudoku est resolvable, Faux sinon
	 */
	public boolean estValide (int position)
	{
	    if (position == 9*9)
	        return true;

	    int i = position/9, j = position%9;

	    if (sudoku[i][j] != 0)
	        return estValide(position+1);

	    for (int k=1; k <= 9; k++)
	    {
	        if (absentDeLigne(k,i) && absentDeColonne(k,j) && absentDeBloc(k,i,j))
	        {
	            sudoku[i][j] = k;

	            if ( estValide (position+1) )
	                return true;
	        }
	    }
	    sudoku[i][j] = 0;

	    return false;
	}

	public int[][] getSudoku() {
		return sudoku;
	}

	public void setSudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}
	
	
	
	
	
}
