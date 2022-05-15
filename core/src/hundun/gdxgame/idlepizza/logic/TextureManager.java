package hundun.gdxgame.idlepizza.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import hundun.gdxgame.idleshare.framework.model.manager.AbstractTextureManager;

public class TextureManager extends AbstractTextureManager {


    public TextureManager() {
        winTexture = new Texture(Gdx.files.internal("win.png"));
        menuTexture = new Texture(Gdx.files.internal("menu.png"));

        {
            Texture texture = new Texture(Gdx.files.internal("item.png"));
            TextureRegion[][] regions = TextureRegion.split(texture, 16, 16);
            defaultIcon = regions[0][0];
            resourceIconMap.put(ResourceType.COIN, regions[0][1]);
            resourceIconMap.put(ResourceType.DOUGH, regions[0][2]);
            resourceIconMap.put(ResourceType.CHESS, regions[0][3]);
            resourceIconMap.put(ResourceType.SPICE, regions[0][4]);
            resourceIconMap.put(ResourceType.TOMATO, regions[0][5]);
            resourceIconMap.put(ResourceType.HAM, regions[0][6]);
            resourceIconMap.put(ResourceType.WIN_TROPHY, regions[0][8]);
        }

        {
            Texture texture = new Texture(Gdx.files.internal("construction2.png"));
            TextureRegion[][] regions = TextureRegion.split(texture, 32, 32);
            constructionEntityMap.put(ConstructionId.DOUGH_PROVIDER, regions[0][0]);
            constructionEntityMap.put(ConstructionId.CHESS_PROVIDER, regions[0][1]);
            constructionEntityMap.put(ConstructionId.SPICE_PROVIDER, regions[0][2]);
            constructionEntityMap.put(ConstructionId.TOMATO_PROVIDER, regions[0][3]);
            constructionEntityMap.put(ConstructionId.HAM_PROVIDER, regions[0][4]);
        }

        {
            Texture texture = new Texture(Gdx.files.internal("construction1.png"));
            TextureRegion[][] regions = TextureRegion.split(texture, 32, 32);
            constructionEntityMap.put(ConstructionId.CLASSICAL_PIZZA_MAKER, regions[0][0]);
            constructionEntityMap.put(ConstructionId.DOUBLE_PIZZA_MAKER, regions[0][3]);
            constructionEntityMap.put(ConstructionId.TOMATO_PIZZA_MAKER, regions[0][1]);
            constructionEntityMap.put(ConstructionId.SPICE_PIZZA_MAKER, regions[0][2]);
            constructionEntityMap.put(ConstructionId.SUPER_PIZZA_MAKER, regions[0][4]);
        }
        {
            Texture texture = new Texture(Gdx.files.internal("gameAreaIcons.png"));
            TextureRegion[][] regions = TextureRegion.split(texture, 100, 50);
            gameAreaLeftPartRegionMap.put(GameArea.PROVODERS, regions[0][0]);
            gameAreaLeftPartRegionMap.put(GameArea.MAKERS, regions[1][0]);
            gameAreaLeftPartRegionMap.put(GameArea.WIN, regions[2][0]);
            gameAreaRightPartRegionMap.put(GameArea.PROVODERS, regions[0][1]);
            gameAreaRightPartRegionMap.put(GameArea.MAKERS, regions[1][1]);
            gameAreaRightPartRegionMap.put(GameArea.WIN, regions[2][1]);
        }
        {
            // FIXME
            Texture texture = new Texture(Gdx.files.internal("areas.png"));
            TextureRegion[][] regions = TextureRegion.split(texture, 640, 480);
            defaultAreaBack = regions[0][0];
            gameAreaBackMap.put(GameArea.PROVODERS, regions[0][1]);
            gameAreaBackMap.put(GameArea.MAKERS, regions[0][2]);
            gameAreaBackMap.put(GameArea.WIN, regions[0][3]);
        }
    }


}
