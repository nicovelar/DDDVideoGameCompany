package EmpresaVideojuegos.npc.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.npc.NPC;
import EmpresaVideoJuegos.npc.commands.CreateNPC;

public class CreateNPCUseCase extends UseCase<RequestCommand<CreateNPC>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateNPC> createNPCRequestCommand) {
        var command = createNPCRequestCommand.getCommand();
        var npc = new NPC(command.getNpcid(), command.getName());
        emit().onResponse(new ResponseEvents(npc.getUncommittedChanges()));
    }
}