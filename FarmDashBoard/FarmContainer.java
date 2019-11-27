package FarmDashBoard;

import java.util.ArrayList;
import java.util.List;

import VisitorPattern.FarmVisitor;

public class FarmContainer extends Node {
    private List<Node> FarmList;

    @Override
    public void FarmInitialize(final String FarmComponentName, final double FarmComponentPrice) {
        super.setName(FarmComponentName);
        super.setPrice(FarmComponentPrice);
        super.setType("FarmContainer");
     
        FarmList = new ArrayList<>();
    }


    @Override
    public void ChangeNameLog(final String FarmComponentName) {
        this.setName(FarmComponentName);
    }

    @Override
    public void ChangePriceLog(final double FarmComponentPrice) {
        this.setPrice(FarmComponentPrice);
    }

    
    @Override
    public double accept(final FarmVisitor handler){
        return handler.visit(this);
    }

    public List<Node> getFarmList() {
        return FarmList;
    }

    public void setItemList(final List<Node> FarmList) {
        this.FarmList = FarmList;
    }
}
