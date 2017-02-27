package fr.esiea.nourby_leborgne.gameDependencies;

import java.util.HashSet;

public class WordsMade {
	private HashSet<String> wordsMade;
	
	public WordsMade(){
		this.wordsMade=new HashSet<String>();
	}
	
	public boolean isInHistory(String s){
		return this.wordsMade.contains(s);
	}
	
	public void addWord(String s){
		this.wordsMade.add(s);
	}
}
