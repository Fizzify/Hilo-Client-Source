package hilo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import hilo.events.Event;
import hilo.events.listeners.EventKey;
import hilo.modules.Module;
import hilo.modules.Module.Category;
import hilo.modules.combat.AutoClicker;
import hilo.modules.combat.KillAura;
import hilo.modules.movement.*;
import hilo.modules.player.*;
import hilo.modules.render.*;
import hilo.ui.HUD;
import hilo.utils.font.MainMenuFontRenderer;

public class Hilo {
	
	public static String name = "Hilo", version = "B1.4";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();
	public static MainMenuFontRenderer font;
	
	public static Fly fly;
	public static Sprint sprint;
	public static FullBright fullBright;
	public static NoFall noFall;
	public static TabGUI tabGUI;
	public static AutoClicker autoClicker;
	public static KillAura killAura;
	public static FastPlace fastPlace;
	public static Velocity velocity;
	public static AutoArmor autoArmor;
	public static DoubleJump doubleJump;
	
	public static void startup() {
		Display.setTitle(name + " v" + version);
		font = new MainMenuFontRenderer("hilo", 10.0F);
		
		modules.add(fly = new Fly());
		modules.add(sprint = new Sprint());
		modules.add(fullBright = new FullBright());
		modules.add(noFall = new NoFall());
		modules.add(tabGUI = new TabGUI());
		modules.add(autoClicker = new AutoClicker());
		modules.add(killAura = new KillAura());
		modules.add(fastPlace = new FastPlace());
		modules.add(velocity = new Velocity());
		modules.add(autoArmor = new AutoArmor());
		modules.add(doubleJump = new DoubleJump());
	}
	
	public static void onEvent(Event e) {
		for (Module m : modules) {
			if (!m.toggled)
				continue;

			m.onEvent(e);
		}
	}

	public static void keyPress(int key) {
		Hilo.onEvent(new EventKey(key));
		for (Module m : modules) {
			if (m.getKey() == key) {
				m.toggle();
			}
		}
	}
	
	public static List<Module> getModuleByCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();
		
		for (Module m : Hilo.modules) {
			if (m.category == c) {
				modules.add(m);
			}
		}
		
		return modules;
	}

}
