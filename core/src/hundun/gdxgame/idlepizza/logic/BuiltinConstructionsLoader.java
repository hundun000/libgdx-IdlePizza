package hundun.gdxgame.idlepizza.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hundun.gdxgame.idleframe.BaseIdleGame;
import hundun.gdxgame.idleframe.model.construction.BaseAutoConstruction;
import hundun.gdxgame.idleframe.model.construction.BaseClickGatherConstruction;

import hundun.gdxgame.idleframe.model.construction.BaseConstructionFactory;
import hundun.gdxgame.idleframe.model.construction.base.BaseConstruction;
import hundun.gdxgame.idleframe.model.construction.base.LevelComponent;
import hundun.gdxgame.idleframe.model.construction.base.OutputComponent;
import hundun.gdxgame.idleframe.model.construction.base.UpgradeComponent;
import hundun.gdxgame.idleframe.model.resource.ResourcePack;
import hundun.gdxgame.idleframe.model.resource.ResourcePair;
import hundun.gdxgame.idlepizza.IdlePizzaGame;

/**
 * @author hundun
 * Created on 2021/11/16
 */
public class BuiltinConstructionsLoader {
    IdlePizzaGame game;
    List<BaseConstruction> constructions = new ArrayList<>();
    
    public BuiltinConstructionsLoader(IdlePizzaGame game) {
        this.game = game;
        
    }
    
    public List<BaseConstruction> load() {
        initProviders();
        initMakers();
        initSpecials();
        return constructions;
    }
    
    private void initProviders() {
        // auto
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.DOUGH_PROVIDER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto gain some dough";
            construction.descriptionPackage = BaseConstruction.MAX_LEVEL_AUTO_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.DOUGH, 1
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 50
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, false);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        }
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.CHESS_PROVIDER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto gain some chess";
            construction.descriptionPackage = BaseConstruction.MAX_LEVEL_AUTO_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.CHESS, 1
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 10
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, false);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        }
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.HAM_PROVIDER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto gain some ham";
            construction.descriptionPackage = BaseConstruction.MAX_LEVEL_AUTO_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.HAM, 1
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 10
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, false);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        } 
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.SPICE_PROVIDER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto gain some spice";
            construction.descriptionPackage = BaseConstruction.MAX_LEVEL_AUTO_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.SPICE, 1
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 10
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, false);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        } 
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.TOMATO_PROVIDER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto gain some tomato";
            construction.descriptionPackage = BaseConstruction.MAX_LEVEL_AUTO_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.TOMATO, 1
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 10
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, false);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        } 
        
    }
    
    private ResourcePack toPack(Map<String, Integer> map) {
        ResourcePack pack = new ResourcePack();
        List<ResourcePair> pairs = new ArrayList<>(map.size());
        map.entrySet().forEach(entry -> pairs.add(new ResourcePair(entry.getKey(), (long)entry.getValue())));
        pack.setBaseValues(pairs);
        return pack;
    }
    
    private void initMakers() {
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.CLASSICAL_PIZZA_MAKER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto make and sell classical pizza(s)";
            construction.descriptionPackage = BaseConstruction.SELLING_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputCostPack(toPack(Map.of(
                    ResourceType.DOUGH, 1,
                    ResourceType.CHESS, 1,
                    ResourceType.HAM, 1
                    )));
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.COIN, 10
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 50
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, true);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        }
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.CLASSICAL_PIZZA_MAKER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto make and sell classical-pizza(s)";
            construction.descriptionPackage = BaseConstruction.SELLING_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputCostPack(toPack(Map.of(
                    ResourceType.DOUGH, 1,
                    ResourceType.CHESS, 1,
                    ResourceType.HAM, 1
                    )));
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.COIN, 10
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 30
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, true);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        }
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.DOUBLE_PIZZA_MAKER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto make and sell double-pizza(s)";
            construction.descriptionPackage = BaseConstruction.SELLING_DESCRIPTION_PACKAGE;

            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputCostPack(toPack(Map.of(
                    ResourceType.DOUGH, 1,
                    ResourceType.CHESS, 2,
                    ResourceType.HAM, 2
                    )));
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.COIN, 15
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 75
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, true);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        }
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.TOMATO_PIZZA_MAKER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto make and sell tomato-pizza(s)";
            construction.descriptionPackage = BaseConstruction.SELLING_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputCostPack(toPack(Map.of(
                    ResourceType.DOUGH, 1,
                    ResourceType.CHESS, 1,
                    ResourceType.HAM, 1,
                    ResourceType.TOMATO, 1
                    )));
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.COIN, 15
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 100
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, true);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        }
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.SPICE_PIZZA_MAKER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto make and sell spice-pizza(s)";
            construction.descriptionPackage = BaseConstruction.SELLING_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputCostPack(toPack(Map.of(
                    ResourceType.DOUGH, 1,
                    ResourceType.CHESS, 1,
                    ResourceType.HAM, 1,
                    ResourceType.SPICE, 1
                    )));
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.COIN, 15
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 100
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, true);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        }
        {
            BaseConstruction construction = new BaseAutoConstruction(game, ConstructionId.SUPER_PIZZA_MAKER);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Auto make and sell super-pizza(s)";
            construction.descriptionPackage = BaseConstruction.SELLING_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputCostPack(toPack(Map.of(
                    ResourceType.DOUGH, 2,
                    ResourceType.CHESS, 5,
                    ResourceType.HAM, 5,
                    ResourceType.SPICE, 2,
                    ResourceType.TOMATO, 2
                    )));
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.COIN, 40
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            upgradeComponent.setUpgradeCostPack(toPack(Map.of(
                    ResourceType.COIN, 200
                    )));
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, true);
            construction.setLevelComponent(levelComponent);
            
            construction.updateDescription();
            constructions.add(construction);
        }
        
        
        
        
    }
    
    private void initSpecials() {
     // win
        {
            BaseConstruction construction = new BaseClickGatherConstruction(game, ConstructionId.WIN_THE_GAME);
            construction.name = game.getGameDictionary().constructionIdToShowName(construction.getId());
            construction.detailDescroptionConstPart = "Get a trophy and win the game";
            construction.descriptionPackage = BaseConstruction.WIN_DESCRIPTION_PACKAGE;
            
            OutputComponent outputComponent = new OutputComponent(construction);
            outputComponent.setOutputCostPack(toPack(Map.of(
                    ResourceType.COIN, 1000
                    )));
            outputComponent.setOutputGainPack(toPack(Map.of(
                    ResourceType.WIN_TROPHY, 1
                    )));
            construction.setOutputComponent(outputComponent);
            
            UpgradeComponent upgradeComponent = new UpgradeComponent(construction);
            construction.setUpgradeComponent(upgradeComponent);
            
            LevelComponent levelComponent = new LevelComponent(construction, false);
            construction.setLevelComponent(levelComponent);            
            
            
            construction.updateDescription();
            constructions.add(construction);
        }
        
    }

}
