package xoleko.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import xoleko.TerraCraft;

public class TerraBlocks
{
	 /* All Content Bag */
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    
    /* Sorting */
    public static final List<BlockItem> CUBES = new ArrayList<BlockItem>();
    public static final List<BlockItem> SAPLINGS = new ArrayList<BlockItem>();
    public static final List<BlockItem> FLOWERS = new ArrayList<BlockItem>();
    
    /* TerraCraftPreHardmode */
    public static final Block COPPER_ORE = register("copper_ore", new Block(Properties.from(Blocks.COAL_ORE)), ItemGroup.MISC, CUBES);
 
    private static Block register(String name, Block block)
    {
        Block fBlock = block.setRegistryName(TerraCraft.MOD_ID, name);
        BLOCKS.add(fBlock);
        return fBlock;
    }
    
    private static Block register(String name, Block block, ItemGroup group, List<BlockItem> itemList)
    {
    	Block fBlock = register(name, block);
        if(itemList == FLOWERS || itemList == SAPLINGS)
        {
        	Block fullFlowerPot = new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), () -> fBlock.delegate.get(), Properties.from(Blocks.FLOWER_POT).lightValue(fBlock.getDefaultState().getLightValue())).setRegistryName(TerraCraft.MOD_ID, "potted_" + name);
        	BLOCKS.add(fullFlowerPot);
            if(Blocks.FLOWER_POT != null)
            {
                ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(fBlock.getRegistryName(), () -> fullFlowerPot);
            }
        }
        itemList.add((BlockItem) new BlockItem(fBlock, new Item.Properties().group(group)).setRegistryName(TerraCraft.MOD_ID, name));
        return fBlock;
    }

}