package VisitorPattern;

import FarmDashBoard.FarmContainer;
import FarmDashBoard.FarmItem;

public abstract class FarmVisitor {
    public abstract double visit(FarmItem obj);
    public abstract double visit(FarmContainer obj);
}
