package imagemap.util.action;

import imagemap.graphics.*;

import java.util.Vector;

/**
 * @author Niklas Miroll
 * @author Jean Henrique Ferreira
 * @author Felipe Gusmão
 */
public class WipeStackAction implements AbstractStackAction {
	private Vector<AbstractShape> wipedShapeList = new Vector<AbstractShape>();
	protected int actionType;
	protected String undoDescription;
	protected String redoDescription;
	/**
	 * constructor
	 * 
	 * @param wipedShapeList
	 */
	public WipeStackAction(Vector<AbstractShape> wipedShapeList) {
		actionType = WIPE;
		undoDescription = "Recover all Shapes.";
		redoDescription = "Re-wipe entire Shapes.";
		for (AbstractShape shape : wipedShapeList) {
			this.wipedShapeList.add(shape.clone());
		}
	}
	
	/**
	 * @return the wipedShapeList
	 */
	public Vector<AbstractShape> getWipedShapeList() {
		return wipedShapeList;
	}

	/**
	 * @see imagemap.util.action.AbstractStackAction#specificString()
	 */
	@Override
	public String specificString() {
		return null;
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
}
