package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import model.Coordonees;

/**
 *  Classe permettant la gestion
 *  des boutons de deplacement.
 */
public class FlechesListener implements MouseListener{
	
	private Coordonees c;
	private JButton[][] b;
	private JButton ha;
	private JButton ga;
	private JButton ba;
	private JButton dr;
	private Color vert = EcouteurNouveau.vert;
	private Color jaune = EcouteurNouveau.jaune;
	private Color orange = EcouteurNouveau.orange;
	private Color rouge = EcouteurNouveau.rouge;
	private Color cyan = EcouteurNouveau.cyan;
	
	public FlechesListener(Coordonees c, JButton[][] b, JButton ha, JButton ga,
			JButton ba, JButton dr) {
		super();
		this.c = c;
		this.b = b;
		this.ha = ha;
		this.ga = ga;
		this.ba = ba;
		this.dr = dr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Coordonees cTmp = new Coordonees(c.getI(), c.getJ());
		
		// On recupere le bouton qui est clicke
			if((JButton)e.getSource() == ha){
				int i = c.getI() - 1;
				if(i >= 0){
					c.setI(i);
				}
				else{
					i = 8;
					c.setI(i);
				}
			}
			else if ((JButton)e.getSource() == ba){
				c.setI((c.getI() + 1)%9);
			}
			else if ((JButton)e.getSource() == ga){
				int j = c.getJ() - 1;
				if(j >= 0){
					c.setJ(j);
				}
				else{
					j = 8;
					c.setJ(j);
				}
			}
			else if ((JButton)e.getSource() == dr){
				c.setJ((c.getJ() + 1)%9);
			}
		
		/*
		 * Ici, nous allons gere les differents cas de coloriage des cases.
		 * 
		 * Selon la couleur de la case selectionne, il faut la colorier
		 * dans une couleur differente.
		 * 
		 * Il ne faut pas non plus oublier de laisser la case precedente
		 * de la couleur qu'elle etait avant notre passage.
		 */
		if(b[c.getI()][c.getJ()].getBackground().getRGB() == vert.getRGB()){
			
			if(b[cTmp.getI()][cTmp.getJ()].getBackground().getRGB() != vert.getRGB()){
				b[cTmp.getI()][cTmp.getJ()].setBackground(null);
				b[cTmp.getI()][cTmp.getJ()].setForeground(null);
			}
			else{
				b[cTmp.getI()][cTmp.getJ()].setBackground(vert);
				b[cTmp.getI()][cTmp.getJ()].setForeground(Color.BLACK);				
			}
			
			b[c.getI()][c.getJ()].setBackground(vert);
			b[c.getI()][c.getJ()].setForeground(Color.WHITE);
		}
		else if(b[c.getI()][c.getJ()].getBackground().getRGB() == jaune.getRGB()){
			
			if(b[cTmp.getI()][cTmp.getJ()].getBackground().getRGB() != jaune.getRGB()){
				b[cTmp.getI()][cTmp.getJ()].setBackground(null);
				b[cTmp.getI()][cTmp.getJ()].setForeground(null);
			}
			else{
				b[cTmp.getI()][cTmp.getJ()].setBackground(jaune);
				b[cTmp.getI()][cTmp.getJ()].setForeground(Color.BLACK);				
			}
			
			b[c.getI()][c.getJ()].setBackground(jaune);
			b[c.getI()][c.getJ()].setForeground(Color.WHITE);
		}
		else if(b[c.getI()][c.getJ()].getBackground().getRGB() == orange.getRGB()){
			
			if(b[cTmp.getI()][cTmp.getJ()].getBackground().getRGB() != orange.getRGB()){
				b[cTmp.getI()][cTmp.getJ()].setBackground(null);
				b[cTmp.getI()][cTmp.getJ()].setForeground(null);
			}
			else{
				b[cTmp.getI()][cTmp.getJ()].setBackground(orange);
				b[cTmp.getI()][cTmp.getJ()].setForeground(Color.BLACK);				
			}
			
			b[c.getI()][c.getJ()].setBackground(orange);
			b[c.getI()][c.getJ()].setForeground(Color.WHITE);
		}
		else if(b[c.getI()][c.getJ()].getBackground().getRGB() == cyan.getRGB()){
			
			if(b[cTmp.getI()][cTmp.getJ()].getBackground().getRGB() != cyan.getRGB()){
				b[cTmp.getI()][cTmp.getJ()].setBackground(null);
				b[cTmp.getI()][cTmp.getJ()].setForeground(null);
			}
			else{
				b[cTmp.getI()][cTmp.getJ()].setBackground(cyan);
				b[cTmp.getI()][cTmp.getJ()].setForeground(Color.BLACK);		
			}
			
			b[c.getI()][c.getJ()].setBackground(cyan);
			b[c.getI()][c.getJ()].setForeground(Color.WHITE);
		}
		else if(b[c.getI()][c.getJ()].getBackground().getRGB() == rouge.getRGB()){
			
			if(b[cTmp.getI()][cTmp.getJ()].getBackground().getRGB() != rouge.getRGB()){
				b[cTmp.getI()][cTmp.getJ()].setBackground(null);
				b[cTmp.getI()][cTmp.getJ()].setForeground(null);
			}
			else{
				b[cTmp.getI()][cTmp.getJ()].setBackground(rouge);
				b[cTmp.getI()][cTmp.getJ()].setForeground(Color.BLACK);				
			}
			
			b[c.getI()][c.getJ()].setBackground(new Color(255,0,0));
			b[c.getI()][c.getJ()].setForeground(Color.WHITE);
		}
		else{
			
			if(b[cTmp.getI()][cTmp.getJ()].getBackground().getRGB() == -8355712){ // Correspond a la couleur des boutons par defaut
				b[cTmp.getI()][cTmp.getJ()].setBackground(null);
				b[cTmp.getI()][cTmp.getJ()].setForeground(null);
			}
			else{
				b[cTmp.getI()][cTmp.getJ()].setBackground(new Color(
						b[cTmp.getI()][cTmp.getJ()].getBackground().getRGB()));
				b[cTmp.getI()][cTmp.getJ()].setForeground(null);
			}
			
			b[c.getI()][c.getJ()].setBackground(Color.GRAY);
			b[c.getI()][c.getJ()].setForeground(Color.CYAN);
		}
	}

}












