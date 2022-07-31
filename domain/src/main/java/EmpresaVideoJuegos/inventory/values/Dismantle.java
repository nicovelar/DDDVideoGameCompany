package EmpresaVideoJuegos.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Dismantle implements ValueObject<DismantleEnum> {
    private final DismantleEnum value;
    public Dismantle(DismantleEnum value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public DismantleEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Dismantle dismantle = (Dismantle) o;
        return Objects.equals(value, dismantle.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
