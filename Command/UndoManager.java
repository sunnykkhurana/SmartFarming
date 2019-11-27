package Command;

import java.util.Map;

import FarmDashBoard.FarmInterface;
import FarmDashBoard.Node;

public class UndoManager extends Command {
    private final UndoHandler handler;
    private final String[] LogMSG;
    private final Map<String, Object> UndoLogDetails;
    private final Map<String, Object> FarmComponentMap;



    public UndoManager(final FarmInterface DashBoard, final String LogDetails){
        UndoLogDetails = DashBoard.getLogmap().get(LogDetails);
        FarmComponentMap = DashBoard.getNodemap();
        this.LogMSG = LogDetails.split(" ");
        handler = new UndoHandler(UndoLogDetails, FarmComponentMap, this.LogMSG);
    }


    public void execute(){
        if (excutable())
            handler.UndoDetails();
    }

    public boolean excutable(){
        final Node obj = (Node) UndoLogDetails.get("obj");
        if (LogMSG[0].equals("Add") && !FarmComponentMap.containsKey(obj.getName()))
            return false;
        else return !LogMSG[0].equals("Del") || !FarmComponentMap.containsKey(obj.getName());
    }
}
