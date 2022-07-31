package EmpresaVideojuegos.inventory.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.inventory.Inventory;
import EmpresaVideoJuegos.inventory.commands.AddInterface;

public class AddInterfaceUseCase extends UseCase<RequestCommand<AddInterface>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddInterface> addInterfaceRequestCommand) {
        var command = addInterfaceRequestCommand.getCommand();
        Inventory inventory = Inventory.from(command.getInventoryID(), repository().getEventsBy(command.getInventoryID().value()));
        inventory.addInterface(command.getSlots(), command.getDesign());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}