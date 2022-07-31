package EmpresaVideoJuegos.npc.usecases;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import EmpresaVideoJuegos.npc.commands.CreateNPC;
import EmpresaVideoJuegos.npc.events.NPCCreated;
import EmpresaVideoJuegos.npc.values.NPCID;
import EmpresaVideoJuegos.npc.values.Name;
import EmpresaVideojuegos.npc.usecases.CreateNPCUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateNPCUseCaseTest {
    private CreateNPCUseCase useCase;
    @BeforeEach
    public void setup(){
        useCase = new CreateNPCUseCase();
    }

    @Test
    void executeUseCase() {
        //arrange
        NPCID npcid = NPCID.of("xxxxx");
        Name name = new Name("DDD");
        CreateNPC command = new CreateNPC( npcid, name);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        NPCCreated npcCreated = (NPCCreated) events.get(0);
        Assertions.assertEquals("xxxxx", npcCreated.aggregateRootId());
        Assertions.assertEquals("DDD", npcCreated.getName().value());
    }
}
