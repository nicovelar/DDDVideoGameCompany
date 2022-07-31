package EmpresaVideoJuegos.npc.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.npc.values.Jump;
import EmpresaVideoJuegos.npc.values.NPCID;
import EmpresaVideoJuegos.npc.values.Run;
import EmpresaVideoJuegos.npc.values.Walk;
public class AddAnimation extends Command {
    private final NPCID npcid;
    private final Walk walk;
    private final Run run;
    private final Jump jump;
    public AddAnimation(NPCID npcid, Walk walk, Run run, Jump jump) {
        this.npcid = npcid;
        this.walk = walk;
        this.run = run;
        this.jump = jump;
    }
    public NPCID getNPCID() {return npcid;}
    public Walk getWalk() {return walk;}
    public Run getRun() {return run;}
    public Jump getJump() {return jump;}
}
