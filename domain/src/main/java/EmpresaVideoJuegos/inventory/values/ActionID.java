package EmpresaVideoJuegos.inventory.values;

import co.com.sofka.domain.generic.Identity;

public class ActionID extends Identity {
    public ActionID() {
    }

    private ActionID(String id) {
        super(id);
    }

    public static ActionID of(String id) {
        return new ActionID(id);
    }
}
