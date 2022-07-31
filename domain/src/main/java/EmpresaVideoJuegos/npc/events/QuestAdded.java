package EmpresaVideoJuegos.npc.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.npc.values.Dialogues;
import EmpresaVideoJuegos.npc.values.QuestID;
import EmpresaVideoJuegos.npc.values.RequestedItems;
import EmpresaVideoJuegos.npc.values.Reward;
public class QuestAdded extends DomainEvent {
    private final QuestID questID;
    private final Dialogues dialogues;
    private final RequestedItems requestedItems;
    private final Reward reward;
    public QuestAdded(QuestID questID, Dialogues dialogues, RequestedItems requestedItems, Reward reward) {
        super("EmpresaVideoJuegos.npc.questadded");
        this.questID = questID;
        this.dialogues = dialogues;
        this.requestedItems = requestedItems;
        this.reward = reward;
    }
    public QuestID getQuestID() {return questID;}
    public Dialogues getDialogues() {return dialogues;}
    public RequestedItems getRequestedItems() {return requestedItems;}
    public Reward getReward() {return reward;}
}
