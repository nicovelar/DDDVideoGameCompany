package EmpresaVideoJuegos.npc.entities;

import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.npc.values.ActionID;
import EmpresaVideoJuegos.npc.values.Behaviour;
import EmpresaVideoJuegos.npc.values.Pathfinding;

import java.util.Objects;
public class Action extends Entity<ActionID> {
    private Pathfinding pathfinding;
    private Behaviour behaviour;
    public Action(ActionID actionID,Pathfinding pathfinding, Behaviour behaviour) {
        super(actionID);
        this.pathfinding = pathfinding;
        this.behaviour = behaviour;
    }
    public Pathfinding getPathfinding() {return pathfinding;}
    public Behaviour getBehaviour() {return behaviour;}
    public void behaviour (Behaviour behaviour) {
        this.behaviour = Objects.requireNonNull(behaviour);
    }
    public void pathfinding (Pathfinding pathfinding) {
        this.pathfinding = Objects.requireNonNull(pathfinding);
    }

}
