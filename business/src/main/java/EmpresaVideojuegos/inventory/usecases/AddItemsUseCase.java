package EmpresaVideojuegos.inventory.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.inventory.Inventory;
import EmpresaVideoJuegos.inventory.commands.AddItems;

public class AddItemsUseCase extends UseCase<RequestCommand<AddItems>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddItems> addItemsRequestCommand) {
        var command = addItemsRequestCommand.getCommand();
        Inventory inventory = Inventory.from(command.getInventoryID(), repository().getEventsBy(command.getInventoryID().value()));
        inventory.addItems(command.getPrice(), command.getWeight());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}