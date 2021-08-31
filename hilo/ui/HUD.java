package hilo.ui;

import java.util.Collections;
import java.util.Comparator;

import hilo.Hilo;
import hilo.events.listeners.EventRenderGUI;
import hilo.modules.Module;
import hilo.utils.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class HUD {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public void draw() {
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRendererObj;
		
		Hilo.modules.sort(Comparator.comparing(m ->
			fr.getStringWidth(((Module)m).name))
			.reversed()
		);
	
		GlStateManager.pushMatrix();
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(2, 2, 1);
		GlStateManager.translate(-4, -4, 0);
		fr.drawStringWithShadow(Hilo.name + " v" + Hilo.version, 4, 4, -1);
		GlStateManager.popMatrix();
		
		fr.drawStringWithShadow("FPS: " + mc.getDebugFPS(), 4, 21, -1);
		
		int count = 0;
		for (Module m : Hilo.modules) {
			if (!m.toggled || m.name.equals("TabGUI"))
				continue;
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 10, count*(fr.FONT_HEIGHT + 6), sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, 6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 6), ColorUtil.getRainbow(4, 0.8f, 1, count * 1000));
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, count*(fr.FONT_HEIGHT + 6), sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + count*(fr.FONT_HEIGHT + 6), 0x90000000);
			fr.drawStringWithShadow(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) - 4, 4 + count*(fr.FONT_HEIGHT + 6), -1);
		
			count++;
		}
		
		Hilo.onEvent(new EventRenderGUI());
	}
	
}
