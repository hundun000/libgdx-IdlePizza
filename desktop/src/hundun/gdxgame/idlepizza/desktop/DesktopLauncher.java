package hundun.gdxgame.idlepizza.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import hundun.gdxgame.idlepizza.IdlePizzaGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
	    IdlePizzaGame game = new IdlePizzaGame();
	    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) (game.LOGIC_WIDTH * IdlePizzaGame.desktopScale);
		config.height = (int) (game.LOGIC_HEIGHT * IdlePizzaGame.desktopScale);
		new LwjglApplication(game, config);
	}
}
