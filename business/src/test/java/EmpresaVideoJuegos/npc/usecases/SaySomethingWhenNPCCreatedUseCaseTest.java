package EmpresaVideoJuegos.npc.usecases;
import EmpresaVideoJuegos.npc.events.IsAlive;
import EmpresaVideoJuegos.npc.events.NPCCreated;
import EmpresaVideoJuegos.npc.values.Name;
import EmpresaVideojuegos.npc.usecases.SaySomethingWhenNPCCreatedUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaySomethingWhenNPCCreatedUseCaseTest {
    @InjectMocks
    private SaySomethingWhenNPCCreatedUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void SaySomething(){
        //arrange
        Name name= new Name("ddddd");
        var event = new NPCCreated(name);

        event.setAggregateRootId("xxxxx");

        when(repository.getEventsBy("xxxxx")).thenReturn(List.of(event));
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxxx")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var message = (IsAlive)events.get(0);
        Assertions.assertEquals("Hello, i'm alive", message.getMessage());
    }
}