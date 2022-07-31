package EmpresaVideoJuegos.shop.usecases;
import EmpresaVideoJuegos.shop.events.ItemsAdded;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.shop.commands.AddItems;
import EmpresaVideoJuegos.shop.events.ShopCreated;
import EmpresaVideoJuegos.shop.values.Name;
import EmpresaVideoJuegos.shop.values.Price;
import EmpresaVideoJuegos.shop.values.ShopID;
import EmpresaVideojuegos.shop.usecases.AddItemsUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddItemsUseCaseTest {
    @InjectMocks
    private AddItemsUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void addItemsHappyPass(){
        //arrange
        ShopID shopID = ShopID.of("ddddd");
        Price price = new Price(50);
        var command = new AddItems(shopID,price);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getShopID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (ItemsAdded)events.get(0);
        Assertions.assertEquals(50, event.getPrice().value());
    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new ShopCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}