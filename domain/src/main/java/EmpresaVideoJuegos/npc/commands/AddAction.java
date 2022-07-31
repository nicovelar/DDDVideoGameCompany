package EmpresaVideoJuegos.npc.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.npc.values.Behaviour;
import EmpresaVideoJuegos.npc.values.NPCID;
import EmpresaVideoJuegos.npc.values.Pathfinding;
public class AddAction extends Command {
    private final NPCID npcid;
    private final Pathfinding pathfinding;
    private final Behaviour behaviour;
    public AddAction(NPCID npcid, Pathfinding pathfinding, Behaviour behaviour) {
        this.npcid = npcid;
        this.pathfinding = pathfinding;
        this.behaviour = behaviour;
    }
    public NPCID getNPCID() {return npcid;}
    public Pathfinding getPathfinding() {return pathfinding;}
    public Behaviour getBehaviour() {return behaviour;}
}
