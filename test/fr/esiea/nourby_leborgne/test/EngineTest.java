package fr.esiea.nourby_leborgne.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.nourby_leborgne.gameDependencies.CommonJar;
import fr.esiea.nourby_leborgne.gameDependencies.Dictionnary;
import fr.esiea.nourby_leborgne.gameDependencies.Player;
import fr.esiea.nourby_leborgne.gameEngine.Engine;



public class EngineTest {

	

	

		private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		
		
		
		@Before
		public void setUpStreams() throws Exception 
		{
			System.setOut(new PrintStream(outContent));
			System.setErr(new PrintStream(errContent));
		}

		@After
		public void tearDown() throws Exception {
			System.setOut(null);
			System.setErr(null);
		}
		static final Dictionnary dico = new Dictionnary();
		static final Engine ge = new Engine(2,1,dico);
		static final Player p = new Player();
		static final CommonJar cb = new CommonJar();
		
		@Test
		public void testAdd()
		{
			
			cb.addLetter("m");
			cb.addLetter("o");
			cb.addLetter("o");
			cb.addLetter("t");
			ge.add("mot", p);
			p.showWords();
			assertEquals("mot, ", outContent.toString());
			cb.showLetters();
			assertTrue("la supression de lettre dans le pot commun est incorrecte",cb.contains("o"));

		}
	}
