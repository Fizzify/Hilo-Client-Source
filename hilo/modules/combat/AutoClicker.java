package hilo.modules.combat;

import org.lwjgl.input.Keyboard;

import hilo.events.Event;
import hilo.events.listeners.EventUpdate;
import hilo.modules.Module;
import hilo.settings.NumberSetting;
import hilo.utils.Timer;
import net.minecraft.network.play.client.C03PacketPlayer;

public class AutoClicker extends Module {
	
	public NumberSetting cps = new NumberSetting("CPS", 10, 1, 50, 1);
	
	public Timer timer = new Timer();
	
	public AutoClicker() {
		super("AutoClicker", Keyboard.KEY_NONE, Category.COMBAT);
		addSettings(cps);
	}

	public void onEvent(Event e) {
		if (e instanceof EventUpdate && e.isPre()) {
			if (mc.gameSettings.keyBindAttack.isKeyDown() && timer.hasTimeElapsed((long) (1000 / cps.getValue()), true)) {
	            mc.leftClickCounter = 0;
	            mc.clickMouse();
	        }
		}
	}

}
