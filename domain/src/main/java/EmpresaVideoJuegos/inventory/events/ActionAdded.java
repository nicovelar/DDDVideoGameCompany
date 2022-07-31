package EmpresaVideoJuegos.inventory.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.inventory.values.ActionID;
import EmpresaVideoJuegos.inventory.values.Crafting;
import EmpresaVideoJuegos.inventory.values.Dismantle;
public class ActionAdded extends DomainEvent {
    private final ActionID actionID;
    private final Crafting crafting;
    private final Dismantle dismantle;
    public ActionAdded(ActionID actionID, Crafting crafting, Dismantle dismantle) {
        super("EmpresaVideoJuegos.inventory.actionadded");
        this.actionID = actionID;
        this.crafting = crafting;
        this.dismantle = dismantle;
    }
    public ActionID getActionID() {return actionID;}
    public Crafting getCrafting() {return crafting;}
    public Dismantle getDismantle() {return dismantle;}
}
