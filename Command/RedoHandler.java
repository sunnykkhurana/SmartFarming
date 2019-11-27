package Command;

import javax.swing.tree.DefaultMutableTreeNode;

import FarmDashBoard.Node;

import java.util.Map;

public class RedoHandler {

    private final Map<String, Object> UndoDetails;
    private final Map<String, Object> FarmComponentMap;
    private final String[] LogDetails;

    public RedoHandler(final Map<String, Object> UndoLogDetails, final Map<String, Object> FarmComponentMap, final String[] LogMSG){
        this.UndoDetails = UndoLogDetails;
        this.LogDetails = LogMSG;
        this.FarmComponentMap = FarmComponentMap;
    }

    public void RedoLog(){
        final Node obj = (Node) UndoDetails.get("obj");
        final DefaultMutableTreeNode treenode  = (DefaultMutableTreeNode) UndoDetails.get("treenode");
        final DefaultMutableTreeNode FarmParentNode = (DefaultMutableTreeNode) UndoDetails.get("FarmParentNode");
        if (LogDetails[0].equals("Add")) {
            FarmComponentMap.put(obj.getName(), obj);
            FarmParentNode.add(new DefaultMutableTreeNode(obj.getName()));
        }
        else if (LogDetails[0].equals("Del")){
            FarmComponentMap.remove(obj.getName());
            treenode.removeFromParent();
        }
        else{
            treenode.setUserObject(obj.getName());
            UndoDetails.put("obj", FarmComponentMap.get(obj.getName()));
            FarmComponentMap.put(obj.getName(), obj);
        }
    }
}
