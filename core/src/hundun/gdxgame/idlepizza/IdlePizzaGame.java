package hundun.gdxgame.idlepizza;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hundun.gdxgame.idleframe.BaseIdleGame;
import hundun.gdxgame.idleframe.data.ChildGameConfig;
import hundun.gdxgame.idleframe.model.construction.BaseConstructionFactory;
import hundun.gdxgame.idlepizza.logic.BuiltinConstructionsLoader;
import hundun.gdxgame.idlepizza.logic.ConstructionId;
import hundun.gdxgame.idlepizza.logic.GameArea;
import hundun.gdxgame.idlepizza.logic.GameDictionary;
import hundun.gdxgame.idlepizza.logic.TextureManager;
import hundun.gdxgame.idlepizza.ui.screen.MenuScreen;
import hundun.gdxgame.idlepizza.ui.screen.PlayScreen;
import hundun.gdxgame.idlepizza.ui.screen.ScreenContext;
import lombok.Getter;

public class IdlePizzaGame extends BaseIdleGame {

    @Getter
    private TextureManager textureManager;
    
    @Getter
    private ScreenContext screenContext;
    
    @Getter
    private GameDictionary gameDictionary;
    
    ;
    
    public IdlePizzaGame() {
        super(640, 480);
        drawGameImageAndPlayAudio = true;
    }
    
    @Override
    protected ChildGameConfig getChildGameConfig() {
        return new IdlePizzaGameConfig(this);
    }
    
    @Override
    public void create () {
        super.create();
       
        setScreen(screenContext.getMenuScreen());
        getAudioPlayManager().intoScreen(MenuScreen.class.getSimpleName());
    }
    
    @Override
    protected void initContexts() {
        super.initContexts();
        
        this.gameDictionary = new GameDictionary();
        this.textureManager = new TextureManager();
        
        this.screenContext = new ScreenContext();
        screenContext.setMenuScreen(new MenuScreen(this));
        screenContext.setGameBeeScreen(new PlayScreen(this));
    }
    
}
