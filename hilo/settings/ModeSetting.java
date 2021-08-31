package hilo.settings;

import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;


public class ModeSetting extends Setting
{
	
	public int index;
	public List<String> modes;
	
	public ModeSetting(String name, String defaultMode, String... modes)
	{
		this.name = name;
		this.modes = Arrays.asList(modes);
		index = this.modes.indexOf(defaultMode);
	}

	public ModeSetting(Class<EntityMob> class1, Class<EntityPlayer> class2, Class<EntityAnimal> class3, String string,
			String string2) {
		// TODO Auto-generated constructor stub
	}

	public String getMode()
	{
		return modes.get(index);
	}
	
	public boolean is(String mode)
	{
        return index == modes.indexOf(mode) - 1;
    }
	
	public void cycle()
	{
		if (index < modes.size() -1)
		{
			index++;
		} else
		{
			index = 0;
		}
	}

	public void increment()
	{
		if (index < modes.size() -1)
		{
			index++;
		} else
		{
			index = 0;
		}
		
	}

	public String getValueName()
	{
		return modes.get(index);
	}

}
