package xoleko.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import xoleko.TerraCraft;

public class TerraItems
{
	/* All Content Bag */
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item WHOOPIE_CUSHION = register("whoopie_cushion", new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final Item GOLDEN_KEY = register("golden_key", new Item(new Item.Properties().group(ItemGroup.MISC)));
	
	private static Item register(String name, Item item)
	{
		Item fItem = item.setRegistryName(TerraCraft.MOD_ID, name);
		ITEMS.add(fItem);
		return fItem;
	}
}