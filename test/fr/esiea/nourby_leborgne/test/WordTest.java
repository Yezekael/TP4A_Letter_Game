package fr.esiea.nourby_leborgne.test;

import fr.esiea.nourby_leborgne.gameDependencies.CommonJar;
import fr.esiea.nourby_leborgne.gameDependencies.Word;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class WordTest {
	
	@Test
	public void testGetWord() {
		
		
		String s = "awawawawawa";
		Word w = new Word(s);
		int t = s.length();
		assertTrue("Fail", w.getWord().equals(s) & w.getWordSize() == t);
	}
	
	@Test
	public void testGetWordStr()
	{
		Word w = new Word("Nope");
 		String[] m = new String[]{"n","o","p","e"};
		//assertTrue("string []", w.getWordStr().getClass()== String[].class);
		assertTrue("Fail", Arrays.equals(m, w.getWordStr()) & w.getWordSize() == 4);
	}

}

