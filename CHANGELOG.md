# Changelog

## 1.1.0
This release is a feature/change release.

**Fixes**
- The mod now works properly in 1.10.2 and 1.11.2

**Changes**
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

## 1.0.0 - Initial Release
The initial release of TenCore