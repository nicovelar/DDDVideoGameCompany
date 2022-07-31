package EmpresaVideoJuegos.npc.events;
import co.com.sofka.domain.generic.DomainEvent;
public class IsAlive extends DomainEvent {
    private final String message;
    public IsAlive(String message) {
        super("EmpresaVideoJuegos.npc.isalive");
        this.message = message;
    }
    public String getMessage() {return message;}
}
