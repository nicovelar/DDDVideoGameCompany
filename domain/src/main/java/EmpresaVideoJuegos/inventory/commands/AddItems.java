package EmpresaVideoJuegos.inventory.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.inventory.values.InventoryID;
import EmpresaVideoJuegos.inventory.values.Price;
import EmpresaVideoJuegos.inventory.values.Weight;
public class AddItems extends Command {
    private final InventoryID inventoryID;
    private final Price price;
    private final Weight weight;
    public AddItems(InventoryID inventoryID, Price price, Weight weight) {
        this.inventoryID = inventoryID;
        this.price = price;
        this.weight = weight;
    }
    public InventoryID getInventoryID() {return inventoryID;}
    public Price getPrice() {return price;}
    public Weight getWeight() {return weight;}
}
