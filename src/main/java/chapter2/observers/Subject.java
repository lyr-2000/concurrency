package chapter2.observers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czd
 */
public class Subject {
    private List<Observer> observsers = new ArrayList<Observer>();
    private int state;

    public int getState(){
        return this.state;
    }
    public void setState(int state){
        if(this.state == state){
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer){
        observsers.add(observer);
    }
    private void notifyAllObserver(){
        for(Observer o : observsers){
            o.update();
        }
    }
}
