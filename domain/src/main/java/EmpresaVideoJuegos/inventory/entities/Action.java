package EmpresaVideoJuegos.inventory.entities;

import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.inventory.values.ActionID;
import EmpresaVideoJuegos.inventory.values.Crafting;
import EmpresaVideoJuegos.inventory.values.Dismantle;

import java.util.Objects;
public class Action extends Entity<ActionID> {
    private Crafting crafting;
    private Dismantle dismantle;
    public Action(ActionID actionID,Crafting crafting, Dismantle dismantle) {
        super(actionID);
        this.crafting = crafting;
        this.dismantle = dismantle;
    }
    public Crafting showCrafting() {return crafting;}
    public Dismantle getDismantle() {return dismantle;}
    public void dismantle(Dismantle dismantle) {
        this.dismantle = Objects.requireNonNull(dismantle);
    }

}
