package EmpresaVideoJuegos.inventory.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import EmpresaVideoJuegos.inventory.commands.CreateInventory;
import EmpresaVideoJuegos.inventory.events.InventoryCreated;
import EmpresaVideoJuegos.inventory.values.*;
import EmpresaVideojuegos.inventory.usecases.CreateInventoryUseCase;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CreateInventoryUseCaseTest {
    private CreateInventoryUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateInventoryUseCase();
    }

    @Test
    public void createInventoryHappyPass(){
        //arrange
        InventoryID inventoryID = InventoryID.of("xxxxx");
        Name name = new Name("DDD");
        CreateInventory command = new CreateInventory( inventoryID, name);
        //act
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        InventoryCreated inventoryCreated = (InventoryCreated)domainEvents.get(0);
        Assertions.assertEquals("xxxxx", inventoryCreated.aggregateRootId());
        Assertions.assertEquals("DDD", inventoryCreated.getName().value());
    }

}