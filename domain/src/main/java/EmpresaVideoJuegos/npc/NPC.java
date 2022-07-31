package EmpresaVideoJuegos.npc;

import EmpresaVideoJuegos.shop.events.SayOpen;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.npc.entities.*;
import EmpresaVideoJuegos.npc.events.*;
import EmpresaVideoJuegos.npc.values.*;

import java.util.List;
import java.util.Objects;

public class NPC extends AggregateEvent<NPCID> {
    protected Action action;
    protected Animation animation;
    protected Quest quest;
    protected Name name;
    public NPC(NPCID npcid,Name name) {
        super(npcid);
        appendChange(new NPCCreated(name)).apply();
    }
    private NPC(NPCID npcid) {
        super(npcid);
        subscribe(new NPCChange(this));
    }
    public static NPC from(NPCID entityId, List<DomainEvent> domainEvents) {
        var npc = new NPC(entityId);
        domainEvents.forEach(npc::applyEvent);
        return npc;
    }
    //events
    public void addAction(Pathfinding pathfinding, Behaviour behaviour) {
        var actionID = new ActionID();
        appendChange(new ActionAdded(actionID,pathfinding,behaviour)).apply();
    }
    public void addAnimation(Walk walk, Run run, Jump jump) {
        AnimationID animationID = new AnimationID();
        appendChange(new AnimationAdded(animationID,walk,run,jump)).apply();
    }
    public void addQuest(Dialogues dialogues, RequestedItems requestedItems, Reward reward) {
        QuestID questID = new QuestID();
        appendChange(new QuestAdded(questID,dialogues,requestedItems,reward)).apply();
    }
    public void saySomethingWhenNPCCreated(String message) {
        Objects.requireNonNull(message);
        appendChange(new IsAlive(message)).apply();
    }
    public Action getAction(){return action;}
    public Animation getAnimation(){return animation;}
    public Quest getQuest(){return quest;}
    public Name getName(){return name;}
}