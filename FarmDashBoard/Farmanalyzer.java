package FarmDashBoard;

public class Farmanalyzer {
    
    public Farmanalyzer(){}

    public Farmanalyzer(final String type){
       
    }

    public Node getInstance(final String type){
        if (type.equals("FarmItem"))
            return new FarmItem();
        else if (type.equals("FarmContainer"))
            return new FarmContainer();

        throw new IllegalArgumentException();
    }
}
