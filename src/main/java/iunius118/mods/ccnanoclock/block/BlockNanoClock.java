package iunius118.mods.ccnanoclock.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNanoClock extends Block {

	public BlockNanoClock() {
		super(Material.ground);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public int getRenderType() {
		return 3;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

}
