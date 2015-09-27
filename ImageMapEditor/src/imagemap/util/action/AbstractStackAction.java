package imagemap.util.action;

/**
 * @author Niklas Miroll
 * @author Jean Henrique Ferreira
 * @author Felipe Gusmão
 */
public interface AbstractStackAction {
	public static final int ADD = 0;
	public static final int REMOVE = 1;
	public static final int MOVE = 2;
	public static final int RESIZE = 3;
	public static final int WIPE = 4;
	public static final int SCALE = 5;

	
	// abstract section
	
	/**
	 * 
	 * @return string specific for type of action
	 */
	public String specificString();
	
	// end of abstract methods
	
	/**
	 * @return the actionType
	 */
	public int getActionType();
	
	/**
	 * @return the undoDescription
	 */
	public String getUndoDescription();

	/**
	 * @return the redoDescription
	 */
	public String getRedoDescription();
	
	/**
	 * overridden toString() method for debug purposes
	 */
	@Override
	public String toString();
}
