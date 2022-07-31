package EmpresaVideoJuegos.shop.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.shop.commands.AddInfrastructure;
import EmpresaVideoJuegos.shop.events.InfrastructureAdded;
import EmpresaVideoJuegos.shop.events.ShopCreated;
import EmpresaVideoJuegos.shop.values.*;
import EmpresaVideojuegos.shop.usecases.AddInfrastructureUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddInfrastructureUseCaseTest {
    @InjectMocks
    private AddInfrastructureUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void addInfrastructureHappyPass(){
        //arrange
        ShopID shopID = ShopID.of("ddddd");
        Furniture furniture = new Furniture(FurnitureEnum.MESA);
        Location location = new Location("Ventalia");
        var command = new AddInfrastructure(shopID,furniture,location);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getShopID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (InfrastructureAdded)events.get(0);
        Assertions.assertEquals(FurnitureEnum.MESA, event.getFurniture().value());
        Assertions.assertEquals("Ventalia", event.getLocation().value());
    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new ShopCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}