package EmpresaVideoJuegos.inventory.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.inventory.values.Design;
import EmpresaVideoJuegos.inventory.values.InventoryID;
import EmpresaVideoJuegos.inventory.values.Slots;
public class AddInterface extends Command {
    private final InventoryID inventoryID;
    private final Slots slots;
    private final Design design;
    public AddInterface(InventoryID inventoryID, Slots slots, Design design) {
        this.inventoryID = inventoryID;
        this.slots = slots;
        this.design = design;
    }
    public InventoryID getInventoryID() {return inventoryID;}
    public Slots getSlots() {return slots;}
    public Design getDesign() {return design;}
}
