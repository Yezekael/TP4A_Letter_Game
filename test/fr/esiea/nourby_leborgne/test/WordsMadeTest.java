package fr.esiea.nourby_leborgne.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.esiea.nourby_leborgne.gameDependencies.WordsMade;

public class WordsMadeTest {

	
	@Test
	public void testWordsMade() {
		WordsMade h = new WordsMade();
		h.addWord("Bonjour");
		assertTrue("Mot écrit mais non trouvé ", h.isInHistory("Bonjour"));



	}

}
