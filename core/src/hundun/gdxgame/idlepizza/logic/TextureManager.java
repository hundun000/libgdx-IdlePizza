package hundun.gdxgame.idlepizza.logic;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import lombok.Getter;

public class TextureManager {
    private Texture winAreaBackgroundTexture;
    private Texture providersAreaBackgroundTexture;
    private Texture makersAreaBackgroundTexture;
    @Getter
    private Texture winTexture;
    @Getter
    private Texture menuTexture;
    private Map<String, TextureRegion> itemRegionMap = new HashMap<>();
    private Map<String, TextureRegion> constructionRegionMap = new HashMap<>();
    private Map<String, TextureRegion> gameAreaLeftPartRegionMap = new HashMap<>();
    private Map<String, TextureRegion> gameAreaRightPartRegionMap = new HashMap<>();
    @Getter
    private Texture beeTexture;
    TextureRegion defaultIcon;
    
    public TextureManager() {
        winAreaBackgroundTexture = new Texture(Gdx.files.internal("win-area.png"));
        providersAreaBackgroundTexture = new Texture(Gdx.files.internal("providers-area.png"));
        makersAreaBackgroundTexture = new Texture(Gdx.files.internal("makers-area.png"));
        winTexture = new Texture(Gdx.files.internal("win.png"));
        menuTexture = new Texture(Gdx.files.internal("menu.png"));
        
        {
            Texture texture = new Texture(Gdx.files.internal("item.png"));
            TextureRegion[][] regions = TextureRegion.split(texture, 16, 16);
            defaultIcon = regions[0][0];
            itemRegionMap.put(ResourceType.COIN, regions[0][1]);
            itemRegionMap.put(ResourceType.DOUGH, regions[0][2]);
            itemRegionMap.put(ResourceType.CHESS, regions[0][3]);
            itemRegionMap.put(ResourceType.SPICE, regions[0][4]);
            itemRegionMap.put(ResourceType.TOMATO, regions[0][5]);
            itemRegionMap.put(ResourceType.HAM, regions[0][6]);
        }
        
        {
            Texture texture = new Texture(Gdx.files.internal("construction2.png"));
            TextureRegion[][] regions = TextureRegion.split(texture, 24, 32);
            constructionRegionMap.put(ConstructionId.DOUGH_PROVIDER, regions[0][0]);
            constructionRegionMap.put(ConstructionId.CHESS_PROVIDER, regions[0][1]);
            constructionRegionMap.put(ConstructionId.SPICE_PROVIDER, regions[0][2]);
            constructionRegionMap.put(ConstructionId.TOMATO_PROVIDER, regions[0][3]);
            constructionRegionMap.put(ConstructionId.HAM_PROVIDER, regions[0][4]);
        }
        
        {
            Texture texture = new Texture(Gdx.files.internal("construction1.png"));
            TextureRegion[][] regions = TextureRegion.split(texture, 16, 32);
            constructionRegionMap.put(ConstructionId.CLASSICAL_PIZZA_MAKER, regions[0][0]);
            constructionRegionMap.put(ConstructionId.DOUBLE_PIZZA_MAKER, regions[0][1]);
            constructionRegionMap.put(ConstructionId.TOMATO_PIZZA_MAKER, regions[0][2]);
            constructionRegionMap.put(ConstructionId.SPICE_PIZZA_MAKER, regions[0][3]);
            constructionRegionMap.put(ConstructionId.SUPER_PIZZA_MAKER, regions[0][4]);
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
        
    }
    
    public Texture getBackgroundTexture(String gameArea) {
        switch (gameArea) {
            case GameArea.PROVODERS:
                return providersAreaBackgroundTexture;
            case GameArea.MAKERS:
                return makersAreaBackgroundTexture;
            default:
                return winAreaBackgroundTexture;
        }
    }
    
    public TextureRegion getResourceIcon(String resourceType) {
        return itemRegionMap.getOrDefault(resourceType, defaultIcon);
    }
    
    public TextureRegion getConstructionTexture(String constructionId) {
        return constructionRegionMap.getOrDefault(constructionId, defaultIcon);
    }
    
    public TextureRegion getGameAreaTexture(String key, boolean longVersion) {
        if (longVersion) {
            return gameAreaLeftPartRegionMap.getOrDefault(key, defaultIcon);
        } else {
            return gameAreaRightPartRegionMap.getOrDefault(key, defaultIcon);
        }
        
    }
}
