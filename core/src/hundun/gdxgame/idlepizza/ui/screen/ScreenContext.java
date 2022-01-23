package hundun.gdxgame.idlepizza.ui.screen;

import hundun.gdxgame.idlepizza.IdlePizzaGame;
import hundun.gdxgame.idlestarter.ui.screen.menu.MenuScreen;
import lombok.Data;

/**
 * @author hundun
 * Created on 2021/11/02
 */
@Data
public class ScreenContext {
    MenuScreen<IdlePizzaGame> menuScreen;
    PlayScreen gameBeeScreen;
}
