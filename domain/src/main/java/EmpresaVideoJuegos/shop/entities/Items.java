package EmpresaVideoJuegos.shop.entities;
import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.shop.values.ItemID;
import EmpresaVideoJuegos.shop.values.Price;
public class Items extends Entity<ItemID> {
    private Price price;
    public Items(ItemID itemID, Price price) {
        super(itemID);
        this.price = price;
    }
    public Price getPrice() {return price;}
    public void updatePrice(Price price) { this.price = price; }
}
