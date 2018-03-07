package factory;

import model.Buckler;
import model.Equipment;
import model.OneHandAxe;
import model.OneHandSword;

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
        }
        return null;
    }
}
