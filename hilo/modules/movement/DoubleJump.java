package hilo.modules.movement;

import org.lwjgl.input.Keyboard;

import hilo.events.Event;
import hilo.events.listeners.EventUpdate;
import hilo.modules.Module;

public class DoubleJump extends Module {

	public DoubleJump() {
		super("Double Jump", Keyboard.KEY_L, Category.MOVEMENT);
	}
	
	public void onDisable() {
		mc.thePlayer.onGround = false;
	}

	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if (e.isPre()) {
				mc.thePlayer.onGround = true;
			}
		}
	}
}
