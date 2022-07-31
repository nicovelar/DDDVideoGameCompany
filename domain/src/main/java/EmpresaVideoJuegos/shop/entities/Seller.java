package EmpresaVideoJuegos.shop.entities;

import co.com.sofka.domain.generic.Entity;
import EmpresaVideoJuegos.shop.values.Dialogues;
import EmpresaVideoJuegos.shop.values.NPCID;


public class Seller extends Entity<NPCID> {
    private Dialogues dialogues;
    public Seller(NPCID npcid, Dialogues dialogues) {
        super(npcid);
        this.dialogues = dialogues;
    }
    public Dialogues getDialogues() {return dialogues;}
    public void selectDialogues(Dialogues dialogues) { this.dialogues = dialogues; }
}
