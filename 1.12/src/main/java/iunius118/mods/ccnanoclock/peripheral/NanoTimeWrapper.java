package iunius118.mods.ccnanoclock.peripheral;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.ILuaObject;
import dan200.computercraft.api.lua.LuaException;

public class NanoTimeWrapper implements ILuaObject {

	public long startNanoTime = System.nanoTime();

	@Override
	public String[] getMethodNames() {
		return new String[] { "nanoTime", "reset" };
	}

	@Override
	public Object[] callMethod(ILuaContext context, int method, Object[] arguments) throws LuaException, InterruptedException {
		switch (method) {
		case 0: 	// nanoTime() -> number
			long nanotime = System.nanoTime() - startNanoTime;
			return new Object[] { Double.valueOf(nanotime) };

		case 1: 	// renew()
			long oldNanoTime = System.nanoTime() - startNanoTime;
			startNanoTime = System.nanoTime();
			return new Object[] { Double.valueOf(oldNanoTime) };

		}

		return null;
	}

}
