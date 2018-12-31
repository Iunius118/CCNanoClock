package iunius118.mods.ccnanoclock.peripheral;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;

public class PeripheralNanoClock implements IPeripheral {
	@Override
	public String getType() {
		return "nanoclock";
	}

	@Override
	public String[] getMethodNames() {
		return new String[] { "newNanoClock" };
	}

	@Override
	public Object[] callMethod(IComputerAccess computer, ILuaContext context, int method, Object[] arguments) throws LuaException, InterruptedException {
		switch (method) {
		case 0: 	// newNanoClock() -> ILuaObjact
			return new Object[] { new NanoTimeWrapper() };
		}

		return null;
	}

	@Override
	public void attach(IComputerAccess computer) {

	}

	@Override
	public void detach(IComputerAccess computer) {

	}

	@Override
	public boolean equals(IPeripheral other) {
		return (other instanceof PeripheralNanoClock);
	}
}
