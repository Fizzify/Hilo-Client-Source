package hilo.modules.player;

import org.lwjgl.input.Keyboard;

import hilo.events.Event;
import hilo.events.listeners.EventUpdate;
import hilo.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class FastPlace extends Module {

	public FastPlace() {
		super("FastPlace", Keyboard.KEY_M, Category.PLAYER);
	}
	
	public void onEvent(EventUpdate e) {
		mc.rightClickDelayTimer = 0;
	}

}
