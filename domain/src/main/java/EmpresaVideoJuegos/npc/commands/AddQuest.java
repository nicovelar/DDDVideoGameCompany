package EmpresaVideoJuegos.npc.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.npc.values.Dialogues;
import EmpresaVideoJuegos.npc.values.NPCID;
import EmpresaVideoJuegos.npc.values.RequestedItems;
import EmpresaVideoJuegos.npc.values.Reward;
public class AddQuest extends Command {
    private final NPCID npcid;
    private final Dialogues dialogues;
    private final RequestedItems requestedItems;
    private final Reward reward;
    public AddQuest(NPCID npcid, Dialogues dialogues, RequestedItems requestedItems, Reward reward) {
        this.npcid = npcid;
        this.dialogues = dialogues;
        this.requestedItems = requestedItems;
        this.reward = reward;
    }
    public NPCID getNPCID() {return npcid;}
    public Dialogues getDialogues() {return dialogues;}
    public RequestedItems getRequestedItems() {return requestedItems;}
    public Reward getReward() {return reward;}
}
