package FarmDashBoard;

public interface ComponentInsert {

	/**
	 * @deprecated Use to prevent broken RT jar file {@link #DashboardItem()} instead
	 */
	void NewScreen();

	void DashboardItem();

	Node getNewnode();

	void setNewnode(Node FarmNode);

}