package VisitorPattern;

import java.util.List;

import FarmDashBoard.FarmContainer;
import FarmDashBoard.FarmItem;
import FarmDashBoard.Node;

public class FarmCompoentPrice extends FarmVisitor {

    @Override
    public double visit(final FarmItem obj) {
        return obj.getPrice();
    }

    @Override
    public double visit(final FarmContainer obj) {
        final List<Node> itemlist = obj.getFarmList();
        double sum = obj.getPrice();
        for (final Node node : itemlist){
            if (node.getType().equals("FarmItem"))
                sum += node.getPrice();
            else
                sum += visit((FarmContainer) node);
        }

        return sum;
    }
}
