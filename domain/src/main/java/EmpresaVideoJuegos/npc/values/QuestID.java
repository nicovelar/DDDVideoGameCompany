package EmpresaVideoJuegos.npc.values;
import co.com.sofka.domain.generic.Identity;
public class QuestID extends Identity {
    public QuestID() {
    }
    private QuestID(String id) {
        super(id);
    }
    public static QuestID of(String id) {
        return new QuestID(id);
    }
}
