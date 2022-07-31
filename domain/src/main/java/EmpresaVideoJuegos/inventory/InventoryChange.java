package EmpresaVideoJuegos.inventory;

import co.com.sofka.domain.generic.EventChange;
import EmpresaVideoJuegos.inventory.entities.*;
import EmpresaVideoJuegos.inventory.events.*;

import java.util.HashSet;
public class InventoryChange extends EventChange {
    InventoryChange(Inventory inventory) {
        apply((InventoryCreated event) -> {
            inventory.itemsSet = new HashSet<>();
            inventory.name = event.getName();
        });
        apply((ActionAdded event) -> {
            inventory.action = new Action(event.getActionID(), event.getCrafting(), event.getDismantle());
            inventory.action.showCrafting();
            inventory.action.dismantle(event.getDismantle());
        });
        apply((InterfaceAdded event) -> {
            inventory.inventoryInterface = new Interface(event.getInterfaceID(), event.getSlots(), event.getDesign());
            inventory.inventoryInterface.showSlots();
            inventory.inventoryInterface.useDesign(event.getDesign());
        });
        apply((ItemsAdded event) -> {
            Items items = new Items(event.getItemID(), event.getPrice(), event.getWeight());
            inventory.itemsSet.add(items);
            items = inventory.findItemById(event.getItemID()).orElseThrow();
            items.showPrice();
            items.showWeight();
        });
    }}
