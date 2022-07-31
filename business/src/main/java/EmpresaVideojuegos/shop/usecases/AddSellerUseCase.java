package EmpresaVideojuegos.shop.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.shop.Shop;
import EmpresaVideoJuegos.shop.commands.AddSeller;

public class AddSellerUseCase extends UseCase<RequestCommand<AddSeller>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSeller> addSellerRequestCommand) {
        var command = addSellerRequestCommand.getCommand();
        var shop = Shop.from(command.getShopID(), repository().getEventsBy(command.getShopID().value()));
        shop.addSeller(command.getDialogues());
        emit().onResponse(new ResponseEvents(shop.getUncommittedChanges()));
    }
}