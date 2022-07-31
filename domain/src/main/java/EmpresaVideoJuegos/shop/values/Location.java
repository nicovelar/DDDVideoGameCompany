package EmpresaVideoJuegos.shop.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Location implements ValueObject<String> {
    private final String value;
    public Location(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El lugar no puede estar en blanco");
        }
        if(this.value.length() > 200){
            throw new IllegalArgumentException("El lugar no permite mas de 200 caracteres");
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
        Location location = (Location) o;
        return Objects.equals(value, location.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}