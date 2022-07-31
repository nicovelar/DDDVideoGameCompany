package EmpresaVideoJuegos.inventory.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.inventory.values.Design;
import EmpresaVideoJuegos.inventory.values.InterfaceID;
import EmpresaVideoJuegos.inventory.values.Slots;
public class InterfaceAdded extends DomainEvent {
    private final InterfaceID interfaceID;
    private final Slots slots;
    private final Design design;
    public InterfaceAdded(InterfaceID interfaceID, Slots slots, Design design) {
        super("EmpresaVideoJuegos.inventory.interfaceadded");
        this.interfaceID = interfaceID;
        this.slots = slots;
        this.design = design;
    }
    public InterfaceID getInterfaceID() {return interfaceID;}
    public Slots getSlots() {return slots;}
    public Design getDesign() {return design;}
}
