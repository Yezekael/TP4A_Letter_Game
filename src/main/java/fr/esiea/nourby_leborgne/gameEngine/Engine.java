package fr.esiea.nourby_leborgne.gameEngine;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import fr.esiea.nourby_leborgne.gameDependencies.CommonJar;
import fr.esiea.nourby_leborgne.gameDependencies.LetterBag;
import fr.esiea.nourby_leborgne.gameDependencies.Player;
import fr.esiea.nourby_leborgne.gameDependencies.WordsMade;
import fr.esiea.nourby_leborgne.gameDependencies.Dictionnary;

public class Engine {

	private LinkedList<Player> playerList;
	private LetterBag letterBag;
	private CommonJar commonJar;
	private WordsMade wordsMade;
	private Dictionnary dico;
	private int nbPlayer;
	private boolean gameEnd;

	public Engine(int nP, int dif) {// initialization du jeu
		this.gameEnd = false;
		this.nbPlayer = nP;
		this.wordsMade = new WordsMade();
		this.letterBag = new LetterBag();
		this.commonJar = new CommonJar();
		this.playerList = new LinkedList<Player>();
		this.dico = new Dictionnary();
		for (int i = 1; i <= nP; i++) {
			Player p = new Player("Player " + String.valueOf(i));
			playerList.add(p);
		}
	}

	public Player getPlayer(int i) {
		return this.playerList.get(i);
	}

	public int getNbPlayer() {
		return this.nbPlayer;
	}

	public boolean isValid(String s) {// vérifie si le mot est valide
		for (int i = 0; i < s.length(); i++) {
			if (!this.commonJar.contains(String.valueOf(s.charAt(i)))) {
				return false;
			}
		}
		if (this.wordsMade.isInHistory(s)) {
			return false;
		}
		return true;
	}

	public void del(String s, Player p) {// fonction qui supprime le mot d'un
											// joueur
		p.delWord(s);
	}

	public void add(String s, Player p) {// fonction qui ajoute un mot à un
											// joueur
		p.addWord(s);
		this.commonJar.delLetter(s);
		this.wordsMade.addWord(s);
	}

	public String waitWord() {// attend qu'un mot soit écrit par un joueur
		Scanner sc = new Scanner(System.in);
		String str = " ";
		System.out.println("Veuillez saisir un mot :");
		try {
			// while (sc.hasNextLine()){
			str = sc.nextLine();// }
		} catch (InputMismatchException e) {

		}

		System.out.println("Le mot choisit est: " + str);
		return str;
	}

	public void checkEnd() {// vérifie si un joueur satisfait les conditions de
							// fin
		for (int i = 0; i < this.nbPlayer; i++) {
			System.out.println(
					this.playerList.get(i).getName() + " a " + this.playerList.get(i).getListSize() + " mots.");
			if (this.playerList.get(i).getListSize() == 10) {
				this.gameEnd = true;
			}
		}
	}

	public void displayPlayers() {// affiche chaque joueur et ses mots
		for (int i = 0; i < this.nbPlayer; i++) {
			System.out.println(this.playerList.get(i).getName());
			System.out.println("Words:");
			this.playerList.get(i).showWords();
			System.out.println("");
		}
	}

	public void displayLetters() {// affiches les lettres du pot commun
		System.out.print("Le pot de lettres contient: ");
		this.commonJar.showLetters();
		System.out.println("\n");
	}

	public void displayEnd() {// écran de fin
		System.out.println("Fin du jeu !");
	}

	public String drawLetter(Player p) {// fonction qui tire une lettre par
										// joueur
		System.out.println(p.getName() + " est en train de tirer une lettre...");
		this.commonJar.addLetter(this.letterBag.drawLetter());
		System.out.println("Il a tiré " + this.commonJar.getLast());
		return this.commonJar.getLast();
	}

	public int begin() {// choisit quel joueur commence
		int indexP = 0;
		int val;
		val = this.letterBag.getLetterValue(this.drawLetter(this.playerList.get(indexP)));
		for (int i = 1; i < this.nbPlayer; i++) {
			int tmp = this.letterBag.getLetterValue(this.drawLetter(this.playerList.get(i)));
			if (this.letterBag.getLetterValue(this.commonJar.getLast()) < val) {
				val = tmp;
				indexP = i;
			}
		}
		System.out.println("Le joueur qui commence est: " + this.playerList.get(indexP).getName());
		return indexP;
	}

	public void tour(Player p) {// fonction qui gère les tours
		System.out.println("Tour de " + p.getName());
		this.drawLetter(p);
		this.drawLetter(p);
		this.displayPlayers();
		this.displayLetters();
	}

	public int decideWord(String s, Player p, int indexP) {// fonction qui
															// décide quoi faire
		if (!dico.notValid(s) && this.isValid(s) && dico.contains(s)) {
			this.add(s, p);
			for(int i=0; i<s.length(); i++){
				commonJar.delLetter(Character.toString(s.charAt(i)));
			}
			return indexP;
		}
		if (indexP == 0) {
			indexP = 1;
		} else {
			indexP = 0;
		}
		System.out.println("Le mot choisit n'est pas valide ! Au tour de l'autre joueur!");
		return indexP;
	}

	public void gameStart() {// fonction qui gère les tours de jeu
		this.gameEnd = false;
		int indexCurrentPlayer = this.begin();
		Player currentPlayer = this.playerList.get(indexCurrentPlayer);
		String word = "";
		do {
			this.tour(currentPlayer);
			word = this.waitWord();
			indexCurrentPlayer = decideWord(word, currentPlayer, indexCurrentPlayer);
			currentPlayer = this.playerList.get(indexCurrentPlayer);
			this.checkEnd();
		} while (this.gameEnd != true);
		this.displayEnd();
	}
}
