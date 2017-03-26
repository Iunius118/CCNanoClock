package iunius118.mods.ccnanoclock.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockNanoClock extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;
    @SideOnly(Side.CLIENT)
    private IIcon bottomIcon;

	public BlockNanoClock() {
		super(Material.ground);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		topIcon = par1IconRegister.registerIcon("ccnanoclock:nanoclock_top");
		sideIcon = par1IconRegister.registerIcon("ccnanoclock:nanoclock_side");
		bottomIcon = par1IconRegister.registerIcon("ccnanoclock:nanoclock_bottom");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		switch (par1) {
		case 0:
			return bottomIcon;
		case 1:
			return topIcon;
		}

		return sideIcon;
	}

}
