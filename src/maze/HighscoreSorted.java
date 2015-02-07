package maze;

public class HighscoreSorted extends Highscore {
	
	/*@ public invariant   
      @   (\forall int i; 
      @      (\forall int j; i>=0 && j>=0 && j<=i && i<size; highscores[j].score <= highscores[i].score)); 
      @*/
	
	/** 
	 * creates the high score list with <tt>capacity</tt> slots to be filled
	 * 
	 * @param capacity the maximum number of slots (list entries); the number must be non-negative
	 */
	/*@ public normal_behavior
	  @ requires p_capacity > 0;
	  @ assignable capacity, size, highscores, min;
	  @*/
	public HighscoreSorted(int p_capacity) {
		super(p_capacity);
	}
	
	/** 
	 * returns an index with a maximal score or <tt>-1</tt> if the high score list is empty
	 */
	/*@ public normal_behavior
	  @ requires size > 0;
	  @ ensures (\forall int i; i >= 0 && i < size; \result <= highscores[i].score);
	  @
	  @ also
	  @
	  @ public normal_behavior
	  @ requires size == 0;
	  @ ensures \result == -1;
	  @
	 */
	public int max() {
		if (size == 0) {
			return -1;
		} else {
			return highscores[highscores.length - 1].getScore();
		}
	}
	
	/*@ private normal_behavior 
	  @ requires in != null && at >= 0 && at<in.length;
	  @ ensures in[at] == rec;
	  @ ensures (\forall int i; i>at && i<in.length; in[i] == \old(in[i-1]));
	  @ assignable in[at..in.length];
	  @
	  @ also
	  @
	  @ private exceptional_behavior
	  @ requires in == null;
	  @ signals_only Exception;
	  @ assignable \everything;
	  @
	  @ also
	  @
	  @ private exceptional_behavior
	  @ requires !(at >= 0 && at < in.length);
	  @ signals_only Exception;
	  @ assignable \everything;
	  @
	  @*/
	private void insertAt(/*@ nullable @*/ Record rec, int at, /*@ nullable @*/ Record[] in) {
		if (in == null) {
			throw new NullPointerException();
		} 
		if (at < 0 || at >= in.length) {
			throw new IndexOutOfBoundsException();
		}
		
		int start = in.length - 1;
		
		// in the specification below complete the specification by replacing the placeholders YYY and ZZZ
		// do not forget to uncomment (remove the double slashes)
		// because there is no invariant that says that in is sorted, this loop can not contain this invariant.
		/*@  loop_invariant start >= at && start < in.length;
		  @  assignable in[at+1..in.length-1], start;
		  @  decreases start;
		  @*/
		while (start > at) {
			in[start] = in[start - 1];
			start--;
		}
		
		in[at] = rec;		
	}
	
	/**
	 * ignore; not in this lab
	 */
	public Record add(Record r) {
		throw new RuntimeException("Not in this lab");
	}
	
	
}
