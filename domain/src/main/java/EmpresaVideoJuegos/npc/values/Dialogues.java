package EmpresaVideoJuegos.npc.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class Dialogues implements ValueObject<DialoguesEnum> {
    private final DialoguesEnum value;
    public Dialogues(DialoguesEnum value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public DialoguesEnum value() {
        return this.value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dialogues dialogues = (Dialogues) o;
        return Objects.equals(value, dialogues.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
