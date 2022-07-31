package EmpresaVideoJuegos.shop.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.shop.values.Price;
import EmpresaVideoJuegos.shop.values.ShopID;
public class AddItems extends Command {
    private final ShopID shopID;
    private final Price price;
    public AddItems(ShopID shopID, Price price) {
        this.shopID = shopID;
        this.price = price;
    }
    public ShopID getShopID() {return shopID;}
    public Price getPrice() {return price;}
}
