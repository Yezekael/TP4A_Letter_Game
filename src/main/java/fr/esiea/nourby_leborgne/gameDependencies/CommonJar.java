package fr.esiea.nourby_leborgne.gameDependencies;

import java.util.LinkedList;

public class CommonJar {

private LinkedList<String> letterList;
	
	public CommonJar(){
		this.letterList=new LinkedList<String>();
	}
	
	public void addLetter(String s){
		this.letterList.add(s);
	}
	
	public void delLetter(String s){
		this.letterList.remove(s);
	}
	
	public boolean contains(String s){
		return this.letterList.contains(s);
	}
	
	public String getLast(){
		return this.letterList.getLast();
	}
	
	public void showLetters(){
		for(int i=0; i<this.letterList.size() ; i++){
			System.out.print(this.letterList.get(i)+", ");
		}
	}	
}
