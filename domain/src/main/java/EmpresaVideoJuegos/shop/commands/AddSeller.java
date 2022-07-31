package EmpresaVideoJuegos.shop.commands;
import co.com.sofka.domain.generic.Command;
import EmpresaVideoJuegos.shop.values.Dialogues;
import EmpresaVideoJuegos.shop.values.ShopID;
public class AddSeller extends Command {
    private final ShopID shopID;
    private final Dialogues dialogues;
    public AddSeller(ShopID shopID, Dialogues dialogues) {
        this.shopID = shopID;
        this.dialogues = dialogues;
    }
    public ShopID getShopID() {return shopID;}
    public Dialogues getDialogues() {return dialogues;}
}
