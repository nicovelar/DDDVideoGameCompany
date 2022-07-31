package EmpresaVideoJuegos.shop.usecases;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import EmpresaVideoJuegos.shop.commands.CreateShop;
import EmpresaVideoJuegos.shop.events.ShopCreated;
import EmpresaVideoJuegos.shop.values.Name;
import EmpresaVideoJuegos.shop.values.ShopID;
import EmpresaVideojuegos.shop.usecases.CreateShopUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateShopUseCaseTest {
    private CreateShopUseCase useCase;
    @BeforeEach
    public void setup(){
        useCase = new CreateShopUseCase();
    }

    @Test
    void executeUseCase() {
        //arrange
        ShopID shopID = ShopID.of("xxxxx");
        Name name = new Name("DDD");
        CreateShop command = new CreateShop( shopID, name);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        ShopCreated shopCreated = (ShopCreated) events.get(0);
        Assertions.assertEquals("xxxxx", shopCreated.aggregateRootId());
        Assertions.assertEquals("DDD", shopCreated.getName().value());
    }
}
