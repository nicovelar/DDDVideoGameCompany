package EmpresaVideoJuegos.shop.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.shop.values.Name;
public class ShopCreated extends DomainEvent {
    private final Name name;
    public ShopCreated(Name name) {
        super("EmpresaVideoJuegos.shop.shopcreated");
        this.name = name;
    }
    public Name getName() {return this.name;}
}
