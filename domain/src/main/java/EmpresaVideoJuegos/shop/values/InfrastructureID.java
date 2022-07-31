package EmpresaVideoJuegos.shop.values;
import co.com.sofka.domain.generic.Identity;
public class InfrastructureID extends Identity {
    public InfrastructureID() {
    }
    private InfrastructureID(String id) {
        super(id);
    }
    public static InfrastructureID of(String id) {
        return new InfrastructureID(id);
    }
}
