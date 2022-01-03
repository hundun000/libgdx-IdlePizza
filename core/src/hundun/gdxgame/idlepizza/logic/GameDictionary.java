package hundun.gdxgame.idlepizza.logic;

import hundun.gdxgame.idleframe.util.IGameDictionary;

/**
 * @author hundun
 * Created on 2021/11/22
 */
public class GameDictionary implements IGameDictionary {

    
    public String constructionIdToShowName(String constructionId) {
        switch (constructionId) {
        

            case ConstructionId.WIN_THE_GAME:
                return "win goal";

    
            default:
                return "[dic:" + constructionId + "]";
        }
    }
}
