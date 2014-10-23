package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.*;

import model.Coordonees;
import model.EcouteurDel;
import model.Resolution;

import controller.*;

import controller.EcouteurCharger;
import controller.EcouteurChiffres;
import controller.EcouteurHelp;
import controller.EcouteurNouveau;
import controller.EcouteurResoudre;
import controller.FlechesListener;
	 
/**
 * Classe definissant la fenettre principale complete du logiciel
 *
 */
public class Fenetre extends JFrame implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panHaut;
	private JButton[][] buttonSudoku;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mfic = new JMenu("Fichier");
	private JMenu medit = new JMenu("Edition");
	private JMenuItem isauv = new JMenuItem("Sauvegarder la partie");
	private JMenuItem ichargP = new JMenuItem("Charger une partie");
	private JMenuItem icharg = new JMenuItem("Charger un fichier");
	private JMenuItem iclose = new JMenuItem("Fermer");
	private JMenu mnew = new JMenu("Nouveau");
	private JMenuItem ires = new JMenuItem("Rédsoudre");
	private JMenuItem ihelp = new JMenuItem("Help");
	private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("facile");
	private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("moyen");
	private JRadioButtonMenuItem jrmi3 = new JRadioButtonMenuItem("difficile");
	private JRadioButtonMenuItem jrmi4 = new JRadioButtonMenuItem("expert");
   
	public Fenetre(){

	         this.setTitle("Sudoku");
	         this.setSize(480, 640);
	         this.setLocationRelativeTo(null);
	         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         this.setResizable(false);	        
	         this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	         
	         // Panel Haut

		         panHaut = new JPanel();
		         panHaut.setSize(360, 360);
		         panHaut.setLayout(new GridLayout(3, 3));
		         
		         JPanel[] panH = {new JPanel(), new JPanel(), new JPanel(),
     		 			new JPanel(), new JPanel(), new JPanel(),
     		 			new JPanel(), new JPanel(), new JPanel()};
      
		         buttonSudoku = new JButton[9][9]; // Les boutons de la grilles du Sudoku
		         for(int i = 0; i < 9; i++){
		        	 for(int j = 0; j < 9; j++){
		        		 buttonSudoku[i][j] = new JButton("0");
		        		 buttonSudoku[i][j].setPreferredSize(new Dimension(40,40));
		        	 }
		         }
		         
		         Coordonees c = new Coordonees(4,4);
		         buttonSudoku[c.getI()][c.getI()].setBackground(Color.GRAY);
		         buttonSudoku[c.getI()][c.getI()].setForeground(Color.CYAN);
		 
		         for(int k = 0; k < 9; k++){
		        	 panH[k].setLayout(new GridLayout(3,3));
		         }
	        	 for(int i = 0; i < 9; i++){
	        		 for(int j = 0; j < 9; j++){
	        			 panH[getBlock(i,j)].add(buttonSudoku[i][j]);
	        		 }
	        	 }
		         for(int k = 0; k < 9; k++){
		        	 panH[k].setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		        	 panHaut.add(panH[k]);
		         }
		         panHaut.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Sudoku"));
		         
		         
      
	         // Panel Bas
		         JPanel panBas = new JPanel();
		         panBas.setLayout(new GridLayout(1, 2));
		         
		         // Panel bas gauche (chiffres)
			         JPanel panBasG = new JPanel();
			         panBasG.setLayout(new BoxLayout(panBasG, BoxLayout.PAGE_AXIS));
			         
			         JPanel panChiffres1 = new JPanel();
			         JPanel panChiffres2 = new JPanel();
			         JPanel panChiffres3 = new JPanel();
			         
			         panChiffres1.setLayout(new BoxLayout(panChiffres1, BoxLayout.LINE_AXIS));
			         panChiffres2.setLayout(new BoxLayout(panChiffres2, BoxLayout.LINE_AXIS));
			         panChiffres3.setLayout(new BoxLayout(panChiffres3, BoxLayout.LINE_AXIS));
			         
			         JButton[] tabChiffres = new JButton[9];
			         for(int i = 0 ; i < 9 ; i++){
			        	tabChiffres[i] = new JButton(i+1+"");
			        	tabChiffres[i].setPreferredSize(new Dimension(50,30));
			        	tabChiffres[i].addActionListener(new EcouteurChiffres(this,buttonSudoku));
			         }
			         
			         for(int i = 0; i < 3; i++){
			        	 panChiffres1.add(tabChiffres[i]);
			         }
			         
			         for(int i = 3; i < 6; i++){
			        	 panChiffres2.add(tabChiffres[i]);
			         }
			         
			         for(int i = 6; i < 9; i++){
			        	 panChiffres3.add(tabChiffres[i]);
			         }

					panBasG.add(Box.createVerticalGlue());
					panBasG.add(panChiffres1);
					panBasG.add(panChiffres2);
					panBasG.add(panChiffres3);
					panBasG.add(Box.createVerticalGlue());
				
					// Panel bas droit
					JPanel panBasD = new JPanel();
					panBasD.setPreferredSize(new Dimension(210,150));
					panBasD.setLayout(new GridLayout(2, 1));
					
						JPanel panBasDH = new JPanel();
							panBasDH.setLayout(new GridLayout(2, 3));
						JPanel panBasDB = new JPanel();
							panBasDB.setLayout(new BoxLayout(panBasDB, BoxLayout.X_AXIS));

						panBasDH.add(new JPanel());
						
						ImageIcon fh = new ImageIcon("images/fleche haut.png");
						ImageIcon fg = new ImageIcon("images/fleche gauche.png");
						ImageIcon fb = new ImageIcon("images/fleche bas.png");
						ImageIcon fd = new ImageIcon("images/fleche droite.png");
						
						JButton h = new JButton(fh);
						panBasDH.add(h);
						panBasDH.add(new JPanel());

						JButton g = new JButton(fg);
						panBasDH.add(g);
						JButton b = new JButton(fb);
						panBasDH.add(b);
						JButton d = new JButton(fd);
						panBasDH.add(d);
						
						h.addMouseListener(new FlechesListener(c, buttonSudoku, h, g, b, d));
						g.addMouseListener(new FlechesListener(c, buttonSudoku, h, g, b, d));
						b.addMouseListener(new FlechesListener(c, buttonSudoku, h, g, b, d));
						d.addMouseListener(new FlechesListener(c, buttonSudoku, h, g, b, d));
						
						panBasDB.add(Box.createHorizontalGlue());
						JButton del = new JButton("Del");
						panBasDB.add(del);
						del.addActionListener(new EcouteurDel(buttonSudoku));
						JButton ok = new JButton("OK");
						ok.addActionListener(new EcouteurOK(this,buttonSudoku));
						panBasDB.add(ok);
						panBasDB.add(Box.createHorizontalGlue());	

					panBasD.add(panBasDH);
					panBasD.add(panBasDB);
					
				panBas.add(panBasG);
				panBas.add(panBasD);
				
				
				 // Menu
		         isauv.addActionListener(new EcouteurSauver(this));
		         ichargP.addActionListener(new EcouteurChargerP(this));
		         icharg.addActionListener(new EcouteurCharger(this,buttonSudoku));
		         ButtonGroup bg = new ButtonGroup();
		         //Buton groupe pour les choix de niveau de difficulté des grilles pré-chargées
		         bg.add(jrmi1);
		         bg.add(jrmi2);
		         bg.add(jrmi3);
		         bg.add(jrmi4);
		      
		         // ajout des raido buttons dans le sous menu
		         
		         this.mnew.add(jrmi1);
		         this.mnew.add(jrmi2);
		         this.mnew.add(jrmi3);
		         this.mnew.add(jrmi4);
		         jrmi1.addItemListener(new EcouteurNouveau(this,buttonSudoku));
		         jrmi2.addItemListener(new EcouteurNouveau(this,buttonSudoku));
		         jrmi3.addItemListener(new EcouteurNouveau(this,buttonSudoku));
		         jrmi4.addItemListener(new EcouteurNouveau(this,buttonSudoku));
		         ihelp.addActionListener(new EcouteurHelp(buttonSudoku,this));
		         iclose.addActionListener(new ActionListener(){
			         public void actionPerformed(ActionEvent arg0){
			         System.exit(0);
			         }
		         });
		         
		         ires.addActionListener(new EcouteurResoudre(this, buttonSudoku));
		         this.mfic.add(isauv);
		         this.mfic.add(ichargP);
		         this.mfic.add(icharg);
		         this.mfic.add(iclose);
		         this.medit.add(mnew);
		         this.medit.add(ihelp);
		         this.medit.add(ires);
		         //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
		         //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
		         this.menuBar.add(mfic);
		         this.menuBar.add(medit);
		         //-------------------------
		         this.setJMenuBar(menuBar);
			
			this.getContentPane().add(panHaut);
			this.getContentPane().add(panBas);
			
			this.pack();
	        this.setVisible(true);
	 }
	
	/**
	 * Classe permettant de se placer sur l'un
	 * des 9 blocs principaux de la grille de Sudoku
	 * 
	 * @param i
	 * 		Numero de ligne du block
	 * @param j
	 * 		Numero de colonne du block
	 * @return le numero du block
	 */
	public static int getBlock(int i, int j){
		return (3*(int)(i/3) + (int)j/3);		
	}
	
	/**
	 * Classe permettant de sauvegarder la partie actuelle
	 * pour la reprendre plus tard
	 *  
	 * @param f
	 * 		La fenetre du logiciel
	 */
	public static void sauvegarderPartie(Fenetre f){
		try {
			FileOutputStream fichier = new FileOutputStream("Partie.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(f.buttonSudoku);
			oos.flush();
			oos.close();
		}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Classe permettant de charger une partie
	 * sauvegardee au cours d'une cession precedente
	 *  
	 * @param f
	 * 		La fenetre du logiciel
	 */
	public static void chargerPartie(Fenetre f){
		try {
			File fic = new File("Partie.ser");
			if(fic.exists() == true){				
				FileInputStream fichier = new FileInputStream("Partie.ser");
				ObjectInputStream ois = new ObjectInputStream(fichier);
				Object o = ois.readObject();
				JButton[][] bTmp = new JButton[9][9];
				if(o instanceof JButton[][])bTmp = (JButton[][]) o;

				for (int i = 0; i < bTmp.length; i++) {
					for (int j = 0; j < bTmp.length; j++) {
						f.buttonSudoku[i][j].setBackground(null);
						f.buttonSudoku[i][j].setForeground(null);
						f.buttonSudoku[i][j].setText(bTmp[i][j].getText()+"");
						if(Integer.parseInt(bTmp[i][j].getText()) != 0){
							f.buttonSudoku[i][j].setBackground(EcouteurNouveau.cyan);
						}
					}
				}
				// on résout le Sudoku directement
				@SuppressWarnings("unused")
				Resolution res = new Resolution(f.buttonSudoku, f);
			}
		} 
		catch (FileNotFoundException fnfe) {
		}
		catch (ClassNotFoundException cnfe) {
		}
		catch (java.io.IOException e) {
		}
	}
}