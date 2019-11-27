package ObserverPattern;

import java.util.Map;

import FarmDashBoard.FarmInterface;
import FarmDashBoard.Node;

public class AbstractItemForObserver implements GetObserver {

    private int FarmItemDetails;
    private final Map<String, Object> FarmComponentMap;

    public AbstractItemForObserver(final FarmInterface world){
        FarmItemDetails = 0;
        FarmComponentMap = world.getNodemap();
    }

    public int getFarmItemDetails() {
        return FarmItemDetails;
    }

    public void setItemNumber(final int FarmItemDetails) {
        this.FarmItemDetails = FarmItemDetails;
    }

    @Override
    public void update() {
        FarmItemDetails = 0;
        for( final Object v: FarmComponentMap.values()){
            if(((Node)v).getType().equals("FarmItem")){
                FarmItemDetails++;
            }
        }
        setItemNumber(FarmItemDetails);
    }

}
