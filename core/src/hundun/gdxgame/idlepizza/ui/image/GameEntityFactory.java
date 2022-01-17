package hundun.gdxgame.idlepizza.ui.image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import hundun.gdxgame.idleframe.model.entity.GameEntity;
import hundun.gdxgame.idleframe.model.entity.IGameEntityFactory;
import hundun.gdxgame.idleframe.model.entity.RandomMoveEntity;
import hundun.gdxgame.idlepizza.IdlePizzaGame;
import hundun.gdxgame.idlepizza.logic.ConstructionId;
import hundun.gdxgame.idlepizza.logic.ResourceType;
import hundun.gdxgame.idlepizza.ui.component.GameAreaControlBoard;
import hundun.gdxgame.idlepizza.ui.component.StorageInfoBoard;

/**
 * @author hundun
 * Created on 2021/11/26
 */
public class GameEntityFactory implements IGameEntityFactory {
    public float FLY_MIN_X;
    public float FLY_MAX_X;
    public float FLY_MIN_Y;
    public float FLY_MAX_Y;
    
    public int TREE_MIN_X;
    public int TREE_MAX_X;
    public int TREE_MIN_Y;
    public int TREE_MAX_Y;
    
    public float FLY_UNION_SPEED = 2;

    public float RESOURCE_MAX_DRAW_NUM = 5;
    
    ResourceType type;
    int baseX;
    int baseY;
    //TextureRegion textureRegion;
    
    //private Texture beeTexture;
    //private Texture beehiveTexture;
    
    IdlePizzaGame game;
    
    public GameEntityFactory(IdlePizzaGame game) {
        this.game = game;
        
        FLY_MAX_X = Gdx.graphics.getWidth() - GameAreaControlBoard.WIDTH;
        FLY_MIN_X = BEE_WIDTH;
        FLY_MAX_Y = Gdx.graphics.getHeight() - (StorageInfoBoard.BOARD_HEIGHT + StorageInfoBoard.BOARD_DISTANCE_TO_FRAME_TOP);
        FLY_MIN_Y = FLY_MAX_Y - 200;
        
        TREE_MAX_X = Gdx.graphics.getWidth() - GameAreaControlBoard.WIDTH - scale * Construction_WIDTH;
        TREE_MIN_X = 0;
        TREE_MAX_Y = Gdx.graphics.getHeight() - (StorageInfoBoard.BOARD_HEIGHT + StorageInfoBoard.BOARD_DISTANCE_TO_FRAME_TOP) - scale * Construction_HEIGHT;
        TREE_MIN_Y = TREE_MAX_Y - 100;
        //this.beehiveTexture = new Texture(Gdx.files.internal("beehive.png"));
        Gdx.app.log(this.getClass().getSimpleName(), "TREE_MAX_Y = " + TREE_MAX_Y + ", TREE_MIN_Y = " + TREE_MIN_Y);
    }
    
    public GameEntity newConstructionEntity(String id, int index) {
        switch (id) {
            case ConstructionId.CLASSICAL_PIZZA_MAKER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 0 * ConstructionEntity_BASE_X_PAD - ConstructionEntity_X_PAD * index,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        false,
                        id);
            case ConstructionId.DOUGH_PROVIDER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 0 * ConstructionEntity_BASE_X_PAD - ConstructionEntity_X_PAD * index,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        true,
                        id);
            case ConstructionId.DOUBLE_PIZZA_MAKER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 1 * ConstructionEntity_BASE_X_PAD - ConstructionEntity_X_PAD * index,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        false,
                        id); 
            case ConstructionId.CHESS_PROVIDER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 1 * ConstructionEntity_BASE_X_PAD - ConstructionEntity_X_PAD * index,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        true,
                        id); 
            case ConstructionId.SPICE_PIZZA_MAKER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 2 * ConstructionEntity_BASE_X_PAD - ConstructionEntity_X_PAD * index,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        false,
                        id); 
            case ConstructionId.SPICE_PROVIDER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 2 * ConstructionEntity_BASE_X_PAD - ConstructionEntity_X_PAD * index,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        true,
                        id); 
            case ConstructionId.TOMATO_PIZZA_MAKER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 3 * ConstructionEntity_BASE_X_PAD,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        false,
                        id);
            case ConstructionId.TOMATO_PROVIDER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 3 * ConstructionEntity_BASE_X_PAD,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        true,
                        id); 
            case ConstructionId.SUPER_PIZZA_MAKER:
                return newConstructionEntity(
                        ConstructionEntity_BASE_X + 4 * ConstructionEntity_BASE_X_PAD,
                        ConstructionEntity_BASE_Y - ConstructionEntity_Y_PAD * index,
                        false,
                        id); 
            default:
                return null;
                //throw new UnsupportedOperationException("fail newConstructionEntity for id = " + id);
        }
    }
    static final int scale = 2;
    static final int BEE_WIDTH = 64;
    static final int BEE_HEIGHT = 64;
    static final int SELL_Construction_WIDTH = 48;
    static final int SELL_Construction_HEIGHT = 32;
    static final int Construction_WIDTH = 32;
    static final int Construction_HEIGHT = 64;
    static final int ConstructionEntity_BASE_X = 80;
    static final int ConstructionEntity_BASE_X_PAD = 90;
    static final int ConstructionEntity_BASE_Y = 250;
    static final int ConstructionEntity_X_PAD = 15;
    static final int ConstructionEntity_Y_PAD = 30;
    private GameEntity newConstructionEntity(int x, int y, boolean sizeType1, String constructionId) {
        return newConstructionEntity(x, y, 
                scale * (sizeType1 ? Construction_WIDTH : SELL_Construction_WIDTH), 
                scale * (sizeType1 ? SELL_Construction_HEIGHT : SELL_Construction_HEIGHT), 
                constructionId);
    }
    
    private GameEntity newConstructionEntity(int x, int y, int drawWidth, int drawHeight, String constructionId) {
        
        GameEntity entity = new GameEntity();
        entity.setTexture(new Sprite(game.getTextureManager().getConstructionTexture(constructionId)));
        entity.setX(x);
        entity.setY(y);
        entity.setDrawWidth(drawWidth);
        entity.setDrawHeight(drawHeight);
        entity.setRandomMove(false);
        return entity;
    }


    @Override
    public int calculateResourceDrawNum(String resourceId, long logicAmount) {
        return (int) Math.min(RESOURCE_MAX_DRAW_NUM, logicAmount);
    }

    @Override
    public int calculateConstructionDrawNum(String constructionid, long logicAmount, int max) {
        return (int) Math.min(max, logicAmount);
    }

    @Override
    public GameEntity newResourceEntity(String resourceId) {
        switch (resourceId) {
            default:
                return null;
        }
    }

    
    
}
