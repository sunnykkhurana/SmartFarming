package FarmDashBoard;

import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JTree;

public interface FarmInterface {

	Map<String, Map<String, Object>> getLogmap();

	Map<String, Object> getNodemap();

	void setNodemap(Map<String, Object> FarmComponentMap);

	Node getNewnode();

	void setNewnode(Node FarmNode);

	JTree getTreeWorld();

	DefaultListModel<String> getLog();

	void setLog(DefaultListModel<String> log);

}