package EmpresaVideoJuegos.shop.entities;
import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.shop.values.Furniture;
import EmpresaVideoJuegos.shop.values.InfrastructureID;
import EmpresaVideoJuegos.shop.values.Location;

public class Infrastructure extends Entity<InfrastructureID> {
    private Furniture furniture;
    private Location location;
    public Infrastructure(InfrastructureID infrastructureID, Furniture furniture, Location location) {
        super(infrastructureID);
        this.furniture = furniture;
        this.location = location;
    }
    public Furniture getFurniture() {return furniture;}
    public Location getLocation() {return location;}
    public void setFurniture(Furniture furniture) { this.furniture = furniture; }
    public void setLocation(Location location) { this.location = location; }
}
