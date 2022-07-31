package EmpresaVideojuegos.shop.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.shop.Shop;
import EmpresaVideoJuegos.shop.commands.AddItems;

public class AddItemsUseCase extends UseCase<RequestCommand<AddItems>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddItems> addItemsRequestCommand) {
        var command = addItemsRequestCommand.getCommand();
        var shop = Shop.from(command.getShopID(), repository().getEventsBy(command.getShopID().value()));
        shop.addItems(command.getPrice());
        emit().onResponse(new ResponseEvents(shop.getUncommittedChanges()));
    }
}