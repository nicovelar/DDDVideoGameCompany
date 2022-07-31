package EmpresaVideoJuegos.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Crafting implements ValueObject<CraftingEnum> {
    private final CraftingEnum value;
    public Crafting(CraftingEnum value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public CraftingEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crafting crafting = (Crafting) o;
        return Objects.equals(value, crafting.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
