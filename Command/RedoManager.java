package Command;

import java.util.Map;

import FarmDashBoard.FarmInterface;

public class RedoManager extends Command {
    private final RedoHandler handler;
    private final String[] LogDetails;
    private final Map<String, Object> UndoDetails;
    private final Map<String, Object> FarmComponentMap;

    public RedoManager(final FarmInterface DashBoard, final String LogDetails){
        UndoDetails = DashBoard.getLogmap().get(LogDetails);
        FarmComponentMap = DashBoard.getNodemap();
        this.LogDetails = LogDetails.split(" ");
        handler = new RedoHandler(UndoDetails, FarmComponentMap, this.LogDetails);
    }

    public void execute(){
        if (excutable())
            handler.RedoLog();
    }

    public boolean excutable(){
        return true;
    }
}
