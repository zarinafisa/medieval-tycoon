
package model;

import interfaces.PerkConverter;
import enums.PerkType;

public class PerksElegan extends Perk implements PerkConverter {
    public PerksElegan(String nama, String deskripsi, double kesaktian) {
        super(nama, deskripsi, PerkType.ELEGAN);
        this.kesaktian = kesaktian;
    }
    
    @Override
    public double getPerkEffect(){
        
    }
    
    @Override
    public boolean upgradeLevel(int biaya) {
        
    }
    
    @Override
    public boolean convertPerk(Perk perk, String targetType) {
        
    }
    
    @Override
    public void tampilkanDetail(){
        
    }
    
}
