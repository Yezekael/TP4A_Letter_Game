package fr.esiea.nourby_leborgne.gameDependencies;

public class Word {
	private String mot;
	private int size;
	
	public Word(String s){
		this.size=s.length();
		this.mot=s;
	}
	
	public String getWord(){
		return this.mot;
	}
	
	public String[] getWordStr(){
		return this.mot.split("(?!^)");
	}
	
	public int getWordSize(){
		return this.size;
	}
}
