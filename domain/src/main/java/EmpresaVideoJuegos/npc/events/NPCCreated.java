package EmpresaVideoJuegos.npc.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.npc.values.Name;
public class NPCCreated extends DomainEvent {
    private final Name name;
    public NPCCreated(Name name) {
        super("EmpresaVideoJuegos.npc.npccreated");
        this.name = name;
    }
    public Name getName() {return this.name;}
}
