package hilo.modules.movement;

import org.lwjgl.input.Keyboard;

import hilo.events.Event;
import hilo.events.listeners.EventUpdate;
import hilo.modules.Module;

public class Fly extends Module {

	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT);
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
	}

	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if (e.isPre()) {
				mc.thePlayer.capabilities.isFlying = true;
			}
		}
	}
}
