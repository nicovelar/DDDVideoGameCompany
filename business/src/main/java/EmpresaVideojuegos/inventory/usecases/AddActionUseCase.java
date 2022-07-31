package EmpresaVideojuegos.inventory.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.inventory.Inventory;
import EmpresaVideoJuegos.inventory.commands.AddAction;

public class AddActionUseCase extends UseCase<RequestCommand<AddAction>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddAction> addActionRequestCommand) {
        var command = addActionRequestCommand.getCommand();
        var inventory = Inventory.from(command.getInventoryID(), repository().getEventsBy(command.getInventoryID().value()));
        inventory.addAction(command.getCrafting(), command.getDismantle());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}