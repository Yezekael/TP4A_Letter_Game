package fr.esiea.nourby_leborgne.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.esiea.nourby_leborgne.gameDependencies.Player;
import fr.esiea.nourby_leborgne.gameDependencies.Word;

public class PlayerTest {

	@Test
	public void testLinkedList()
	{
		String w1 ="bla";
		String w2 ="blabla";
		Player p= new Player();
		p.addWord(w2);
		p.addWord(w1);
		assertTrue("Fail",p.getLastWord().getWord().equals(w1));
		assertFalse("Fail",p.getLastWord().getWord().equals(w2));
	}
	
	@Test
	public void testDelWord()
	{
		Player p = new Player();
		p.addWord("blabla");
		assertTrue("echec de suppression String", p.delWord("blabla"));
		assertFalse("Fail : already deleted",p.delWord("blabla"));
		Word w = new Word("blablabla");
		p.addWord(w);
		assertTrue("Fail deletion of Word", p.delWord(w));
	}
	
	@Test
	public void testHasword()
	{Player p = new Player();
	p.addWord("Hello");
	Word w = new Word("Salut");
	p.addWord(w);
	assertTrue("Fail string parsing",p.hasWord("Hello"));
	assertTrue("Fail word parsing",p.hasWord(w));
	p.delWord(w);
	assertFalse("Fail",p.hasWord(w));
	}
	
	public void testListSize()
	{
		Player p = new Player();
		p.addWord("a");
		p.addWord("b");
		p.addWord("c");
		Integer a = p.getListSize();
		Integer b = 3;
		assertTrue("List size error", a.equals(b));
	}
}	
