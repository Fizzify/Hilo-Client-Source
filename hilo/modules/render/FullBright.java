package hilo.modules.render;

import org.lwjgl.input.Keyboard;

import hilo.events.Event;
import hilo.events.listeners.EventUpdate;
import hilo.modules.Module;

public class FullBright extends Module {

	public FullBright() {
		super("FullBright", Keyboard.KEY_O, Category.RENDER);
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 100;
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
	}

}
