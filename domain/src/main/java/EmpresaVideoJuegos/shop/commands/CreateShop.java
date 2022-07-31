package EmpresaVideoJuegos.shop.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.shop.values.Name;
import EmpresaVideoJuegos.shop.values.ShopID;
public class CreateShop extends Command {
    private final ShopID shopID;
    private final Name name;
    public CreateShop(ShopID shopID, Name name) {
        this.shopID = shopID;
        this.name = name;
    }
    public ShopID getShopID() {
        return shopID;
    }
    public Name getName() {
        return name;
    }
}
