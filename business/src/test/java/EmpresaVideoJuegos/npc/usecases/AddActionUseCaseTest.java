package EmpresaVideoJuegos.npc.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.npc.commands.AddAction;
import EmpresaVideoJuegos.npc.events.ActionAdded;
import EmpresaVideoJuegos.npc.events.NPCCreated;
import EmpresaVideoJuegos.npc.values.*;
import EmpresaVideojuegos.npc.usecases.AddActionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddActionUseCaseTest {
    @InjectMocks
    private AddActionUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void addActionHappyPass(){
        //arrange
        NPCID npcid = NPCID.of("ddddd");
        Pathfinding pathfinding = new Pathfinding(PathfindingEnum.PATH1);
        Behaviour behaviour = new Behaviour(BehaviourEnum.BEHAVIOUR1);
        var command = new AddAction(npcid,pathfinding,behaviour);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getNPCID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (ActionAdded)events.get(0);
        Assertions.assertEquals(PathfindingEnum.PATH1, event.getPathfinding().value());
        Assertions.assertEquals(BehaviourEnum.BEHAVIOUR1, event.getBehaviour().value());
    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new NPCCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}