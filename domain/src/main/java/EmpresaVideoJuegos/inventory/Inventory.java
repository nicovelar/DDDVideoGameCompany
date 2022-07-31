package EmpresaVideoJuegos.inventory;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.inventory.entities.Action;
import EmpresaVideoJuegos.inventory.entities.Interface;
import EmpresaVideoJuegos.inventory.entities.Items;
import EmpresaVideoJuegos.inventory.events.ActionAdded;
import EmpresaVideoJuegos.inventory.events.InterfaceAdded;
import EmpresaVideoJuegos.inventory.events.InventoryCreated;
import EmpresaVideoJuegos.inventory.events.ItemsAdded;
import EmpresaVideoJuegos.inventory.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
public class Inventory extends AggregateEvent<InventoryID> {
    protected Action action;
    //interface is a reserved word
    protected Interface inventoryInterface;
    protected Set<Items> itemsSet;
    protected Name name;
    public Inventory(InventoryID inventoryID,Name name) {
        super(inventoryID);
        appendChange(new InventoryCreated(name)).apply();
    }
    private Inventory(InventoryID inventoryID) {
        super(inventoryID);
        subscribe(new InventoryChange(this));
    }
    public static Inventory from(InventoryID entityId, List<DomainEvent> domainEvents) {
        var inventory = new Inventory(entityId);
        domainEvents.forEach(inventory::applyEvent);
        return inventory;
    }
    //events
    public void addAction(Crafting crafting, Dismantle dismantle) {
        var actionID = new ActionID();
        appendChange(new ActionAdded(actionID,crafting,dismantle)).apply();
    }
    public void addInterface(Slots slots, Design design) {
        InterfaceID interfaceID = new InterfaceID();
        appendChange(new InterfaceAdded(interfaceID,slots,design)).apply();
    }
    public void addItems(Price price, Weight weight) {
        ItemID itemID = new ItemID();
        appendChange(new ItemsAdded(itemID,price,weight)).apply();
    }
    protected Optional<Items> findItemById(ItemID itemID) {
        return this.itemsSet.stream().filter(item -> item.identity().equals(itemID)).findFirst();
    }
    public Action getAction(){return action;}
    public Interface getInventoryInterface(){return inventoryInterface;}
    public Set<Items> getItemsSet(){return itemsSet;}
    public Name getName(){return name;}
}
