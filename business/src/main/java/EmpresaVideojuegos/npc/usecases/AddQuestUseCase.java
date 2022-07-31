package EmpresaVideojuegos.npc.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.npc.NPC;
import EmpresaVideoJuegos.npc.commands.AddQuest;

public class AddQuestUseCase extends UseCase<RequestCommand<AddQuest>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddQuest> addQuestRequestCommand) {
        var command = addQuestRequestCommand.getCommand();
        var npc = NPC.from(command.getNPCID(), repository().getEventsBy(command.getNPCID().value()));
        npc.addQuest(command.getDialogues(), command.getRequestedItems(), command.getReward());
        emit().onResponse(new ResponseEvents(npc.getUncommittedChanges()));
    }
}