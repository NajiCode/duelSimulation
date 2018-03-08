package factory;

import model.equipments.Equipment;
import model.equipments.defensive.Armor;
import model.equipments.defensive.Buckler;
import model.equipments.offensive.GreatSword;
import model.equipments.offensive.OneHandAxe;
import model.equipments.offensive.OneHandSword;

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
