package hundun.gdxgame.idlepizza.logic;

import java.util.Arrays;
import java.util.List;

/**
 * @author hundun
 * Created on 2021/11/05
 */

public class ResourceType {
    public static final String DOUGH = "ENUM_RESC@DOUGH";
    public static final String CHESS = "ENUM_RESC@CHESS";
    public static final String HAM = "ENUM_RESC@HAM";
    public static final String SPICE = "ENUM_RESC@SPICE";
    public static final String TOMATO = "ENUM_RESC@TOMATO";
    public static final String COIN = "ENUM_RESC@COIN";
    
    public static final String WIN_TROPHY = "ENUM_RESC@TROPHY";
    ;
    
    public static final List<String> VALUES_FOR_SHOW_ORDER = Arrays.asList(COIN, DOUGH, CHESS, HAM, SPICE, TOMATO);
}
