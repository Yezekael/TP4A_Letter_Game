package fr.esiea.nourby_leborgne.gameEngine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {

	private String menu;
	private String rules;
	private String play;
	private String choice;
	private int difficulty;
	private int nbPlayers;
	private Engine engine;
	
	public Start(){//initialization du launcher /////Singleton!!!\\\\\
		this.menu="Bienvenue au Letter Game !\n\nFaites votre choix:\n1.Jouer\n2.Quitter\n\n";
		this.play="1.Jouer contre un ami\n2.Jouer contre l'IA\n\n3.Retour\n\n";
		this.choice="Diffculté de l'ordinateur:\n1.Facile\n2.Normal\n\n3.Retour\n\n";
		this.difficulty=0;
		this.nbPlayers=2;
	}
	
	public void displayMenu(){//affiche le menu et renvoie le choix
		System.out.println(this.menu);	
		int cMenu=0;
		boolean wait=true;
		while(wait==true){
		Scanner sca1 = new Scanner(System.in);
		try{
			cMenu = sca1.nextInt();
			switch(cMenu){
			case 1:
				wait=false;
				this.displayPlay();
				break;
			case 2: 
				wait=false;
				System.exit(0);
				break;
			default:
				System.out.println("Vous devez saisir un chiffre entre 1 et 2 compris pour choisir\n");
			}//fn switch
		}//fin try
		catch (InputMismatchException e){
			System.out.println("Vous devez saisir un chiffre entre 1 et 2 compris pour choisir\n");
		}
		}//fin while
	}

	
	public void displayPlay(){//affiche l'écran de sélection du type de jeu et renvoie le choix
		System.out.println(this.play);
		int cPlay=0;
		boolean wait=true;
		while(wait==true){
		Scanner sca3 = new Scanner(System.in);
		try{
			cPlay = sca3.nextInt();
			switch(cPlay){
			case 1:
				wait=false;
				//startGame
				this.engine=new Engine(this.nbPlayers, this.difficulty, null);
				this.engine.gameStart();
				this.displayMenu();
				break;
			case 2:
				wait=false;
				this.displayChoice();
				break;
			case 3:
				wait=false;
				this.displayMenu();
				break;
			default:
				System.out.println("Vous devez saisir un chiffre entre 1 et 3 pour choisir\n");
			}//fn switch
		}//fin try
		catch (InputMismatchException e){
			System.out.println("Vous devez saisir un chiffre entre 1 et 3 compris pour choisir\n");
		}
		}//fin while
	}
	
	public void displayChoice(){//affiche l'écran de sélection de la difficulté et renvoie le choix
		System.out.println(this.choice);
		int cDif=0;
		boolean wait=true;
		while(wait==true){
		Scanner sca = new Scanner(System.in);
		try{
			cDif = sca.nextInt();
			switch(cDif){
			case 1:
				wait=false;
				this.setDifficulty(1);//NE PAS OUBLIER DE CHANGER
				System.out.println("Not yet implemented !\n");
				this.displayMenu();
				break;
			case 2:
				wait=false;
				this.setDifficulty(2);//NE PAS OUBLIER DE CHANGER
				System.out.println("Not yet implemented !\n");
				this.displayMenu();
				break;
			case 3:
				wait=false;
				this.displayPlay();
				break;
			default:
				System.out.println("Vous devez saisir un chiffre entre 1 et 3 pour choisir\n");
			}//fn switch
		}//fin try
		catch (InputMismatchException e){
			System.out.println("Vous devez saisir un chiffre entre 1 et 3 compris pour choisir\n");
		}
	    finally{
				sca.close();
		}
		}//fin while
	}
	
	public void setDifficulty(int i){
		this.difficulty=i;
	}
	
	public int getDifficulty(){
		return this.difficulty;
	}

	public void setNbPlayers(int i){
		this.nbPlayers=i;
	}
	
	public int getNbPlayers(){
		return this.nbPlayers;
	}
	
	public void launch(){
		this.displayMenu();
	}	
}
