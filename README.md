# CCNanoClock

## Download

* **CC1.80pr1, MC1.12.x:** [CCNanoClock-1.12-0.0.1.jar](https://github.com/Iunius118/CCNanoClock/releases)
* **CC1.79, MC1.8.9:** [[1.8.9]CCNanoClock-0.0.1.jar (from MediaFire)](http://www.mediafire.com/file/pkijebnn90kczp1/%5B1.8.9%5DCCNanoClock-0.0.1.jar)
* **CC1.75, MC1.7.10:** [[1.7.10]CCNanoClock-0.0.1.jar (from MediaFire)](http://www.mediafire.com/file/7mzvkd789e8armz/%5B1.7.10%5DCCNanoClock-0.0.1.jar)
* **CC1.41, MC1.2.5:** [[1.2.5]CCNanoClock-0.0.1.zip (from MediaFire)](http://www.mediafire.com/file/s13o9s6a8t399uq/%5B1.2.5%5DCCNanoClock-0.0.1.zip) **- for offline single player only**

## Recipe

### CC Nano Clock (Block)

A peripheral block of **CC Nano Clock** (type: ```nanoclock```).

* c = Clock, d = Diamond, R = Redstone Repeater, # = Stone

```
#c#
RdR
###
```

* Default Block ID (for MC1.2.5) = 2420 (configurable)

## Lua sample code

### MC1.7.10 or above

```Lua
-- for MC1.7.10 or above

-- get a nanoclock object from the peripheral and reset it
clock = peripheral.find( "nanoclock" ).newNanoClock()

sleep( 1 )
print( clock.nanoTime() )  -- print the value about 1000000000
sleep( 2 )
print( clock.nanoTime() )  -- print the value about 3000000000
print( clock.reset() )  -- print the value about 3000000000 and reset clock
sleep( 1 )
print( clock.nanoTime() )  -- print the value about 1000000000
```

### MC1.2.5

```Lua
-- for MC1.2.5

-- get a nanoclock object from the peripheral
clock = peripheral.wrap( <direction> )
clock.reset()  -- reset the nanoclock object

sleep( 1 )
print( clock.nanoTime() )  -- print the value about 1000000000
sleep( 2 )
print( clock.nanoTime() )  -- print the value about 3000000000
print( clock.reset() )  -- print the value about 3000000000 and reset clock
sleep( 1 )
print( clock.nanoTime() )  -- print the value about 1000000000
```

___
Copyright 2018 Iunius118
