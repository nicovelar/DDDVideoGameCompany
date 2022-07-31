package EmpresaVideoJuegos.shop.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Price implements ValueObject<Integer> {
    private final Integer value;
    public Price(Integer value) {
        this.value = Integer.valueOf(value);
        if(this.value == null){
            throw new IllegalArgumentException("El precio no puede estar en blanco");
        }
        if(this.value < 0){
            throw new IllegalArgumentException("El precip no puede ser un valor negativo");
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
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
