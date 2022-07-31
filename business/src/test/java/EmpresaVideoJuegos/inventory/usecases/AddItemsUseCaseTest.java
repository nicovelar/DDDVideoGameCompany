package EmpresaVideoJuegos.inventory.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.inventory.commands.AddItems;
import EmpresaVideoJuegos.inventory.events.InventoryCreated;
import EmpresaVideoJuegos.inventory.events.ItemsAdded;
import EmpresaVideoJuegos.inventory.values.InventoryID;
import EmpresaVideoJuegos.inventory.values.Name;
import EmpresaVideoJuegos.inventory.values.Price;
import EmpresaVideoJuegos.inventory.values.Weight;
import EmpresaVideojuegos.inventory.usecases.AddItemsUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddItemsUseCaseTest{
    @InjectMocks
    private AddItemsUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void addItemsHappyPass(){
        //arrange
        InventoryID inventoryID = InventoryID.of("ddddd");
        Price price = new Price(20);
        Weight weight = new Weight(20);
        var command = new AddItems(inventoryID,price,weight);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInventoryID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (ItemsAdded)events.get(0);
        Assertions.assertEquals(20, event.getPrice().value());
        Assertions.assertEquals(20, event.getWeight().value());
    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new InventoryCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}