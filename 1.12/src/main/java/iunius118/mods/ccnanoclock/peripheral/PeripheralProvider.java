package iunius118.mods.ccnanoclock.peripheral;

import javax.annotation.Nullable;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import iunius118.mods.ccnanoclock.block.BlockNanoClock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PeripheralProvider implements IPeripheralProvider {
	@Override
	@Nullable
	public IPeripheral getPeripheral(World world, BlockPos pos, EnumFacing side) {
		IBlockState state = world.getBlockState(pos);

		if (state != null && state.getBlock() instanceof BlockNanoClock) {
			return new PeripheralNanoClock();
		}

		return null;
	}
}
