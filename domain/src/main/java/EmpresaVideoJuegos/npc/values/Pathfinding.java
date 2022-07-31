package EmpresaVideoJuegos.npc.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Pathfinding implements ValueObject<PathfindingEnum> {
    private final PathfindingEnum value;
    public Pathfinding(PathfindingEnum value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public PathfindingEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pathfinding pathfinding = (Pathfinding) o;
        return Objects.equals(value, pathfinding.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
