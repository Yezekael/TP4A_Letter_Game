package test.fr.esiea.nourby_leborgne;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.esiea.nourby_leborgne.gameDependencies.LetterBag;


public class LetterBagTest {

	@Test
	public void testGetLetterValue()
	{
		LetterBag b = new LetterBag();
		Integer a = 4;
		Integer c = b.getLetterValue("e");
		assertTrue("Indentation error", c.equals(a)  );
		
	}

}
