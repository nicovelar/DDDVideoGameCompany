package EmpresaVideojuegos.shop.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.shop.Shop;
import EmpresaVideoJuegos.shop.commands.CreateShop;

public class CreateShopUseCase extends UseCase<RequestCommand<CreateShop>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateShop> createShopRequestCommand) {
        var command = createShopRequestCommand.getCommand();
        var shop = new Shop(command.getShopID(), command.getName());
        emit().onResponse(new ResponseEvents(shop.getUncommittedChanges()));
    }
}