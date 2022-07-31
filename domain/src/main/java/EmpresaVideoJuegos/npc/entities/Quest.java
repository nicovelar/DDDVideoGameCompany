package EmpresaVideoJuegos.npc.entities;

import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.npc.values.Dialogues;
import EmpresaVideoJuegos.npc.values.QuestID;
import EmpresaVideoJuegos.npc.values.RequestedItems;
import EmpresaVideoJuegos.npc.values.Reward;

import java.util.Objects;
public class Quest extends Entity<QuestID> {
    private Dialogues dialogues;
    private RequestedItems requestedItems;
    private Reward reward;
    public Quest(QuestID questID,Dialogues dialogues, RequestedItems requestedItems, Reward reward) {
        super(questID);
        this.dialogues = dialogues;
        this.requestedItems = requestedItems;
        this.reward = reward;
    }
    public Dialogues showDialogues() {return dialogues;}
    public RequestedItems getRequestedItems() {return requestedItems;}
    public Reward getReward() {return reward;}
    public void requestItems (RequestedItems requestedItems) {
        this.requestedItems = Objects.requireNonNull(requestedItems);
    }
    public void giveReward (Reward reward) {
        this.reward = Objects.requireNonNull(reward);
    }
}