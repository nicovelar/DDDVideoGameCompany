package EmpresaVideoJuegos.inventory.values;
import co.com.sofka.domain.generic.Identity;
public class ItemID extends Identity {
    public ItemID() {
    }
    private ItemID(String id) {
        super(id);
    }
    public static ItemID of(String id) {
        return new ItemID(id);
    }
}
