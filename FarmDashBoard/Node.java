package FarmDashBoard;

import VisitorPattern.FarmVisitorPin;

public abstract class Node implements FarmVisitorPin, Cloneable {
    private String FarmComponentName;
    private String FarmDetailsLog;
    private double FarmComponentPrice;


    public abstract void FarmInitialize(String FarmComponentName, double FarmComponentPrice);
    public abstract void ChangeNameLog(String FarmComponentName);
    public abstract void ChangePriceLog(double FarmComponentPrice);
 

    public String getName() {
        return FarmComponentName;
    }

    public void setName(final String FarmComponentName) {
        this.FarmComponentName = FarmComponentName;
    }

    public double getPrice() {
        return FarmComponentPrice;
    }

    public void setPrice(final double FarmComponentPrice) {
        this.FarmComponentPrice = FarmComponentPrice;
    }

    

    public String getType() {
        return FarmDetailsLog;
    }

    public void setType(final String FarmDetailsLog) {
        this.FarmDetailsLog = FarmDetailsLog;
    }

    public Object clone(){
        Node node = null;

        try {
            node = (Node) super.clone();
        } catch (final CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return node;
    }

}
