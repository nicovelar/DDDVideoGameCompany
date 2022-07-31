package EmpresaVideoJuegos.inventory.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.inventory.values.ItemID;
import EmpresaVideoJuegos.inventory.values.Price;
import EmpresaVideoJuegos.inventory.values.Weight;
public class ItemsAdded extends DomainEvent {
    private final ItemID itemID;
    private final Price price;
    private final Weight weight;
    public ItemsAdded(ItemID itemID, Price price, Weight weight) {
        super("EmpresaVideoJuegos.inventory.itemsadded");
        this.itemID = itemID;
        this.price = price;
        this.weight = weight;
    }
    public ItemID getItemID() {return itemID;}
    public Price getPrice() {return price;}
    public Weight getWeight() {return weight;}
}
