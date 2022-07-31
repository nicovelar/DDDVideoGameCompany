package EmpresaVideojuegos.shop.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.shop.Shop;
import EmpresaVideoJuegos.shop.commands.AddInfrastructure;

public class AddInfrastructureUseCase extends UseCase<RequestCommand<AddInfrastructure>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddInfrastructure> addInfrastructureRequestCommand) {
        var command = addInfrastructureRequestCommand.getCommand();
        var shop = Shop.from(command.getShopID(), repository().getEventsBy(command.getShopID().value()));
        shop.addInfrastructure(command.getFurniture(), command.getLocation());
        emit().onResponse(new ResponseEvents(shop.getUncommittedChanges()));
    }
}