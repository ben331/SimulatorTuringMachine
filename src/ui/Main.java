package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.*;

public class Main {
	
	public static String FILE_NAME_INPUT = "data/in_turing.txt";
	public static String FILE_NAME_OUTPUT = "data/my_out_turing.txt";
	
	public static void main(String[] args) {
		
		TuringMachine tm = new TuringMachine();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_INPUT));
			BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME_OUTPUT));
			
			char option;
			char head;
			char letter;
			
			long time = System.currentTimeMillis();			
			String line = br.readLine();
			
			while(line!=null) {
				
				for(int i=0; i<line.length();){

					head = line.charAt(i);
					i++;
					
					option = line.charAt(i);
					i++;
					
					switch(option) {
					
					case '0':
						
						bw.write(tm.showHead(head)+"\n");
						break;
						
					case '1':
						letter = line.charAt(i);
						i++;

						tm.addLetter(head, letter);
						break;
						
					case '2':
						tm.removeLetter(head);
						break;
					}
					
				}
				line = br.readLine();
				tm.restartHeads();
			}
			
			time =System.currentTimeMillis() - time;
			
			System.out.println("Time used: "+time+" ms.");
			
			br.close();
			bw.close();
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}	
	}
}