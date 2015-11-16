package imagemap.util.action;

/**
 * @author Niklas Miroll
 * @author Jean Henrique Ferreira
 * @author Felipe Gusmão
 */
public class ScaleStackAction implements AbstractStackAction {
	private float scaleFactor;
	protected int actionType;
	protected String undoDescription;
	protected String redoDescription;
	/**
	 * constructor
	 * 
	 * @param scale
	 */
	public ScaleStackAction(float scale) {
		actionType = SCALE;
		undoDescription = "Scale back to previous state.";
		redoDescription = "Redo scaling.";
		this.scaleFactor = 0 + scale;
	}

	/**
	 * 
	 * @return the scaleFactor
	 */
	public float getScaleFactor() {
		return scaleFactor;
	}

	/**
	 * @return the actionType
	 */
	public int getActionType() {
		return actionType;
	}
	
	/**
	 * @return the undoDescription
	 */
	public String getUndoDescription() {
		return undoDescription;
	}

	/**
	 * @return the redoDescription
	 */
	public String getRedoDescription() {
		return redoDescription;
	}
	
	/**
	 * overridden toString() method for debug purposes
	 */
	@Override
	public String toString() {
		String out = "[Type of Action: " + actionType + "; "
				+ specificString() + "]";
		return out;
	}

	@Override
	public String specificString() {
		// TODO Auto-generated method stub
		return null;
	}
}
