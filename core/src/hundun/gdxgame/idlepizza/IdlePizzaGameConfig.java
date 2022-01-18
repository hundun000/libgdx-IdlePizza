package hundun.gdxgame.idlepizza;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Gdx;

import hundun.gdxgame.idleframe.data.ChildGameConfig;
import hundun.gdxgame.idlepizza.logic.BuiltinConstructionsLoader;
import hundun.gdxgame.idlepizza.logic.ConstructionId;
import hundun.gdxgame.idlepizza.logic.GameArea;
import hundun.gdxgame.idlepizza.logic.ResourceType;
import hundun.gdxgame.idlepizza.ui.screen.MenuScreen;
import hundun.gdxgame.idlestarter.ConstructionsFileLoader;

/**
 * @author hundun
 * Created on 2022/01/11
 */
public class IdlePizzaGameConfig extends ChildGameConfig {
    
    public IdlePizzaGameConfig(IdlePizzaGame game) {
//        File configFile = Gdx.files.internal("constructions.json").file();
//        ConstructionsFileLoader constructionsLoader = new ConstructionsFileLoader(game, game.getGameDictionary(), configFile);
        BuiltinConstructionsLoader builtinConstructionsLoader = new BuiltinConstructionsLoader(game);
        this.setConstructions(builtinConstructionsLoader.load());
        
        Map<String, List<String>> areaShownConstructionIds = new HashMap<>(); 
        areaShownConstructionIds.put(GameArea.PROVODERS, Arrays.asList(
            ConstructionId.DOUGH_PROVIDER,
            ConstructionId.CHESS_PROVIDER,
            ConstructionId.HAM_PROVIDER,
            ConstructionId.SPICE_PROVIDER,
            ConstructionId.TOMATO_PROVIDER
        ));
        areaShownConstructionIds.put(GameArea.MAKERS, Arrays.asList(
            ConstructionId.CLASSICAL_PIZZA_MAKER,
            ConstructionId.DOUBLE_PIZZA_MAKER,
            ConstructionId.SPICE_PIZZA_MAKER,
            ConstructionId.TOMATO_PIZZA_MAKER,
            ConstructionId.SUPER_PIZZA_MAKER
        ));
        areaShownConstructionIds.put(GameArea.WIN, Arrays.asList(
                ConstructionId.WIN_THE_GAME
        ));
        this.setAreaControlableConstructionIds(areaShownConstructionIds);
        this.setAreaShowEntityConstructionIds(areaShownConstructionIds);
        
        Map<String, List<String>> areaShownResourceIds = new HashMap<>(); 
        this.setAreaShowEntityResourceIds(areaShownResourceIds);
        
        Map<String, Integer> constructionStarterLevelMap = Map.of(
                ConstructionId.DOUGH_PROVIDER, 1,
                ConstructionId.CHESS_PROVIDER, 1,
                ConstructionId.HAM_PROVIDER, 1,
                ConstructionId.CLASSICAL_PIZZA_MAKER, 1
                );
        this.setConstructionStarterLevelMap(constructionStarterLevelMap);
        
        var constructionStarterWorkingLevelMap = Map.of(
                ConstructionId.DOUGH_PROVIDER, true,
                ConstructionId.CHESS_PROVIDER, true,
                ConstructionId.HAM_PROVIDER, true,
                ConstructionId.CLASSICAL_PIZZA_MAKER, false
                );
        this.setConstructionStarterWorkingLevelMap(constructionStarterWorkingLevelMap);
        
        var screenIdToFilePathMap = Map.of(
                MenuScreen.class.getSimpleName(), "audio/100116happybgm.ogg"
                );
        this.setScreenIdToFilePathMap(screenIdToFilePathMap);
    }
}
