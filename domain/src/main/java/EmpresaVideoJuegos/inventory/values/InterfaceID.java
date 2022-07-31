package EmpresaVideoJuegos.inventory.values;

import co.com.sofka.domain.generic.Identity;

public class InterfaceID extends Identity {
    public InterfaceID() {
    }

    private InterfaceID(String id) {
        super(id);
    }

    public static InterfaceID of(String id) {
        return new InterfaceID(id);
    }
}

