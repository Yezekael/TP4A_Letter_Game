package fr.esiea.nourby_leborgne.gameDependencies;

import java.util.LinkedList;
import java.util.Random;

public class LetterBag {
private LinkedList<String> letterList;
	
	
	public LetterBag(){
		this.letterList=new LinkedList<String>();//initialisation de la liste de lettres dans laquelle on va tirer les lettres à jouer
		this.letterList.add("a");
		this.letterList.add("b");
		this.letterList.add("c");
		this.letterList.add("d");
		this.letterList.add("e");
		this.letterList.add("f");
		this.letterList.add("g");
		this.letterList.add("h");
		this.letterList.add("i");
		this.letterList.add("j");
		this.letterList.add("k");
		this.letterList.add("l");
		this.letterList.add("m");
		this.letterList.add("n");
		this.letterList.add("o");
		this.letterList.add("p");
		this.letterList.add("q");
		this.letterList.add("r");
		this.letterList.add("s");
		this.letterList.add("t");
		this.letterList.add("u");
		this.letterList.add("v");
		this.letterList.add("w");
		this.letterList.add("x");
		this.letterList.add("y");
		this.letterList.add("z");
	}
	
	public int getLetterValue(String s){//retourne la valeur 'arbitraire' correspondant à la lettre donnée. ex: a->1 et d->4
		return this.letterList.indexOf(s);
	}

	public String drawLetter(){
		Random rand=new Random();
		return this.letterList.get(rand.nextInt(26));
	}
}