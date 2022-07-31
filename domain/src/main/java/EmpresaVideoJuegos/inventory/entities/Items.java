package EmpresaVideoJuegos.inventory.entities;
import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.inventory.values.ItemID;
import EmpresaVideoJuegos.inventory.values.Price;
import EmpresaVideoJuegos.inventory.values.Weight;

public class Items extends Entity<ItemID> {
    private Price price;
    private Weight weight;
    public Items(ItemID itemID,Price price, Weight weight) {
        super(itemID);
        this.price = price;
        this.weight = weight;
    }
    public Price showPrice() {return price;}
    public Weight showWeight() {return weight;}
}
