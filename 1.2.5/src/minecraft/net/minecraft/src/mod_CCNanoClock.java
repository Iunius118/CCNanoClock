package net.minecraft.src;

import iunius118.mods.ccnanoclock.BlockNanoClock;
import iunius118.mods.ccnanoclock.TileEntityNanoClock;
import net.minecraft.src.forge.MinecraftForgeClient;

public class mod_CCNanoClock extends BaseMod {

	@MLProp(info="The Block ID for CC Nano Clock Block", min=0, max=4095, name="CCNanoClockBlockID")
	public static int idBlockNanoClock = 2420;

	public static Block blockNanoClock;
	public final String blockTextureFilePath = "/terrain/ccnanoclock.png";

	@Override
	public String getVersion() {
		return "0.0.1";
	}

	@Override
	public void load() {
		MinecraftForgeClient.preloadTexture(blockTextureFilePath);

		blockNanoClock = new BlockNanoClock(idBlockNanoClock);
		blockNanoClock.setBlockName("block_nano_clock").setTextureFile(blockTextureFilePath);
		ModLoader.registerBlock(blockNanoClock);
		ModLoader.addName(blockNanoClock, "CC Nano Clock");

		ModLoader.registerTileEntity(TileEntityNanoClock.class, "tile_nano_clock");

		ModLoader.addRecipe(new ItemStack(blockNanoClock, 1), new Object[] {
				"#c#",
				"=d=",
				"###",
				Character.valueOf('#'), Block.stone,
				Character.valueOf('c'), Item.pocketSundial,
				Character.valueOf('d'), Item.diamond,
				Character.valueOf('='), Item.redstoneRepeater});
	}

	@Override
	public String getPriorities() {
		return "after:mod_CCTurtle";
	}

}
