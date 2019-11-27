package ObserverPattern;

public interface PinObserver {

    public void Attach(GetObserver o);
    public void Detach(GetObserver o);
    public void notifyObservers();

}
