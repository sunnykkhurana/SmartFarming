package ObserverPattern;

import java.util.ArrayList;

public class AbstractObserver implements PinObserver {

    private final ArrayList<GetObserver> getObservers;

    public AbstractObserver(){
        getObservers = new ArrayList<>();
    }


    @Override
    public void Attach(final GetObserver o) {
        getObservers.add(o);
    }

    @Override
    public void Detach(final GetObserver o) {
        final int observerIndex = getObservers.indexOf(o);
        getObservers.remove(observerIndex);
    }

    @Override
    public void notifyObservers() {
        for(final GetObserver o : getObservers){
            o.update();
        }
    }



}
