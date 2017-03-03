package fr.esiea.nourby_leborgne.gameEngine;

import java.util.Arrays;
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

	public Engine(int nP, int dif, Dictionnary dictionnary) {// initialization of game variables
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

	
	public LinkedList<Character> charArrayToList(char[] charArray) {
		LinkedList<Character> charList = new LinkedList<Character>();
		for (int i = 0; i < charArray.length; i++) {
			charList.add(charArray[i]);
		}
		return charList;
	}

	public boolean isValid(String s, Player p) {// vérifie si le mot est valide
		LinkedList<Character> sList;
		LinkedList<Character> sListSave = charArrayToList(s.toCharArray());
		sList = sListSave;
		int matchIndex = 0;
		boolean anagram = false;
		for (int j = 0; j < p.getListSize(); j++) {
			sList = sListSave;
			char[] wordTestCharArray = p.getWord(j).toCharArray();
			LinkedList<Character> wordTestList = charArrayToList(wordTestCharArray);
			for (int k = 0; k < sListSave.size(); k++) {
				if (wordTestList.contains(sListSave.get(k))) {
					wordTestList.remove(sListSave.get(k));
					sList.remove(sListSave.get(k));
				}
			}
			if (wordTestList.size() == 0) {
				anagram = true;
				matchIndex = j;
				break;
			}
		}
		for (int i = 0; i < sList.size(); i++) {
			if (!this.commonJar.contains(String.valueOf(sList.get(i)))) {
				return false;
			}
		}
		if (this.wordsMade.isInHistory(s)) {
			return false;
		}
		for (int l = 0; l < sList.size(); l++) {
			commonJar.delLetter(Character.toString(sList.get(l)));
		}
		if (anagram) {
			p.delWord(matchIndex);
		}
		return true;
	}

	public void del(String s, Player p) {// delete a word
											
		p.delWord(s);
	}

	public void add(String s, Player p) {// add a word
											
		p.addWord(s);
		this.commonJar.delLetter(s);
		this.wordsMade.addWord(s);
	}

	public String waitWord() {// Wait for a player to play
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

	public void checkEnd() {// Check if game is finished
							// fin
		for (int i = 0; i < this.nbPlayer; i++) {
			System.out.println(
					this.playerList.get(i).getName() + " a " + this.playerList.get(i).getListSize() + " mots.");
			if (this.playerList.get(i).getListSize() == 10) {
				this.gameEnd = true;
			}
		}
	}

	public void displayPlayers() {// Displays words of each player
		for (int i = 0; i < this.nbPlayer; i++) {
			System.out.println(this.playerList.get(i).getName());
			System.out.println("Words:");
			this.playerList.get(i).showWords();
			System.out.println("");
		}
	}

	public void displayLetters() {// Displays letters in game
		System.out.print("Le pot de lettres contient: ");
		this.commonJar.showLetters();
		System.out.println("\n");
	}

	public void displayEnd() {
		System.out.println("Fin du jeu !");
	}

	public String drawLetter(Player p) {// Drawing function
										
		System.out.println(p.getName() + " est en train de tirer une lettre...");
		this.commonJar.addLetter(this.letterBag.drawLetter());
		System.out.println("Il a tiré " + this.commonJar.getLast());
		return this.commonJar.getLast();
	}

	public int begin() {// Decides who starts
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

	public void tour(Player p) {// Whose turn is it 
		System.out.println("Tour de " + p.getName());
		this.drawLetter(p);
		this.drawLetter(p);
		this.displayPlayers();
		this.displayLetters();
	}


	public int decideWord(String s, Player p, int indexP) {// Word valid or not
															
		if (!dico.notValid(s) && this.isValid(s, p) && dico.contains(s)) {
			this.add(s, p);
			for(int i=0; i<s.length(); i++){
				commonJar.delLetter(Character.toString(s.charAt(i)));
			}
		}
		if (indexP == 0) {
			indexP = 1;
		} else {
			indexP = 0;
		}
		System.out.println("Le mot choisit n'est pas valide ! Au tour de l'autre joueur!");
		return indexP;
	}

	public void gameStart() {// Alternate turns
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
