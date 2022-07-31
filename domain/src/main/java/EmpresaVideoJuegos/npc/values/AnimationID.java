package EmpresaVideoJuegos.npc.values;
import co.com.sofka.domain.generic.Identity;
public class AnimationID extends Identity {
    public AnimationID() {
    }
    private AnimationID(String id) {
        super(id);
    }
    public static AnimationID of(String id) {
        return new AnimationID(id);
    }
}
