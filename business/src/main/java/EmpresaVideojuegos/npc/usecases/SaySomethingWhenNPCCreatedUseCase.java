package EmpresaVideojuegos.npc.usecases;
import EmpresaVideoJuegos.npc.NPC;
import EmpresaVideoJuegos.npc.events.NPCCreated;
import EmpresaVideoJuegos.npc.values.NPCID;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class SaySomethingWhenNPCCreatedUseCase extends UseCase<TriggeredEvent<NPCCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<NPCCreated> npcCreatedTriggeredEvent) {
        var event = npcCreatedTriggeredEvent.getDomainEvent();
        var npc = NPC.from(NPCID.of(event.aggregateRootId()),this.retrieveEvents());
        npc.saySomethingWhenNPCCreated("Hello, i'm alive");
        emit().onResponse(new ResponseEvents(npc.getUncommittedChanges()));
    }
}