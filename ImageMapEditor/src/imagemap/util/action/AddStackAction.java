package imagemap.util.action;

import imagemap.graphics.*;

/**
 * @author Niklas Miroll
 * @author Jean Henrique Ferreira
 * @author Felipe Gusm�o
 */
public class AddStackAction implements AbstractStackAction {
	private CircleShape editedCircleShape;
	private PolygonShape editedPolygonShape;
	private RectangleShape editedRectangleShape;
	protected int actionType;
	protected String undoDescription;
	protected String redoDescription;

	/**
	 * constructor
	 * 
	 * @param actionType
	 * @param editedShape
	 */
	public AddStackAction(int actionType, AbstractShape editedShape, int formType) {
		this.actionType = actionType;
		switch (formType){
			case AbstractShape.TYPE_CIRC:
				this.editedCircleShape = (CircleShape) editedShape.clone();
			case AbstractShape.TYPE_POLY:
				this.editedPolygonShape = (PolygonShape) editedShape.clone();
			case AbstractShape.TYPE_RECT:
				this.editedRectangleShape = (RectangleShape) editedShape.clone();
		}
		undoDescription = "Remove Shape last added.";
		redoDescription = "Recover removed Shape.";
	}

	/**
	 * @return the editedPolygonShape
	 */
	public PolygonShape getEditedShape() {
		return editedPolygonShape;
	}
	
	/**
	 * @return the editedRectangleShape
	 */
	public RectangleShape getEditedRectangleShape() {
		return editedRectangleShape;
	}
	
	/**
	 * @return the editedCircleShape
	 */
	public CircleShape getEditedCircleShape() {
		return editedCircleShape;
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
