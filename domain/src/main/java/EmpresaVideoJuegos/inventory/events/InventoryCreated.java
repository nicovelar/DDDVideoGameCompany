package EmpresaVideoJuegos.inventory.events;

import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.inventory.values.Name;
public class InventoryCreated extends DomainEvent {
    private final Name name;

    public InventoryCreated(Name name) {
        super("EmpresaVideoJuegos.inventory.inventorycreated");
        this.name = name;
    }
    public Name getName() {return this.name;}

}
