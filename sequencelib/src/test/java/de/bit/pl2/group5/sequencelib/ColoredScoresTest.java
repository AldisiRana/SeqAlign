package de.bit.pl2.group5.sequencelib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ColoredScoresTest {

	@Test
	public void checkColoredScores() {
		ColoredScores test = new ColoredScores();
		test.setScore(4);
		assertEquals(test.getScore(),4);
		assertFalse(test.isColored());
		test.setColored(true);
		assertTrue(test.isColored());
	}
}
