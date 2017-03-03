package fr.esiea.nourby_leborgne.test;

import fr.esiea.nourby_leborgne.gameDependencies.Word;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class WordTest {
	
	@Test
	public void testGetWord() {
		
		
		String s = "awawawawawa";
		Word w = new Word(s);
		Integer l = 12;
		System.out.println(w.getWord());
		Integer a = w.getWordSize();
		assertTrue("Fail", w.getWord().equals("awawawawawa") & a.equals(l));
	}
		
	
	@Test
	public void testGetWordStr()
	{
		Word w = new Word("salut");
 		String[] m = new String[]{"s","a","l","u","t"};
		assertTrue("string []", w.getWordStr().getClass()== String[].class);
		assertTrue("Fail",Arrays.equals(m, w.getWordStr()) & w.getWordSize() == 5);
	}

}

