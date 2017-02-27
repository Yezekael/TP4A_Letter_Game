package fr.esiea.nourby_leborgne.gameDependencies;

import java.util.LinkedList;

public class Player {
	private LinkedList<Word> wordList;
	private String name;
	
	public Player(){
		this.wordList=new LinkedList<Word>();
	}
	public Player(String s){
		this.name = s;
		this.wordList=new LinkedList<Word>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String s){
		this.name=s;
	}
	
	public int getListSize(){
		return this.wordList.size();
	}
	
	public boolean hasWord(String s){
		for(int i=0; i<this.wordList.size() ; i++){
			if(this.wordList.get(i).getWord().equals(s)==true){
				return true;
			}
		}
		return false;
	}
	
	public void showWords(){
		for(int i=0; i<this.wordList.size() ; i++){
			System.out.print(this.wordList.get(i).getWord()+", ");
		}
	}
	
	public void addWord(String s){
		this.wordList.add(new Word(s));
	}
	
	
	public Word getLastWord(){
		return this.wordList.getLast();
	}
	
	public boolean delWord(Word w){
		if(this.wordList.contains(w)){
			return this.wordList.remove(w);
		}
		else{
			return false;
		}
	}
	
	public boolean delWord(String s){
		for(int i=0; i<this.wordList.size() ; i++){
			if(this.wordList.get(i).getWord().equals(s)){
				this.wordList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void addWord(Word w){
		this.wordList.add(w);
	}
	
	public boolean hasWord(Word w){
		if (this.wordList.contains(w)){
			return true;
		}
		else{
			return false;
		}
	}
}

