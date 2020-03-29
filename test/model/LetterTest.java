package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LetterTest {
	
	Letter a;
	
	public void setup1() {
		a = new Letter('A');
	}
	
	public void setup2() {
		setup1();
		Letter b = new Letter('B');
		a.setNextLetter(b);
		b.setBackLetter(a);
	}
	
	public void setup3() {
		setup2();
		Letter z = new Letter('Z');
		a.setBackLetter(z);
		z.setNextLetter(a);
	}
	
	@Test
	public void testLetter1() {
		setup1();
		assertEquals(a.getC(),'A');
	}
	
	@Test
	public void testLetter2() {
		setup2();
		assertEquals(a.getNextLetter().getC(),'B');
		Letter b = a.getNextLetter();
		assertEquals(b.getBackLetter().getC(),'A');
	}
	
	@Test
	public void testLetter3() {
		setup3();
		assertEquals(a.getBackLetter().getC(),'Z');
		Letter z = a.getBackLetter();
		assertEquals(z.getNextLetter().getC(),'A');
		
	}

}
