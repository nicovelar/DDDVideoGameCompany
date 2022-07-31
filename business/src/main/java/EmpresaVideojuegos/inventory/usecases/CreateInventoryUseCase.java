package EmpresaVideojuegos.inventory.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.inventory.Inventory;
import EmpresaVideoJuegos.inventory.commands.CreateInventory;
public class CreateInventoryUseCase extends UseCase<RequestCommand<CreateInventory>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateInventory> createInventoryRequestCommand) {
        var command = createInventoryRequestCommand.getCommand();
        var inventory = new Inventory(command.getInventoryID(), command.getName());
        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}