package EmpresaVideoJuegos.inventory.values;
import co.com.sofka.domain.generic.Identity;
public class InventoryID extends Identity {
    public InventoryID() {
    }
    private InventoryID(String id) {
        super(id);
    }
    public static InventoryID of(String id) {
        return new InventoryID(id);
    }
}
