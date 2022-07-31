package EmpresaVideoJuegos.npc.values;
import co.com.sofka.domain.generic.Identity;
public class NPCID extends Identity {
    public NPCID() {
    }
    private NPCID(String id) {
        super(id);
    }
    public static NPCID of(String id) {
        return new NPCID(id);
    }
}
