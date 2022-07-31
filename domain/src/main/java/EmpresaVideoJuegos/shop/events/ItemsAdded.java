package EmpresaVideoJuegos.shop.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.shop.values.ItemID;
import EmpresaVideoJuegos.shop.values.Price;
public class ItemsAdded extends DomainEvent {
    private final ItemID itemID;
    private final Price price;
    public ItemsAdded(ItemID itemID, Price price) {
        super("EmpresaVideoJuegos.shop.itemsadded");
        this.itemID = itemID;
        this.price = price;
    }
    public ItemID getItemID() {return itemID;}
    public Price getPrice() {return price;}
}
