package EmpresaVideojuegos.npc.usecases;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import EmpresaVideoJuegos.npc.NPC;
import EmpresaVideoJuegos.npc.commands.AddAnimation;

public class AddAnimationUseCase extends UseCase<RequestCommand<AddAnimation>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddAnimation> addAnimationRequestCommand) {
        var command = addAnimationRequestCommand.getCommand();
        var npc = NPC.from(command.getNPCID(), repository().getEventsBy(command.getNPCID().value()));
        npc.addAnimation(command.getWalk(), command.getRun(), command.getJump());
        emit().onResponse(new ResponseEvents(npc.getUncommittedChanges()));
    }
}