package model;

public class Letter {
	
	//Attributes
	
	private char c;
	
	private Letter nextLetter;
	
	private Letter backLetter;
	
	public Letter getBackLetter() {
		return backLetter;
	}
	public void setBackLetter(Letter backLetter) {
		this.backLetter = backLetter;
	}
	public Letter(char c) {
		this.c = c;
	}
	public char getC() {
		return c;
	}

	public Letter getNextLetter() {
		return nextLetter;
	}
	
	public void setNextLetter(Letter nextLetter) {
		this.nextLetter = nextLetter;
	}
}
