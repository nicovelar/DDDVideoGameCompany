package EmpresaVideoJuegos.npc.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.npc.values.AnimationID;
import EmpresaVideoJuegos.npc.values.Jump;
import EmpresaVideoJuegos.npc.values.Run;
import EmpresaVideoJuegos.npc.values.Walk;
public class AnimationAdded extends DomainEvent {
    private final AnimationID animationID;
    private final Walk walk;
    private final Run run;
    private final Jump jump;
    public AnimationAdded(AnimationID animationID, Walk walk, Run run, Jump jump) {
        super("EmpresaVideoJuegos.npc.animationadded");
        this.animationID = animationID;
        this.walk = walk;
        this.run = run;
        this.jump = jump;
    }
    public AnimationID getAnimationID() {return animationID;}
    public Walk getWalk() {return walk;}
    public Run getRun() {return run;}
    public Jump getJump() {return jump;}
}
