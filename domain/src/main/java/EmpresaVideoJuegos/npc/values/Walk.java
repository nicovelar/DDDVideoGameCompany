package EmpresaVideoJuegos.npc.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Walk implements ValueObject<Integer> {
    private final Integer value;
    public Walk(Integer value) {
        this.value = Integer.valueOf(value);
        if(this.value == null){
            throw new IllegalArgumentException("Caminar no puede estar en blanco");
        }
        if(this.value < 0){
            throw new IllegalArgumentException("Los frames no pueden ser valores negativos");
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
        Walk walk = (Walk) o;
        return Objects.equals(value, walk.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
