package EmpresaVideoJuegos.shop.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.shop.commands.AddSeller;
import EmpresaVideoJuegos.shop.events.SellerAdded;
import EmpresaVideoJuegos.shop.events.ShopCreated;
import EmpresaVideoJuegos.shop.values.*;
import EmpresaVideojuegos.shop.usecases.AddSellerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddSellerUseCaseTest {
    @InjectMocks
    private AddSellerUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void addSellerHappyPass(){
        //arrange
        ShopID shopID= ShopID.of("ddddd");
        Dialogues dialogues = new Dialogues(DialoguesEnum.DIALOGUE1);
        var command = new AddSeller(shopID,dialogues);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getShopID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (SellerAdded)events.get(0);
        Assertions.assertEquals(DialoguesEnum.DIALOGUE1, event.getDialogues().value());
    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new ShopCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}