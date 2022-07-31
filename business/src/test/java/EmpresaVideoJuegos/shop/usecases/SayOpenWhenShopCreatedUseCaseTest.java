package EmpresaVideoJuegos.shop.usecases;
import EmpresaVideoJuegos.shop.events.SayOpen;
import EmpresaVideoJuegos.shop.events.ShopCreated;
import EmpresaVideoJuegos.shop.values.Name;
import EmpresaVideojuegos.shop.usecases.SayOpenWhenShopCreatedUseCase;
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
class SayOpenWhenShopCreatedUseCaseTest {
    @InjectMocks
    private SayOpenWhenShopCreatedUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void SayOpenWhenShopCreated(){
        //arrange
        Name name= new Name("ddddd");
        var event = new ShopCreated(name);

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
        var message = (SayOpen)events.get(0);
        Assertions.assertEquals("Open", message.getMessage());
    }
}