package iunius118.mods.ccnanoclock;

import java.util.HashMap;
import java.util.Map;

import dan200.computer.api.IComputerAccess;
import dan200.computer.api.IPeripheral;
import net.minecraft.src.TileEntity;

public class TileEntityNanoClock extends TileEntity implements IPeripheral {

	Map<Integer, Long> startNanoTimes = new HashMap();

	@Override
	public String getType() {
		return "nanoclock";
	}

	@Override
	public String[] getMethodNames() {
		return new String[] { "nanoTime", "reset" };
	}

	@Override
	public Object[] callMethod(IComputerAccess computer, int method, Object[] arguments) throws Exception {
		if (startNanoTimes.get(computer.getID()) instanceof Long == false) {
			startNanoTimes.put(computer.getID(), System.nanoTime());
		}

		switch (method) {
		case 0: 	// nanoTime() -> number
			long nanotime = System.nanoTime() - startNanoTimes.get(computer.getID());
			return new Object[] { Double.valueOf(nanotime) };

		case 1: 	// renew()
			long oldNanoTime = System.nanoTime() - startNanoTimes.get(computer.getID());
			startNanoTimes.put(computer.getID(), System.nanoTime());
			return new Object[] { Double.valueOf(oldNanoTime) };
		}

		return null;
	}

	@Override
	public boolean canAttachToSide(int side) {
		return true;
	}

	@Override
	public void attach(IComputerAccess computer, String computerSide) {

	}

	@Override
	public void detach(IComputerAccess computer) {
		startNanoTimes.remove(computer.getID());
	}

}
