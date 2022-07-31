package EmpresaVideoJuegos.npc.entities;

import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.npc.values.AnimationID;
import EmpresaVideoJuegos.npc.values.Jump;
import EmpresaVideoJuegos.npc.values.Run;
import EmpresaVideoJuegos.npc.values.Walk;

import java.util.Objects;
public class Animation extends Entity<AnimationID> {
    private Walk walk;
    private Run run;
    private Jump jump;
    public Animation(AnimationID animationID,Walk walk, Run run, Jump jump) {
        super(animationID);
        this.walk = walk;
        this.run =run;
        this.jump =jump;
    }
    public Walk getWalk() {return walk;}
    public Run getRun() {return run;}
    public Jump getJump() {return jump;}
    public void putWalk (Walk walk) {
        this.walk = Objects.requireNonNull(walk);
    }
    public void putRun (Run run) {
        this.run = Objects.requireNonNull(run);
    }
    public void putJump (Jump jump) {
        this.jump = Objects.requireNonNull(jump);
    }
}