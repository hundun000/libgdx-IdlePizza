package hundun.gdxgame.idlepizza.ui.screen;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import hundun.gdxgame.idlepizza.IdlePizzaGame;
import hundun.gdxgame.idlepizza.logic.GameArea;
import hundun.gdxgame.idlepizza.logic.ResourceType;
import hundun.gdxgame.idlepizza.logic.ScreenId;
import hundun.gdxgame.idlepizza.ui.image.GameEntityFactory;
import hundun.gdxgame.idleshare.starter.ui.component.AchievementMaskBoard;
import hundun.gdxgame.idleshare.starter.ui.component.BackgroundImageBox;
import hundun.gdxgame.idleshare.starter.ui.component.GameAreaControlBoard;
import hundun.gdxgame.idleshare.starter.ui.component.GameImageDrawer;
import hundun.gdxgame.idleshare.starter.ui.component.PopupInfoBoard;
import hundun.gdxgame.idleshare.starter.ui.component.StorageInfoBoard;
import hundun.gdxgame.idleshare.starter.ui.component.board.construction.impl.fixed.FixedConstructionControlBoard;
import hundun.gdxgame.idleshare.starter.ui.screen.play.BasePlayScreen;
import hundun.gdxgame.idleshare.starter.ui.screen.play.PlayScreenLayoutConst;


/**
 * @author hundun
 * Created on 2021/11/02
 */
public class PlayScreen extends BasePlayScreen<IdlePizzaGame> {


    public PlayScreen(IdlePizzaGame game) {
        super(game, ScreenId.PLAY, GameArea.PROVODERS, new PlayScreenLayoutConst(game.LOGIC_WIDTH, game.LOGIC_HEIGHT));

    }


    @Override
    public void dispose() {

    }

    @Override
    protected void lazyInitLogicContext() {
        GameEntityFactory gameEntityFactory = new GameEntityFactory(this.layoutConst, this);
        gameImageDrawer = new GameImageDrawer<>(this, gameEntityFactory);


        logicFrameListeners.add(constructionControlBoard);

        gameAreaChangeListeners.add(backgroundImageBox);
        gameAreaChangeListeners.add(constructionControlBoard);
        gameAreaChangeListeners.add(gameAreaControlBoard);
    }

    @Override
    protected void lazyInitUiRootContext() {
        storageInfoTable = new StorageInfoBoard<>(this);
        storageInfoTable.lazyInit(ResourceType.VALUES_FOR_SHOW_ORDER);
        uiRootTable.add(storageInfoTable).height(layoutConst.STORAGE_BOARD_BORDER_HEIGHT).row();

        gameAreaControlBoard = new GameAreaControlBoard<>(this, GameArea.values);
        uiRootTable.add(gameAreaControlBoard).expand().right().row();

        constructionControlBoard = new FixedConstructionControlBoard(this);
        uiRootTable.add(constructionControlBoard).height(layoutConst.CONSTRUCION_BOARD_BORDER_HEIGHT);

        //uiRootTable.debugCell();
    }

    @Override
    protected void lazyInitBackUiAndPopupUiContent() {
        this.backgroundImageBox = new BackgroundImageBox<>(this);
        backUiStage.addActor(backgroundImageBox);

        popUpInfoBoard = new PopupInfoBoard<>(this);
        popupRootTable.add(popUpInfoBoard).bottom().expand().row();
        // empty image for hold the space
        popupRootTable.add(new Image()).height(game.LOGIC_HEIGHT / 2);

        achievementMaskBoard = new AchievementMaskBoard<>(this);
        popupUiStage.addActor(achievementMaskBoard);
    }



}
