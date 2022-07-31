package EmpresaVideoJuegos.npc;
import co.com.sofka.domain.generic.EventChange;
import EmpresaVideoJuegos.npc.entities.*;
import EmpresaVideoJuegos.npc.events.*;
public class NPCChange extends EventChange {
    NPCChange(NPC npc) {
        apply((NPCCreated event) -> {
            npc.name = event.getName();
        });
        apply((ActionAdded event) -> {
            npc.action = new Action(event.getActionID(), event.getPathfinding(), event.getBehaviour());
            npc.action.pathfinding(event.getPathfinding());
            npc.action.behaviour(event.getBehaviour());
        });
        apply((AnimationAdded event) -> {
            npc.animation = new Animation(event.getAnimationID(), event.getWalk(), event.getRun(), event.getJump());
            npc.animation.putWalk(event.getWalk());
            npc.animation.putRun(event.getRun());
            npc.animation.putJump(event.getJump());
        });
        apply((QuestAdded event) -> {
            npc.quest = new Quest(event.getQuestID(),event.getDialogues(), event.getRequestedItems(), event.getReward());
            npc.quest.showDialogues();
            npc.quest.requestItems(event.getRequestedItems());
            npc.quest.giveReward(event.getReward());
        });
    }}
