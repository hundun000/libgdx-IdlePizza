package hundun.gdxgame.idlepizza.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import hundun.gdxgame.idlepizza.IdlePizzaGame;
import hundun.gdxgame.idleshare.desktop.DesktopExitHookTask;
import hundun.gdxgame.idleshare.desktop.PreferencesSaveTool;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
	    IdlePizzaGame game = new IdlePizzaGame(new PreferencesSaveTool("IdlePizza-destop-save"));
	    Runtime.getRuntime().addShutdownHook(new DesktopExitHookTask(game));
	    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) (game.LOGIC_WIDTH * game.desktopScale);
		config.height = (int) (game.LOGIC_HEIGHT * game.desktopScale);
		new LwjglApplication(game, config);
	}
}
