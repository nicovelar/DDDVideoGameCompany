package EmpresaVideoJuegos.inventory.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.inventory.values.InventoryID;
import EmpresaVideoJuegos.inventory.values.Name;
public class CreateInventory extends Command {
    private final InventoryID inventoryID;
    private final Name name;
    public CreateInventory(InventoryID inventoryID, Name name) {
        this.inventoryID = inventoryID;
        this.name = name;
    }
    public InventoryID getInventoryID() {
        return inventoryID;
    }
    public Name getName() {
        return name;
    }
}
