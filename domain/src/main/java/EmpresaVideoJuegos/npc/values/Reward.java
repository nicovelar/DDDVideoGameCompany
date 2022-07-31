package EmpresaVideoJuegos.npc.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Reward implements ValueObject<RewardEnum> {
    private final RewardEnum value;
    public Reward(RewardEnum value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public RewardEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Reward reward = (Reward) o;
        return Objects.equals(value, reward.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
