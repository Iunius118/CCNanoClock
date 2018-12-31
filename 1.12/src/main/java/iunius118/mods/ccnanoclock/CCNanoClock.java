package iunius118.mods.ccnanoclock;

import dan200.computercraft.api.ComputerCraftAPI;
import iunius118.mods.ccnanoclock.block.BlockNanoClock;
import iunius118.mods.ccnanoclock.peripheral.PeripheralProvider;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
		modid = CCNanoClock.MOD_ID,
		name = CCNanoClock.MOD_NAME,
		version = CCNanoClock.MOD_VERSION,
		dependencies = CCNanoClock.MOD_DEPENDENCIES
	)
@Mod.EventBusSubscriber
public class CCNanoClock {
	public static final String MOD_ID = "ccnanoclock";
	public static final String MOD_NAME = "CCNanoClock";
	public static final String MOD_VERSION = "1.12-0.0.1";
	public static final String MOD_DEPENDENCIES = "after:ComputerCraft";

	public static final String NAME_BLOCK_NANO_CLOCK = "nanoclock";

    @ObjectHolder(MOD_ID)
    public static class BLOCKS {
        @ObjectHolder(NAME_BLOCK_NANO_CLOCK)
        public static final Block nano_clock = null;
    }

    @SidedProxy
    public static CommonProxy proxy;

    /*  INITIALIZATION  */

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	/*  REGISTRY EVENT  */

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                new BlockNanoClock().setRegistryName(NAME_BLOCK_NANO_CLOCK).setUnlocalizedName(MOD_ID + "." + NAME_BLOCK_NANO_CLOCK)
        		);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(BLOCKS.nano_clock).setRegistryName(NAME_BLOCK_NANO_CLOCK)
        		);
    }

    /*  PROXY  */

    public static class CommonProxy {
        public void preInit(FMLPreInitializationEvent event) {
            registerPeripherals();
        }

        private void registerPeripherals() {
            ComputerCraftAPI.registerPeripheralProvider(new PeripheralProvider());
        }
    }


    @SideOnly(Side.SERVER)
    public static class ServerProxy extends CommonProxy {

    }

    @SideOnly(Side.CLIENT)
    public static class ClientProxy extends CommonProxy {
        @Override
        public void preInit(FMLPreInitializationEvent event) {
        		super.preInit(event);

        		// Register client side events
        		MinecraftForge.EVENT_BUS.register(this);
        }

        @SubscribeEvent
        public void registerModels(ModelRegistryEvent event) {
        	// Register item model
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BLOCKS.nano_clock), 0, new ModelResourceLocation(BLOCKS.nano_clock.getRegistryName(), "inventory"));
        }
    }
}
