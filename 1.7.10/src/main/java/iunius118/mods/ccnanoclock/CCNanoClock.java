package iunius118.mods.ccnanoclock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dan200.computercraft.api.ComputerCraftAPI;
import iunius118.mods.ccnanoclock.block.BlockNanoClock;
import iunius118.mods.ccnanoclock.peripheral.PeripheralProvider;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(
		modid = CCNanoClock.MOD_ID,
		name = CCNanoClock.MOD_NAME,
		version = CCNanoClock.MOD_VERSION,
		dependencies = CCNanoClock.MOD_DEPENDENCIES
	)
public class CCNanoClock {

	public static final String MOD_ID = "ccnanoclock";
	public static final String MOD_NAME = "CCNanoClock";
	public static final String MOD_VERSION = "%modVersion%";
	public static final String MOD_DEPENDENCIES = "required-after:ComputerCraft";


	public static Block blockNanoClock;
	public static final String NAME_BLOCK_NANO_CLOCK = "nanoclock";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		blockNanoClock = new BlockNanoClock().setBlockName(NAME_BLOCK_NANO_CLOCK);
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
	}

}
