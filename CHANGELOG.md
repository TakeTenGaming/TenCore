# Changelog

## 1.2.0
This is a maintenance release.

### Changes
- Updated `Forge` (13.20.0.2310)
- Updated `MCP Mappings` (snapshot_20170529)
- Changed `Block` and `Item` classes to utilize `NameUtil.getName` (1.11+) rather than `NameUtil.getNameLegacy` (1.10.2)
- Moved `DatMod` recipes out of the `FurnaceRecipes` and `PulverizerRecipes` classes
- Cleaned up the main mod file
- Changed energy storage from 10,000 to 100,000
- Changed max energy receive to 40

### Additions
- Added a base `Container` class with methods for adding slots to containers and transferring stacks into slots
- Added `machine.PowerSender` class from `DatMod`

### Fixes
- Fixes a minor typo in the `TileEntityBase` item handler

#### 1.1.0
This release is a feature/change release.

##### Fixes
- The mod now works properly in 1.10.2 and 1.11.2

##### Changes
- Updated Forge (13.20.0.2259)
- Updated MCP Mappings (snapshot_20170307)
- Switched to Forge's version checking system and removed ours
- Added `BlockFacable` base class, holds all the basic code for supporting rotatable blocks
- Added `TileEntityBase` and `EnergyStorage` class
- Added `debug` method to `Logger`, will only show messages if the `debug` flag is present in the command line arguments
- Removed the default `canDropFromExplosion` method declaration for the `Block` class
- Modified `Block` to allow harvesting by a stone pickaxe
- Fixed `Block` not dropping contents when broken
- Improved syntax of `/profiler` command usage output
- Added an argument check to the `/profiler` command to prevent `IndexOutOfBoundsException` errors
- General code cleanup to bring our coding styles more inline

#### 1.0.0 - Initial Release
The initial release of TenCore