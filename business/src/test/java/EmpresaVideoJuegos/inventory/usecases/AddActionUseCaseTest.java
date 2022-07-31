package EmpresaVideoJuegos.inventory.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.inventory.commands.AddAction;
import EmpresaVideoJuegos.inventory.events.ActionAdded;
import EmpresaVideoJuegos.inventory.events.InventoryCreated;
import EmpresaVideoJuegos.inventory.values.*;
import EmpresaVideojuegos.inventory.usecases.AddActionUseCase;
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
        InventoryID inventoryID = InventoryID.of("ddddd");
        Crafting crafting = new Crafting(CraftingEnum.RECIPE1);
        Dismantle dismantle = new Dismantle(DismantleEnum.ITEM1);
        var command = new AddAction(inventoryID,crafting,dismantle);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInventoryID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ActionAdded)events.get(0);
        Assertions.assertEquals(CraftingEnum.RECIPE1, event.getCrafting().value());
        Assertions.assertEquals(DismantleEnum.ITEM1, event.getDismantle().value());

    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new InventoryCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}