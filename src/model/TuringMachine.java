package model;

public class TuringMachine {
	
	
	private Letter C0;
	private Letter C1;
	private Letter C2;
	
	private int length;

	public TuringMachine() {
		length=0;
	}
	
	public Letter getC0() {
		return C0;
	}

	public Letter getC1() {
		return C1;
	}

	public Letter getC2() {
		return C2;
	}
	
	public void setC0(Letter c0) {
		C0 = c0;
	}

	public void setC1(Letter c1) {
		C1 = c1;
	}

	public void setC2(Letter c2) {
		C2 = c2;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}
	
	public String showHead(char head) {
		char sHead='#';
		
		if(C0!=null){
			switch(head) {
			case '0':
				sHead=C0.getC();
				break;
			case '1':
				sHead=C1.getC();
				break;
			case '2':
				sHead=C2.getC();
				break;
			}
		}
		return sHead+"";
	}
	
	public void addLetter(char head, char c) {
		
		Letter letter = new Letter(c);
		if(C0==null) {
			C0 = letter;
			C1 = letter;
			C2 = letter;
			length++;
		}
		else {
			switch(head) {
			case '0':
				letter.setNextLetter(C0);
				C0.setBackLetter(letter);
				C0 = letter;
				if(length%2==1)
					C1 = C1.getBackLetter();
				length++;
				break;
			case '1':
				if(length%2==0) {
					letter.setNextLetter(C1.getNextLetter());
					C1.getNextLetter().setBackLetter(letter);
					letter.setBackLetter(C1);
					C1.setNextLetter(letter);
				}
				else {
					letter.setNextLetter(C1);
					letter.setBackLetter(C1.getBackLetter());
					if(length!=1) {
						C1.getBackLetter().setNextLetter(letter);
					}
					else {
						C0=letter;
					}
					C1.setBackLetter(letter);
				}
				C1=letter;
				length++;
				break;
			case '2':
				letter.setBackLetter(C2);
				C2.setNextLetter(letter);
				C2 = letter;
				if(length%2==0)
					C1=C1.getNextLetter();
				length++;
				break;
			}
		}
	}
	
	public void restartHeads() {
		C0=null;
		C1=null;
		C2=null;
		length=0;
	}
	
	public void removeLetter(int head) {
		
		if(length!=0) {
			if(length==1) {
				C0=null;
				C1=null;
				C2=null;
				length=0;
			}
			else {
				switch(head) {
				case '0':
					C0.getNextLetter().setBackLetter(null);
					C0=C0.getNextLetter();
					length--;
					if(length%2==1)
						C1=C1.getNextLetter();
					break;
				case '1':
					if(length>2)
						C1.getBackLetter().setNextLetter(C1.getNextLetter());
					else {
						C0=C0.getNextLetter();
					}
					
					C1.getNextLetter().setBackLetter(C1.getBackLetter());
					length--;
					if(length%2 == 0) {
						C1 = C1.getBackLetter();
					}
					else {
						C1 = C1.getNextLetter();
					}
					break;
				case '2':
					C2.getBackLetter().setNextLetter(null);
					C2 = C2.getBackLetter();
					length--;
					if(length%2==0)
						C1=C1.getBackLetter();
					break;
				}
			}
		}
	}
}
