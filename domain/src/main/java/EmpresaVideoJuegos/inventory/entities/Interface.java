package EmpresaVideoJuegos.inventory.entities;
import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.inventory.values.Design;
import EmpresaVideoJuegos.inventory.values.InterfaceID;
import EmpresaVideoJuegos.inventory.values.Slots;

public class Interface extends Entity<InterfaceID> {
    private Slots slots;
    private Design design;
    public Interface(InterfaceID interfaceID,Slots slots, Design design) {
        super(interfaceID);
        this.slots = slots;
        this.design = design;
    }
    public Slots showSlots() {return slots;}
    public Design getDesign() {return design;}
    public void useDesign(Design design) {
        this.design = design;
    }
}
