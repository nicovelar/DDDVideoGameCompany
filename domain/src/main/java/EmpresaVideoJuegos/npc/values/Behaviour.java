package EmpresaVideoJuegos.npc.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Behaviour implements ValueObject<BehaviourEnum> {
    private final BehaviourEnum value;
    public Behaviour(BehaviourEnum value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public BehaviourEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Behaviour behaviour = (Behaviour) o;
        return Objects.equals(value, behaviour.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
