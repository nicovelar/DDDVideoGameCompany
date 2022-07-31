package EmpresaVideoJuegos.npc.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.npc.values.NPCID;
import EmpresaVideoJuegos.npc.values.Name;
public class CreateNPC extends Command {
    private final NPCID npcid;
    private final Name name;
    public CreateNPC(NPCID npcid, Name name) {
        this.npcid = npcid;
        this.name = name;
    }
    public NPCID getNpcid() {
        return npcid;
    }
    public Name getName() {
        return name;
    }
}
