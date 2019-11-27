package FarmDashBoard;

import VisitorPattern.FarmVisitor;

public class FarmItem extends Node {

    public void FarmInitialize(final String FarmComponentName, final double FarmComponentPrice){
        super.setName(FarmComponentName);
        super.setPrice(FarmComponentPrice);
        super.setType("FarmItem");
      
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

}
