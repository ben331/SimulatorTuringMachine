package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TuringMachineTest {
	
	public final Letter[] ls = { new Letter('A'),
									  new Letter('B'),
									  new Letter('C'),
									  new Letter('D'),};
	
	private TuringMachine tm;

	public void setup1() {
		tm = new TuringMachine();
	}
	
	public void setup2() {
		setup1();
		tm.setC0(ls[0]);
		tm.setC1(ls[0]);
		tm.setC2(ls[0]);
		tm.setLength(1);
	}
	
	public void setup3() {
		setup2();
		tm.setC2(ls[1]);
		tm.getC0().setNextLetter(tm.getC2());
		tm.getC2().setBackLetter(tm.getC0());
		tm.setLength(2);
	}
	
	public void setup4() {
		setup3();
		tm.setC1(ls[1]);
		tm.setC2(ls[2]);
		tm.getC1().setNextLetter(tm.getC2());
		tm.getC2().setBackLetter(tm.getC1());
		tm.setLength(3);
	}
	
	public void setup5() {
		setup4();
		Letter c = tm.getC2();
		tm.setC2(ls[3]);
		c.setNextLetter(tm.getC2());
		tm.getC2().setBackLetter(c);
		tm.setLength(4);
	}
	
	@Test
	public void testShowLetter1() {
		setup1();
		assertEquals(tm.showHead('0'),'#');
		assertEquals(tm.showHead('1'),'#');
		assertEquals(tm.showHead('2'),'#');
	}
	
	@Test
	public void testShowLetter2() {
		setup3();
		assertEquals(tm.showHead('0'),'A');
		assertEquals(tm.showHead('1'),'B');
		assertEquals(tm.showHead('2'),'C');
	}
	
	@Test
	public void testAddLetter1() {
		setup1();
		tm.addLetter('0', 'A');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'A');
		
		setup1();
		tm.addLetter('1', 'A');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'A');
		
		setup1();
		tm.addLetter('2', 'A');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'A');
	}
	
	@Test
	public void testAddLetter2() {
		setup2();
		tm.addLetter('0', 'B');
		assertEquals(tm.getC0().getC(),'B');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'A');
		
		setup2();
		tm.addLetter('1', 'B');
		assertEquals(tm.getC0().getC(),'B');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'A');
		
		setup2();
		tm.addLetter('2', 'B');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'B');
	}
	
	@Test
	public void testAddLetter3() {
		setup3();
		tm.addLetter('0', 'C');
		assertEquals(tm.getC0().getC(),'C');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'B');
		
		setup3();
		tm.addLetter('1', 'C');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'C');
		assertEquals(tm.getC2().getC(),'B');
		
		setup3();
		tm.addLetter('2', 'C');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'C');
	}
	
	@Test
	public void testAddLetter4() {
		setup4();
		tm.addLetter('0', 'D');
		assertEquals(tm.getC0().getC(),'D');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'C');
		
		setup4();
		tm.addLetter('1', 'D');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'D');
		assertEquals(tm.getC2().getC(),'C');
		
		setup4();
		tm.addLetter('2', 'D');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'D');
	}
	
	@Test
	public void testAddLetter5() {
		setup5();
		tm.addLetter('0', 'E');
		assertEquals(tm.getC0().getC(),'E');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'D');
		
		setup5();
		tm.addLetter('1', 'E');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'E');
		assertEquals(tm.getC2().getC(),'D');
		
		setup5();
		tm.addLetter('2', 'E');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'C');
		assertEquals(tm.getC2().getC(),'E');
	}
	
	@Test
	public void testRemove1() {
		setup1();
		tm.removeLetter('0');
		assertEquals(tm.getC0(),null);
		assertEquals(tm.getC1(),null);
		assertEquals(tm.getC2(),null);
		
		setup1();
		tm.removeLetter('1');
		assertEquals(tm.getC0(),null);
		assertEquals(tm.getC1(),null);
		assertEquals(tm.getC2(),null);
		
		setup1();
		tm.removeLetter('2');
		assertEquals(tm.getC0(),null);
		assertEquals(tm.getC1(),null);
		assertEquals(tm.getC2(),null);
	}
	
	@Test
	public void testRemove2() {
		setup2();
		tm.removeLetter('0');
		assertEquals(tm.getC0(),null);
		assertEquals(tm.getC1(),null);
		assertEquals(tm.getC2(),null);
		
		setup2();
		tm.removeLetter('1');
		assertEquals(tm.getC0(),null);
		assertEquals(tm.getC1(),null);
		assertEquals(tm.getC2(),null);
		
		setup2();
		tm.removeLetter('2');
		assertEquals(tm.getC0(),null);
		assertEquals(tm.getC1(),null);
		assertEquals(tm.getC2(),null);
	}
	
	@Test
	public void testRemove3() {
		setup3();
		tm.removeLetter('0');
		assertEquals(tm.getC0().getC(),'B');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'B');
		
		setup3();
		tm.removeLetter('1');
		assertEquals(tm.getC0().getC(),'B');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'B');
		
		setup3();
		tm.removeLetter('2');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'A');
	}
	
	@Test
	public void testRemove4() {
		setup4();
		tm.removeLetter('0');
		assertEquals(tm.getC0().getC(),'B');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'C');
		
		setup4();
		tm.removeLetter('1');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'C');
		
		setup4();
		tm.removeLetter('2');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'A');
		assertEquals(tm.getC2().getC(),'B');
	}
	
	@Test
	public void testRemove5() {
		setup5();
		tm.removeLetter('0');
		assertEquals(tm.getC0().getC(),'B');
		assertEquals(tm.getC1().getC(),'C');
		assertEquals(tm.getC2().getC(),'D');
		
		setup5();
		tm.removeLetter('1');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'C');
		assertEquals(tm.getC2().getC(),'D');
		
		setup5();
		tm.removeLetter('2');
		assertEquals(tm.getC0().getC(),'A');
		assertEquals(tm.getC1().getC(),'B');
		assertEquals(tm.getC2().getC(),'C');
	}
}
