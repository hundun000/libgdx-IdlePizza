package hundun.gdxgame.idlepizza;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


import hundun.gdxgame.idleframe.BaseIdleGame;
import hundun.gdxgame.idleframe.data.ChildGameConfig;
import hundun.gdxgame.idleframe.model.AchievementPrototype;
import hundun.gdxgame.idleframe.model.construction.BaseConstructionFactory;
import hundun.gdxgame.idlepizza.logic.BuiltinConstructionsLoader;
import hundun.gdxgame.idlepizza.logic.ConstructionId;
import hundun.gdxgame.idlepizza.logic.GameArea;
import hundun.gdxgame.idlepizza.logic.GameDictionary;
import hundun.gdxgame.idlepizza.logic.TextureManager;
import hundun.gdxgame.idlepizza.logic.ResourceType;
import hundun.gdxgame.idlepizza.logic.ScreenId;
import hundun.gdxgame.idlepizza.ui.screen.PlayScreen;
import hundun.gdxgame.idlepizza.ui.screen.ScreenContext;
import hundun.gdxgame.idlestarter.ui.screen.menu.MenuScreen;
import lombok.Getter;

public class IdlePizzaGame extends BaseIdleGame {

    
    @Getter
    private ScreenContext screenContext;
    
    
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
        // FIXME
        getModelContext().getAchievementManager().addPrototype(
                new AchievementPrototype("Game win", "You win the game!",
                null,
                Map.of(ResourceType.WIN_TROPHY, 1)
                ));
        
        setScreen(screenContext.getMenuScreen());
        getAudioPlayManager().intoScreen(MenuScreen.class.getSimpleName());
    }
    
    @Override
    protected void initContexts() {
        super.initContexts();
        
        this.gameDictionary = new GameDictionary();
        this.textureManager = new TextureManager();
        
        this.screenContext = new ScreenContext();
        screenContext.setMenuScreen(new MenuScreen<>(
                this,
                new InputListener(){
                    @Override
                    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                        IdlePizzaGame.this.loadAndHookSave(true);
                        IdlePizzaGame.this.setScreen(IdlePizzaGame.this.getScreenContext().getGameBeeScreen());
                        IdlePizzaGame.this.getAudioPlayManager().intoScreen(ScreenId.PLAY);
                    }
                    @Override
                    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                },
                new InputListener(){
                    @Override
                    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                        IdlePizzaGame.this.loadAndHookSave(false);
                        IdlePizzaGame.this.setScreen(IdlePizzaGame.this.getScreenContext().getGameBeeScreen());
                        IdlePizzaGame.this.getAudioPlayManager().intoScreen(ScreenId.PLAY);
                    }
                    @Override
                    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                }
                ));
        screenContext.setGameBeeScreen(new PlayScreen(this));
    }

    @Override
    public List<String> getGameAreaValues() {
        return GameArea.values;
    }
    
    
    
}
