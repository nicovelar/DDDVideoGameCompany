package EmpresaVideoJuegos.shop;

import co.com.sofka.domain.generic.EventChange;
import EmpresaVideoJuegos.shop.entities.*;
import EmpresaVideoJuegos.shop.events.*;

import java.util.HashSet;
public class ShopChange extends EventChange {
    ShopChange(Shop shop) {
        apply((ShopCreated event) -> {
            shop.itemsSet = new HashSet<>();
            shop.name = event.getName();
        });
        apply((InfrastructureAdded event) -> {
            shop.infrastructure = new Infrastructure(event.getInfrastructureID(), event.getFurniture(), event.getLocation());
            shop.infrastructure.setFurniture(event.getFurniture());
            shop.infrastructure.setLocation(event.getLocation());
        });
        apply((SellerAdded event) -> {
            shop.seller = new Seller(event.getNpcid(), event.getDialogues());
            shop.seller.selectDialogues(event.getDialogues());
        });
        apply((ItemsAdded event) -> {
            Items items = new Items(event.getItemID(), event.getPrice());
            shop.itemsSet.add(items);
            items = shop.findItemById(event.getItemID()).orElseThrow();
            items.updatePrice(event.getPrice());
        });
    }}