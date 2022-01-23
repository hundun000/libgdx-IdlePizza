package hundun.gdxgame.idlepizza.ui.image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import hundun.gdxgame.idleframe.model.entity.BaseGameEntityFactory;
import hundun.gdxgame.idleframe.model.entity.GameEntity;

import hundun.gdxgame.idleframe.model.entity.RandomMoveEntity;
import hundun.gdxgame.idlepizza.IdlePizzaGame;
import hundun.gdxgame.idlepizza.logic.ConstructionId;
import hundun.gdxgame.idlepizza.logic.ResourceType;
import hundun.gdxgame.idlestarter.ui.screen.play.BasePlayScreen;
import hundun.gdxgame.idlestarter.ui.screen.play.PlayScreenLayoutConst;


/**
 * @author hundun
 * Created on 2021/11/26
 */
public class GameEntityFactory extends BaseGameEntityFactory {
    
    public float FLY_UNION_SPEED = 2;

    public float RESOURCE_MAX_DRAW_NUM = 5;
    
    ResourceType type;
    int baseX;
    int baseY;
    //TextureRegion textureRegion;
    
    //private Texture beeTexture;
    //private Texture beehiveTexture;
    
    IdlePizzaGame game;
    
    public GameEntityFactory(PlayScreenLayoutConst layoutConst, BasePlayScreen<IdlePizzaGame> parent) {
        super(layoutConst, parent);

    }
    
    public GameEntity newConstructionEntity(String id, int index) {
        switch (id) {
            case ConstructionId.CLASSICAL_PIZZA_MAKER:
            case ConstructionId.DOUGH_PROVIDER:
                return this.columnStableConstructionEntity(id, index, 0);
            case ConstructionId.DOUBLE_PIZZA_MAKER:
            case ConstructionId.CHESS_PROVIDER:
                return this.columnStableConstructionEntity(id, index, 1); 
            case ConstructionId.SPICE_PIZZA_MAKER:
            case ConstructionId.HAM_PROVIDER:
                return this.columnStableConstructionEntity(id, index, 2);
            case ConstructionId.TOMATO_PIZZA_MAKER:
            case ConstructionId.SPICE_PROVIDER:
                return this.columnStableConstructionEntity(id, index, 3);
            case ConstructionId.SUPER_PIZZA_MAKER:
            case ConstructionId.TOMATO_PROVIDER:
                return this.columnStableConstructionEntity(id, index, 4);
            default:
                return null;
                //throw new UnsupportedOperationException("fail newConstructionEntity for id = " + id);
        }
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
