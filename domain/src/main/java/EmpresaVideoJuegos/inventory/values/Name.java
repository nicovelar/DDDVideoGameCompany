package EmpresaVideoJuegos.inventory.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Name implements ValueObject<String> {
    private final String value;
    public Name(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }
        if(this.value.length() > 200){
            throw new IllegalArgumentException("El nombre no permite mas de 200 caracteres");
        }
    }
    @Override
    public String value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
