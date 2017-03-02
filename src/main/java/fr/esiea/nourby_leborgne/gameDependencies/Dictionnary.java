package fr.esiea.nourby_leborgne.gameDependencies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Dictionnary {
		private HashSet<String> dico;
		
		public Dictionnary(){
			this.dico = new HashSet<String>();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("nourby_leborgne/ressources/dico.txt"), "UTF-8")))
		    {
				String line;
				while((line = br.readLine()) != null){
					this.dico.add(this.simplify(line));
				}//fin while
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		public Dictionnary(String s){
			this.dico = new HashSet<String>();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(s), "UTF-8")))
		    {
				String line;
				while((line = br.readLine()) != null){
					this.dico.add(line);
				}//fin while
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		public String simplify(String input){//fonction qui sert à simplifier les lettres: é->e etc...
			input = input.replace('é', 'e');
	        input = input.replace('è', 'e');
	        input = input.replace('ê', 'e');
	        input = input.replace('ë', 'e');
	        input = input.replace('î', 'i');
	        input = input.replace('û', 'u');
	        input = input.replace('ï', 'i');
	        input = input.replace('â', 'a');
	        input = input.replace('ö', 'o');
	        input = input.replace('ç', 'c');
	        input = input.replace('ô', 'o');
	        input = input.replace('ç', 'c');
	        input = input.replace('ü', 'u');
	        input = input.replace('à', 'a');

	        return input;
		}
		
		public boolean contains(String s){
			return this.dico.contains(s);
		}
		
		public void displayDico(){
			for(String word : this.dico){
				System.out.println(word);
			}
		}
	}

