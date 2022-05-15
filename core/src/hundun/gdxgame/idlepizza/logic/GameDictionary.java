package hundun.gdxgame.idlepizza.logic;

import hundun.gdxgame.idleshare.framework.util.text.IGameDictionary;

/**
 * @author hundun
 * Created on 2021/11/22
 */
public class GameDictionary implements IGameDictionary {


    @Override
    public String constructionIdToShowName(String constructionId) {
        switch (constructionId) {
            case ConstructionId.DOUGH_PROVIDER:
                return "dough provider";
            case ConstructionId.CHESS_PROVIDER:
                return "chess provider";
            case ConstructionId.HAM_PROVIDER:
                return "ham provider";
            case ConstructionId.SPICE_PROVIDER:
                return "spice provider";
            case ConstructionId.TOMATO_PROVIDER:
                return "tomato provider";

            case ConstructionId.CLASSICAL_PIZZA_MAKER:
                return "classical pizza oven";
            case ConstructionId.DOUBLE_PIZZA_MAKER:
                return "double pizza oven";
            case ConstructionId.SPICE_PIZZA_MAKER:
                return "spice pizza oven";
            case ConstructionId.TOMATO_PIZZA_MAKER:
                return "tomato pizza oven";
            case ConstructionId.SUPER_PIZZA_MAKER:
                return "super pizza oven";

            case ConstructionId.WIN_THE_GAME:
                return "win goal";


            default:
                return "[dic:" + constructionId + "]";
        }
    }
}
