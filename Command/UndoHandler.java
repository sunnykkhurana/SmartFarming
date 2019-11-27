package Command;


import javax.swing.tree.DefaultMutableTreeNode;

import FarmDashBoard.Node;

import java.util.Map;

public class UndoHandler {

    private final Map<String, Object> UndoLogDetails;
    private final Map<String, Object> FarmComponentMap;
    private final String[] LogDetails;

    public UndoHandler(final Map<String, Object> UndoLogDetails, final Map<String, Object> FarmComponentMap, final String[] LogDetails){
        this.UndoLogDetails = UndoLogDetails;
        this.LogDetails = LogDetails;
        this.FarmComponentMap = FarmComponentMap;
    }

    public void UndoDetails(){
        final Node obj = (Node) UndoLogDetails.get("obj");
        final DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) UndoLogDetails.get("treenode");

        if (LogDetails[0].equals("Add")) {
            FarmComponentMap.remove(obj.getName());
            treenode.removeFromParent();
        }
        else{
            treenode.setUserObject(obj.getName());
            UndoLogDetails.put("obj", FarmComponentMap.get(obj.getName()));
            FarmComponentMap.put(obj.getName(), obj);
        }
    }
}
