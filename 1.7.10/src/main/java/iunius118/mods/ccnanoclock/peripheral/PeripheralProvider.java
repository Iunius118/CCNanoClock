package iunius118.mods.ccnanoclock.peripheral;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import iunius118.mods.ccnanoclock.block.BlockNanoClock;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class PeripheralProvider implements IPeripheralProvider {

	@Override
	public IPeripheral getPeripheral(World world, int x, int y, int z, int side) {
		Block block = world.getBlock(x, y, z);

		if (block instanceof BlockNanoClock) {
			return new PeripheralNanoClock();
		}

		return null;
	}

}
