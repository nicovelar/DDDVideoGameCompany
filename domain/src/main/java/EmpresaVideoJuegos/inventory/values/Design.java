package EmpresaVideoJuegos.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Design implements ValueObject<DesignEnum> {
    private final DesignEnum value;
    public Design(DesignEnum value) { this.value = Objects.requireNonNull(value); }
    @Override
    public DesignEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Design design = (Design) o;
        return Objects.equals(value, design.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
