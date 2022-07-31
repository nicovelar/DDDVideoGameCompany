package EmpresaVideoJuegos.npc.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.npc.commands.AddAnimation;
import EmpresaVideoJuegos.npc.events.AnimationAdded;
import EmpresaVideoJuegos.npc.events.NPCCreated;
import EmpresaVideoJuegos.npc.values.*;
import EmpresaVideojuegos.npc.usecases.AddAnimationUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddAnimationUseCaseTest {
    @InjectMocks
    private AddAnimationUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void addAnimationHappyPass(){
        //arrange
        NPCID npcid = NPCID.of("ddddd");
        Walk walk = new Walk(60);
        Run run = new Run(60);
        Jump jump = new Jump(60);
        var command = new AddAnimation(npcid,walk,run,jump);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getNPCID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (AnimationAdded)events.get(0);
        Assertions.assertEquals(60, event.getWalk().value());
        Assertions.assertEquals(60, event.getRun().value());
        Assertions.assertEquals(60, event.getJump().value());
    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new NPCCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}