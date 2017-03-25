package iunius118.mods.ccnanoclock.peripheral;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import iunius118.mods.ccnanoclock.block.BlockNanoClock;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class PeripheralProvider implements IPeripheralProvider {

	@Override
	public IPeripheral getPeripheral(World world, BlockPos pos, EnumFacing side) {
		Block block = world.getBlockState(pos).getBlock();

		if (block instanceof BlockNanoClock) {
			return new PeripheralNanoClock();
		}

		return null;
	}

}
