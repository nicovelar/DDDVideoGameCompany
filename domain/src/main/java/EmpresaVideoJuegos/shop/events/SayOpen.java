package EmpresaVideoJuegos.shop.events;
import co.com.sofka.domain.generic.DomainEvent;
public class SayOpen extends DomainEvent {
    private final String message;
    public SayOpen(String message) {
        super("EmpresaVideoJuegos.shop.sayopen");
        this.message = message;
    }
    public String getMessage() {return message;}
}
