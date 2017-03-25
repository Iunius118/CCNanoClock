# CCNanoClock
for ComputerCraft 1.79 (Minecraft 1.8.9 with Forge)


+ **Download:** [[1.8.9]CCNanoClock-0.0.1.jar (from MediaFire)](http://www.mediafire.com/file/pkijebnn90kczp1/%5B1.8.9%5DCCNanoClock-0.0.1.jar)

## Recipe
c = clock, d = Diamond, R = Redstone Repeater, # = Stone
```
#c#
RdR
###
```

## Lua sample code
```Lua
clock = peripheral.find( "nanoclock" ).newNanoClock()

sleep( 1 )
print( clock.nanoTime() )  -- print the value about 1000000000
sleep( 2 )
print( clock.nanoTime() )  -- print the value about 3000000000
print( clock.reset() )  -- print the value about 3000000000 and reset clock
sleep( 1 )
print( clock.nanoTime() )  -- print the value about 1000000000
```

___
Copyright 2017 Iunius118
