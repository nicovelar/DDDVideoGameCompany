package EmpresaVideoJuegos.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Slots implements ValueObject<Integer> {
    private final Integer value;
    public Slots(Integer value) {
        this.value = Integer.valueOf(value);
        if(this.value == null){
            throw new IllegalArgumentException("Los slots no pueden estar en blanco");
        }
        if(this.value < 0){
            throw new IllegalArgumentException("Los slots no permiten valores negativos");
        }
    }
    @Override
    public Integer value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slots slots = (Slots) o;
        return Objects.equals(value, slots.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
