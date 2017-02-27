package fr.esiea.nourby_leborgne.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.esiea.nourby_leborgne.gameDependencies.Player;
import fr.esiea.nourby_leborgne.gameDependencies.Word;

public class PlayerTest {

	@Test
	public void testLinkedList()
	{
		String w1 ="ùmakod";
		String w2 ="pefjiejmq";
		//test addWord & getLastWord
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
		p.addWord("salut");
		p.addWord("bonjour hello");
		p.addWord("coucou toi aussi");
		assertTrue("echec de suppression String", p.delWord("coucou"));
		//assertFalse("Fail : déjà supprimé",p.delWord("efeofk"));
		//Word w = new Word("blabla dodo");
		//p.addWord(w);
		//assertTrue("Fail", p.delWord(w));
	}
	
	@Test
	public void testHasword()
	{
		Player p = new Player();
		p.addWord("youhou");
		p.addWord("je");
		p.addWord("suis un pirate");
		Word w = new Word("moi pareil");
		p.addWord(w);
		assertTrue("Fail recherche string",p.hasWord("pirate"));
		assertTrue("Fail recherche word",p.hasWord(w));
		p.delWord(w);
		assertFalse("Fail mot supprimé",p.hasWord(w));
		
}
}
