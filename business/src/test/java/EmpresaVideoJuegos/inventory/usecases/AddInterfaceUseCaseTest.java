package EmpresaVideoJuegos.inventory.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.inventory.commands.AddInterface;
import EmpresaVideoJuegos.inventory.events.InterfaceAdded;
import EmpresaVideoJuegos.inventory.events.InventoryCreated;
import EmpresaVideoJuegos.inventory.values.*;
import EmpresaVideojuegos.inventory.usecases.AddInterfaceUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AddInterfaceUseCaseTest{
    @InjectMocks
    private AddInterfaceUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void addInterfaceHappyPass(){
        //arrange
        InventoryID inventoryID = InventoryID.of("ddddd");
        Slots slots = new Slots(20);
        Design design = new Design(DesignEnum.PATTERN1);
        var command = new AddInterface(inventoryID,slots,design);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInventoryID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (InterfaceAdded)events.get(0);
        Assertions.assertEquals(20, event.getSlots().value());
        Assertions.assertEquals(DesignEnum.PATTERN1, event.getDesign().value());
    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new InventoryCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}

