package EmpresaVideoJuegos.shop;

import EmpresaVideoJuegos.shop.events.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.shop.entities.Infrastructure;
import EmpresaVideoJuegos.shop.entities.Items;
import EmpresaVideoJuegos.shop.entities.Seller;
import EmpresaVideoJuegos.shop.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
public class Shop extends AggregateEvent<ShopID> {
    protected Infrastructure infrastructure;
    protected Set<Items> itemsSet;
    protected Seller seller;
    protected Name name;
    public Shop(ShopID shopID,Name name) {
        super(shopID);
        appendChange(new ShopCreated(name)).apply();
    }
    private Shop(ShopID shopID) {
        super(shopID);
        subscribe(new ShopChange(this));
    }
    public static Shop from(ShopID shopID, List<DomainEvent> domainEvents) {
        var shop = new Shop(shopID);
        domainEvents.forEach(shop::applyEvent);
        return shop;
    }
    //events
    public void addInfrastructure(Furniture furniture, Location location) {
        var infrastructureID = new InfrastructureID();
        appendChange(new InfrastructureAdded(infrastructureID,furniture,location)).apply();
    }
    public void addSeller(Dialogues dialogues) {
        NPCID npcid = new NPCID();
        appendChange(new SellerAdded(npcid,dialogues)).apply();
    }
    public void addItems(Price price) {
        ItemID itemID = new ItemID();
        appendChange(new ItemsAdded(itemID,price)).apply();
    }
    protected Optional<Items> findItemById(ItemID itemID) {
        return this.itemsSet.stream().filter(item -> item.identity().equals(itemID)).findFirst();
    }

    public void sayOpenWhenShopCreated(String message) {
        Objects.requireNonNull(message);
        appendChange(new SayOpen(message)).apply();
    }

    public Infrastructure getInfrastructure(){return infrastructure;}
    public Seller getSeller(){return seller;}
    public Set<Items> getItemsSet(){return itemsSet;}
    public Name getName(){return name;}
}
