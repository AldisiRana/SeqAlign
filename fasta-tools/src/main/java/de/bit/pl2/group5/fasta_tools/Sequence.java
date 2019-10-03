package de.bit.pl2.group5.fasta_tools;
/**
 * A class that return a single protein sequences by building the header ,body,length using get and set functions
 * 
 * @author Rana Aldisi
 * @version 1.0
 *
 */

public class Sequence {
	private String header;
	private String body;
	private int seq_length;
	/**
	 * A method to get the header
	 * 
	 * @return string containing the header
	 */

	public String getHeader() {
		return header;
	}
	/**
	 * A method to set the header
	 * 
	 * @param string to set the header
	 */

	public void setHeader(String header) {
		this.header = header;
	}
	/**
	 * A method returning the sequence as a string
	 * 
	 * @return string containing the sequence
	 */
	 
	public String getSequence() {
		return body;
	}
	/**
	 * A method to set the sequence
	 * 
	 * @param string which contains the sequence
	 */
	 
	public void setSequence(String body) {
		this.body=body;
	}
	/**
	 * A method to return the length of the sequence
	 * 
	 * @return the length of the sequence
	 */

	public int getSeqLength() {
		return seq_length;
	}
	
	/**
	 * A method to set the sequence length
	 * 
	 * @param integer representing the sequence length
	 */
	public void setSeqLength(int seq_length) {
		this.seq_length=seq_length;
	}
}
