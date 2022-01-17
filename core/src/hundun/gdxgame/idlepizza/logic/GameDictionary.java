package hundun.gdxgame.idlepizza.logic;

import hundun.gdxgame.idleframe.util.IGameDictionary;

/**
 * @author hundun
 * Created on 2021/11/22
 */
public class GameDictionary implements IGameDictionary {

    
    public String constructionIdToShowName(String constructionId) {
        switch (constructionId) {
            case ConstructionId.DOUGH_PROVIDER:
                return "DOUGH_PROVIDER";
            case ConstructionId.CHESS_PROVIDER:
                return "CHESS_PROVIDER";
            case ConstructionId.HAM_PROVIDER:
                return "HAM_PROVIDER";
            case ConstructionId.SPICE_PROVIDER:
                return "SPICE_PROVIDER";
            case ConstructionId.TOMATO_PROVIDER:
                return "TOMATO_PROVIDER";      
                
            case ConstructionId.CLASSICAL_PIZZA_MAKER:
                return "CLASSICAL_PIZZA";
            case ConstructionId.DOUBLE_PIZZA_MAKER:
                return "DOUBLE_PIZZA";
            case ConstructionId.SPICE_PIZZA_MAKER:
                return "SPICE_PIZZA";
            case ConstructionId.TOMATO_PIZZA_MAKER:
                return "TOMATO_PIZZA";
            case ConstructionId.SUPER_PIZZA_MAKER:
                return "SUPER_PIZZA";    
                
            case ConstructionId.WIN_THE_GAME:
                return "win goal";

    
            default:
                return "[dic:" + constructionId + "]";
        }
    }
}
