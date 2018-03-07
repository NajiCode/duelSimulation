package factory;

import model.*;

public class EquipmentFactory {

    public Equipment create(String type){
        if("1handSword".equals(type)){
            return new OneHandSword();
        }
        else if("axe".equals(type)){
            return new OneHandAxe();
        }
        else if("buckler".equals(type)){
            return new Buckler();
        }else if("greatSword".equals(type)){
            return new GreatSword();
        }
        else if("armor".equals(type)){
            return new Armor();
        }

        return null;
    }
}
