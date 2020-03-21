package xoleko.init;

import java.util.ArrayList;
import java.util.List;


import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import xoleko.TerraCraft;

public class TerraSounds
{
	public static final List<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();
	
	public static final SoundEvent WHOOPIE_CUSHION_USE = register("whoopie_cushion_use");
	
	private static SoundEvent register(String name)
	{
		ResourceLocation path = new ResourceLocation(TerraCraft.MOD_ID, name);
		SoundEvent sound = new SoundEvent(path).setRegistryName(path);
		SOUNDS.add(sound);
		return sound;
	}


}

