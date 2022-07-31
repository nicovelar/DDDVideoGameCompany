package EmpresaVideoJuegos.shop.events;
import co.com.sofka.domain.generic.DomainEvent;
import EmpresaVideoJuegos.shop.values.Dialogues;
import EmpresaVideoJuegos.shop.values.NPCID;
public class SellerAdded extends DomainEvent {
    private final NPCID npcid;
    private final Dialogues dialogues;
    public SellerAdded(NPCID npcid, Dialogues dialogues) {
        super("EmpresaVideoJuegos.shop.selleradded");
        this.npcid = npcid;
        this.dialogues = dialogues;
    }
    public NPCID getNpcid() {return npcid;}
    public Dialogues getDialogues() {return dialogues;}
}
