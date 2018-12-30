package iunius118.mods.ccnanoclock;

import dan200.computercraft.api.ComputerCraftAPI;
import iunius118.mods.ccnanoclock.block.BlockNanoClock;
import iunius118.mods.ccnanoclock.peripheral.PeripheralProvider;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
		modid = CCNanoClock.MOD_ID,
		name = CCNanoClock.MOD_NAME,
		version = CCNanoClock.MOD_VERSION,
		dependencies = CCNanoClock.MOD_DEPENDENCIES
	)
public class CCNanoClock {

	public static final String MOD_ID = "ccnanoclock";
	public static final String MOD_NAME = "CCNanoClock";
	public static final String MOD_VERSION = "1.12-0.0.1";
	public static final String MOD_DEPENDENCIES = "required-after:ComputerCraft";


	public static Block blockNanoClock;
	public static final String NAME_BLOCK_NANO_CLOCK = "nanoclock";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		blockNanoClock = new BlockNanoClock().setUnlocalizedName(NAME_BLOCK_NANO_CLOCK);
		GameRegistry.registerBlock(blockNanoClock, NAME_BLOCK_NANO_CLOCK);

		GameRegistry.addRecipe(new ItemStack(blockNanoClock),
			       "#c#",
			       "=d=",
			       "###",
			       '#', Blocks.stone,
			       'c', Items.clock,
			       'd', Items.diamond,
			       '=', Items.repeater );

		ComputerCraftAPI.registerPeripheralProvider(new PeripheralProvider());

		if (event.getSide().isClient()) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockNanoClock), 0, new ModelResourceLocation(MOD_ID + ":" + NAME_BLOCK_NANO_CLOCK, "inventory"));
		}
	}

}
