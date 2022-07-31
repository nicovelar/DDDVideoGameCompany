package EmpresaVideojuegos.shop.usecases;
import EmpresaVideoJuegos.shop.Shop;
import EmpresaVideoJuegos.shop.events.ShopCreated;
import EmpresaVideoJuegos.shop.values.ShopID;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class SayOpenWhenShopCreatedUseCase extends UseCase<TriggeredEvent<ShopCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ShopCreated> shopCreatedTriggeredEvent) {
        var event = shopCreatedTriggeredEvent.getDomainEvent();
        var shop = Shop.from(ShopID.of(event.aggregateRootId()),this.retrieveEvents());
        shop.sayOpenWhenShopCreated("Open");
        emit().onResponse(new ResponseEvents(shop.getUncommittedChanges()));
    }
}