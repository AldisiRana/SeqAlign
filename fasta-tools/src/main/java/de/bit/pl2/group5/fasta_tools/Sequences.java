package de.bit.pl2.group5.fasta_tools;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * a Class that build an arraylist of sequences that are extracted from a fasta file
 * 
 * @author Rana Aldisi
 * @version 1.0
 *
 */

public class Sequences {
	private ArrayList<Sequence> sequences;
	private Scanner sc;
	/**
	 * A method to get all sequences
	 * 
	 * @return array list containing all sequences
	 */


	public ArrayList<Sequence> getSequences(){
		return sequences;
	}
	/**
	 * A method to set the sequences of the fasta
	 * 
	 * @param a file containing the fasta
	 * @throws IOException
	 */
	 
	public void setSequences(File fasta) throws IOException {
		this.sequences = readFasta(fasta);
	}
	/**
	 * A method to read the fasta from a file
	 * 
	 * @param a file containing the fasta
	 * @return
	 * @throws IOException
	 */
	 
	public ArrayList<Sequence> readFasta(File fasta) throws IOException{
		sc = new Scanner(fasta);
		String firstLine = sc.nextLine();
		if (!firstLine.startsWith(">")) {
			throw new IOException("The sequences need to be in fasta format");
		}
		ArrayList<Sequence> sequences= new ArrayList<Sequence>();
		String s= "";
		Sequence seq = new Sequence();
		seq.setHeader(firstLine);
		while (sc.hasNext()) {
			String line = sc.nextLine().trim();
			if(line.startsWith(">"))
			{
				seq.setSequence(s);
				seq.setSeqLength(s.length());
				sequences.add(seq);
				s="";
				seq = new Sequence();
				seq.setHeader(line);
			}
			
			else
			{	
				s += line; 
			}
		
		}
		seq.setSequence(s);
		seq.setSeqLength(s.length());
		sequences.add(seq);
		sc.close();
		return sequences;
	}

}
