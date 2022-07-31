package EmpresaVideoJuegos.shop.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.shop.values.Furniture;
import EmpresaVideoJuegos.shop.values.Location;
import EmpresaVideoJuegos.shop.values.ShopID;
public class AddInfrastructure extends Command {
    private final ShopID shopID;
    private final Furniture furniture;
    private final Location location;
    public AddInfrastructure(ShopID shopID, Furniture furniture, Location location) {
        this.shopID = shopID;
        this.furniture = furniture;
        this.location = location;
    }
    public ShopID getShopID() {return shopID;}
    public Furniture getFurniture() {return furniture;}
    public Location getLocation() {return location;}
}
