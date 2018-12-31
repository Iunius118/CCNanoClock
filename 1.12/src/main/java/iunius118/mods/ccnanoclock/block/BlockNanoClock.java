package iunius118.mods.ccnanoclock.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNanoClock extends Block {
	public BlockNanoClock() {
		super(Material.GROUND);
		this.setSoundType(SoundType.STONE);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }
}
