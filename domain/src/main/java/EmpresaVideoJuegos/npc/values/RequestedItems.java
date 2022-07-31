package EmpresaVideoJuegos.npc.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class RequestedItems implements ValueObject<RequestedItemsEnum> {
    private final RequestedItemsEnum value;
    public RequestedItems(RequestedItemsEnum value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public RequestedItemsEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestedItems requestedItems = (RequestedItems) o;
        return Objects.equals(value, requestedItems.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
