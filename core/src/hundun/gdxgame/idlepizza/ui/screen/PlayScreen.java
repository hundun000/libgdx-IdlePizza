package hundun.gdxgame.idlepizza.ui.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hundun.gdxgame.idleframe.model.AchievementPrototype;
import hundun.gdxgame.idleframe.model.construction.base.BaseConstruction;
import hundun.gdxgame.idlepizza.IdlePizzaGame;
import hundun.gdxgame.idlepizza.logic.GameArea;
import hundun.gdxgame.idlepizza.ui.component.AchievementMaskBoard;
import hundun.gdxgame.idlepizza.ui.component.BackgroundImageBox;
import hundun.gdxgame.idlepizza.ui.component.ConstructionControlBoard;
import hundun.gdxgame.idlepizza.ui.component.GameAreaControlBoard;
import hundun.gdxgame.idlepizza.ui.component.PopupInfoBoard;
import hundun.gdxgame.idlepizza.ui.component.StorageInfoBoard;
import hundun.gdxgame.idlepizza.ui.image.GameEntityFactory;
import hundun.gdxgame.idlestarter.BasePlayScreen;
import hundun.gdxgame.idlestarter.GameImageDrawHelper;

/**
 * @author hundun
 * Created on 2021/11/02
 */
public class PlayScreen extends BasePlayScreen<IdlePizzaGame> {

    private StorageInfoBoard storageInfoTable;
    private ConstructionControlBoard constructionControlBoard;
    private BackgroundImageBox backgroundImageBox;

    private PopupInfoBoard popUpInfoBoard;
    private GameAreaControlBoard gameAreaControlBoard;
    private AchievementMaskBoard achievementMaskBoard;
    private GameImageDrawHelper<IdlePizzaGame> gameImageDrawHelper;

    Table uiRootTable;
    Table popupRootTable;
    Stage popupUiStage;
    private Stage backUiStage;
    
    public PlayScreen(IdlePizzaGame game) {
        super(game);
        popupUiStage = new Stage(new FitViewport(game.LOGIC_WIDTH, game.LOGIC_HEIGHT, uiStage.getCamera()));
        backUiStage = new Stage(new FitViewport(game.LOGIC_WIDTH, game.LOGIC_HEIGHT, uiStage.getCamera()));
        
    }
    
    private void initLogicChildren() {
        
        gameImageDrawHelper = new GameImageDrawHelper<IdlePizzaGame>(this, uiStage.getCamera(), new GameEntityFactory(game));
        
        
        logicFrameListeners.add(constructionControlBoard);
        
        gameAreaChangeListeners.add(backgroundImageBox);
        gameAreaChangeListeners.add(constructionControlBoard);
        gameAreaChangeListeners.add(gameAreaControlBoard);
    }

    private void initUiRoot() {
        uiRootTable = new Table();
        uiRootTable.setFillParent(true);
        uiStage.addActor(uiRootTable);
        
        
        storageInfoTable = new StorageInfoBoard(this);
        uiRootTable.add(storageInfoTable).height(storageInfoTable.BOARD_BORDER_HEIGHT).row();
        
        gameAreaControlBoard = new GameAreaControlBoard(this, GameArea.values);
        uiRootTable.add(gameAreaControlBoard).expand().right().row();

        constructionControlBoard = new ConstructionControlBoard(this);
        uiRootTable.add(constructionControlBoard).height(constructionControlBoard.BOARD_BORDER_HEIGHT);
        
        //uiRootTable.debugCell();
    }
    
    private void initBackUiAndPopupUi() {
        
        this.backgroundImageBox = new BackgroundImageBox(this);
        backUiStage.addActor(backgroundImageBox);
        
        popupRootTable = new Table();
        popupRootTable.setFillParent(true);
        //popupRootTable.debug();
        popupUiStage.addActor(popupRootTable);
        
        popUpInfoBoard = new PopupInfoBoard(this);
        popupRootTable.add(popUpInfoBoard).bottom().expand().row();
        // empty image for hold the space
        popupRootTable.add(new Image()).height(game.LOGIC_HEIGHT / 2);
        
        achievementMaskBoard = new AchievementMaskBoard(this);
        popupUiStage.addActor(achievementMaskBoard);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(uiStage);
        game.getBatch().setProjectionMatrix(uiStage.getViewport().getCamera().combined);
        
        initBackUiAndPopupUi();
        initUiRoot();
        initLogicChildren();
        
        // start area
        setAreaAndNotifyChildren(GameArea.PROVODERS);
    }
    
    
    

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        logicFrameCheck(delta);
        
        uiStage.act();
        
        // ====== be careful of draw order ======
        backUiStage.draw();
        if (game.drawGameImageAndPlayAudio) {
            gameImageDrawHelper.drawAll();
        }
        uiStage.draw();
        popupUiStage.draw();
    }



    public void showAndUpdateGuideInfo(BaseConstruction model) {
        popUpInfoBoard.setVisible(true);
        popUpInfoBoard.update(model);
    }
    
    public void hideAndCleanGuideInfo() {
        popUpInfoBoard.setVisible(false);
        //popUpInfoBoard.setText("GUIDE_TEXT");
    }

    @Override
    public void dispose() {
        
    }

    public void hideAchievementMaskBoard() {
        achievementMaskBoard.setVisible(false);
        setLogicFramePause(false);
    }

    public void onAchievementUnlock(AchievementPrototype prototype) {
        achievementMaskBoard.setAchievementPrototype(prototype);
        achievementMaskBoard.setVisible(true);
        setLogicFramePause(true);
    }

}
