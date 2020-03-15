package xoleko;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import xoleko.init.TerraItems;
import xoleko.util.MoreWordUtils;

@Mod(TerraCraft.MOD_ID)
public class TerraCraft
{
    public static final String MOD_ID = "terracraft";
	public static final String MOD_PREFIX = MOD_ID + ":";
    public static final Logger LOGGER = LogManager.getLogger();

    public TerraCraft()
    {
    	MinecraftForge.EVENT_BUS.register(this);
    	
    	IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modBus.addListener(this::setup);
    	modBus.addListener(this::clientSetup);
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
    	//LOGGER.info("Registered entity spawns");
    }
    
    private void clientSetup(final FMLClientSetupEvent event)
    {
    	//LOGGER.info("Registered entity renders");
    }
    
    @SubscribeEvent
    public void serverSetup(final FMLServerStartingEvent event)
    {
    	//LOGGER.info("Registered commands");
    }
    
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModRegistryEvents
	{
		@SubscribeEvent
		public static void blocksRegistry(final RegistryEvent.Register<Block> event)
		{
			// event.getRegistry().registerAll(TerraBlocks.BLOCKS.toArray(new Block[0]));
			// LOGGER.info("Registered " + MoreWordUtils.numerate(TerraBlocks.BLOCKS.size(), "block"));
		}

		@SubscribeEvent
		public static void itemsRegistry(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll(TerraItems.ITEMS.toArray(new Item[0]));
			LOGGER.info("Registered " + MoreWordUtils.numerate(TerraItems.ITEMS.size(), "item"));
		}

		@SubscribeEvent
		public static void entitiesRegistry(final RegistryEvent.Register<EntityType<?>> event)
		{
			// event.getRegistry().registerAll(TerraEntities.ENTITY_TYPES.toArray(new EntityType<?>[0]));
			// LOGGER.info("Registered " + MoreWordUtils.numerate(TerraEntities.ENTITY_TYPES.size(), "entity"));
			// TerraEntities.registerPlacements();
			// LOGGER.info("Registered entity spawn placements");
		}

		@SubscribeEvent
		public static void soundsRegistry(final RegistryEvent.Register<SoundEvent> event)
		{
			// event.getRegistry().registerAll(TerraSounds.SOUNDS.toArray(new SoundEvent[0]));
			// LOGGER.info("Registered " + MoreWordUtils.numerate(TerraSounds.SOUNDS.size(), "sound"));
		}

		@SubscribeEvent
		public static void biomesRegistry(final RegistryEvent.Register<Biome> event)
		{
			// event.getRegistry().registerAll(TerraBiomes.BIOMES.toArray(new Biome[0]));
			// TerraBiomes.registerGenerations();
			// LOGGER.info("Registered " + MoreWordUtils.numerate(TerraBiomes.BIOMES.size(), "biome"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void blockColorsRegistry(final ColorHandlerEvent.Block event)
		{
			// TerraColorMaps.registerBlockColors(event);
			// LOGGER.info("Registered color maps for blocks");
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void itemColorsRegistry(final ColorHandlerEvent.Item event)
		{
			// TerraColorMaps.registerItemColors(event);
			// LOGGER.info("Registered color maps for items");
		}
	}
}