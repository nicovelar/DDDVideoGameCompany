package EmpresaVideojuegos.npc.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.npc.NPC;
import EmpresaVideoJuegos.npc.commands.AddAction;

public class AddActionUseCase extends UseCase<RequestCommand<AddAction>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddAction> addActionRequestCommand) {
        var command = addActionRequestCommand.getCommand();
        var npc = NPC.from(command.getNPCID(), repository().getEventsBy(command.getNPCID().value()));
        npc.addAction(command.getPathfinding(), command.getBehaviour());
        emit().onResponse(new ResponseEvents(npc.getUncommittedChanges()));
    }
}