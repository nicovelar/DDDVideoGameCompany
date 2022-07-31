package EmpresaVideoJuegos.shop.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Furniture implements ValueObject<FurnitureEnum> {
    private final FurnitureEnum value;
    public Furniture(FurnitureEnum value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public FurnitureEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Objects.equals(value, furniture.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
