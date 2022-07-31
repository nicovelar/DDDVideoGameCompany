package EmpresaVideoJuegos.shop.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.shop.values.Furniture;
import EmpresaVideoJuegos.shop.values.InfrastructureID;
import EmpresaVideoJuegos.shop.values.Location;
public class InfrastructureAdded extends DomainEvent {
    private final InfrastructureID infrastructureID;
    private final Furniture furniture;
    private final Location location;
    public InfrastructureAdded(InfrastructureID infrastructureID, Furniture furniture, Location location) {
        super("EmpresaVideoJuegos.shop.infrastructureadded");
        this.infrastructureID = infrastructureID;
        this.furniture = furniture;
        this.location = location;
    }
    public InfrastructureID getInfrastructureID() {return infrastructureID;}
    public Furniture getFurniture() {return furniture;}
    public Location getLocation() {return location;}
}
