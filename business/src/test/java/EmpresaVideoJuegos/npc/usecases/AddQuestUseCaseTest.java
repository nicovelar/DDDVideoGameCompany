package EmpresaVideoJuegos.npc.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.npc.commands.AddQuest;
import EmpresaVideoJuegos.npc.events.NPCCreated;
import EmpresaVideoJuegos.npc.events.QuestAdded;
import EmpresaVideoJuegos.npc.values.*;
import EmpresaVideojuegos.npc.usecases.AddQuestUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddQuestUseCaseTest {
    @InjectMocks
    private AddQuestUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void addQuestHappyPass(){
        //arrange
        NPCID npcid = NPCID.of("ddddd");
        Dialogues dialogues = new Dialogues(DialoguesEnum.DIALOGUE1);
        RequestedItems requestedItems = new RequestedItems(RequestedItemsEnum.ITEM1);
        Reward reward = new Reward(RewardEnum.ITEM2);
        var command = new AddQuest(npcid,dialogues,requestedItems,reward);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getNPCID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (QuestAdded)events.get(0);
        Assertions.assertEquals(DialoguesEnum.DIALOGUE1, event.getDialogues().value());
        Assertions.assertEquals(RequestedItemsEnum.ITEM1, event.getRequestedItems().value());
        Assertions.assertEquals(RewardEnum.ITEM2, event.getReward().value());
    }
    private List<DomainEvent> history() {
        Name name = new Name("DDD");
        var event = new NPCCreated(name);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}