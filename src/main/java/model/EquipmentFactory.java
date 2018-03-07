package model;

public class EquipmentFactory {

    public Equipment create(String type){
        if("1handSword".equals(type)){
            return new OneHandSword();
        }
        else if("1handAxe".equals(type)){
            return new OneHandAxe();
        }

        return null;
    }
}
