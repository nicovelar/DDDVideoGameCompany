package EmpresaVideoJuegos.inventory.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.inventory.values.Crafting;
import EmpresaVideoJuegos.inventory.values.Dismantle;
import EmpresaVideoJuegos.inventory.values.InventoryID;
public class AddAction extends Command {
    private final InventoryID inventoryID;
    private final Crafting crafting;
    private final Dismantle dismantle;
    public AddAction(InventoryID inventoryID, Crafting crafting, Dismantle dismantle) {
        this.inventoryID = inventoryID;
        this.crafting = crafting;
        this.dismantle = dismantle;
    }
    public InventoryID getInventoryID() {return inventoryID;}
    public Crafting getCrafting() {return crafting;}
    public Dismantle getDismantle() {return dismantle;}
}
