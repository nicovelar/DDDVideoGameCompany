package EmpresaVideoJuegos.npc.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.npc.values.ActionID;
import EmpresaVideoJuegos.npc.values.Behaviour;
import EmpresaVideoJuegos.npc.values.Pathfinding;
public class ActionAdded extends DomainEvent {
    private final ActionID actionID;
    private final Pathfinding pathfinding;
    private final Behaviour behaviour;
    public ActionAdded(ActionID actionID, Pathfinding pathfinding, Behaviour behaviour) {
        super("EmpresaVideoJuegos.npc.actionadded");
        this.actionID = actionID;
        this.pathfinding = pathfinding;
        this.behaviour = behaviour;
    }
    public ActionID getActionID() {return actionID;}
    public Pathfinding getPathfinding() {return pathfinding;}
    public Behaviour getBehaviour() {return behaviour;}
}
