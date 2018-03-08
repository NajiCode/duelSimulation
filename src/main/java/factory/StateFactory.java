package factory;

import model.fighters.states.Normal;
import model.fighters.states.State;
import model.fighters.states.Veteran;
import model.fighters.states.Vicious;

public class StateFactory {
    public State create(String type){
        if("Vicious".equals(type)){
            return new Vicious();
        }
        else if("Veteran".equals(type)){
            return new Veteran();
        }else if("Normal".equals(type)){
            return new Normal();
        }
        else {
            return null;
        }

    }
}
