package imagemap.util.action;

import imagemap.graphics.AbstractShape;
import imagemap.graphics.CircleShape;
import imagemap.graphics.RectangleShape;

/**
 * @author Niklas Miroll
 * @author Jean Henrique Ferreira
 * @author Felipe Gusm�o
 */
public class MoveStackAction implements AbstractStackAction {
	private AbstractShape editedShape;
	private AbstractShape originalShape;
	protected int actionType;
	protected String undoDescription;
	protected String redoDescription;

	/**
	 * constructor
	 * 
	 * @param actionType
	 * @param start
	 * @param end
	 */
	public MoveStackAction(int actionType, AbstractShape start, AbstractShape end) {
		this.actionType = actionType;
		originalShape = start.clone();
		editedShape = end.clone();
		undoDescription = "Move edited Shape to original position.";
		redoDescription = "Move Shape back to edited position.";
	}

	/**
	 * @return the editedShape
	 */
	public AbstractShape getEditedShape() {
		switch(editedShape.getType()){
			case AbstractShape.TYPE_RECT:
				return returnRectangleEditedShape();
			case AbstractShape.TYPE_CIRC:
				return returnCircleEditedShape();
		}
		return editedShape;
	}

	public RectangleShape returnRectangleEditedShape() {
		return (RectangleShape) editedShape;
	}

	public CircleShape returnCircleEditedShape() {
		return (CircleShape) editedShape;
	}

	/**
	 * @return the originalShape
	 */
	public AbstractShape getOriginalShape() {
		return originalShape;
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
		String out = "[Type of Action: " + actionType + "; " + specificString() + "]";
		return out;
	}

}
