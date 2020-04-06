# MineCam
Minecraft is not very well suited to taking screenshots. You can't fly (at least in Survival), you can't go through blocks, and there's no built-in camera mode. Some people get around this by having to accounts, one to play in Survival and one to be permanently in Spectator mode. But who wants to spend $25 on Minecraft if you already own the game? Instead, you can use MineCam.

MineCam basically adds a command for players to switch themselves into spectator mode and back out again without needing to be OPs. It's inspired by the Carpet Mod's commandCamera feature, however I always thought that this was very cheaty because it basically allowed you unlimited flight and high-speed travel anywhere, as well as the ability to become impervious to damage. MineCam eliminates this problem by teleporting the player back to their original location when they exit camera mode. Thus, to interact with anything, you always need to get there legitimately.

<div align="center"><b>IMPORTANT! MineCam requires a permissions management plugin like <a href="https://www.spigotmc.org/resources/minecam.76957/">LuckPerms</a>. Unless everyone on your server is an OP, you won't be able to use it without one!</b></div>

## Permissions
Even though MineCam gets rid of a large part of the cheaty-ness of spectator mode, you can still do things with it like look for caves and hunt other players, so you may not want just anyone to have the privilege of using it. So MineCam has some permissions, namely:
* minecam.use - The basic permission. If players have this permission, they will be able to enter and exit camera mode
* minecam.noTP - Players with this permission will not be teleported to their original locations when exiting camera mode but instead will simply drop into their original gamemode. Note that due to the way that Spigot permissions work, OPs have this ability whether they like it or not; there isn't anything I can do about it.

## License
This plugin is licensed under the Mozilla Public License 2.0, which basically means:
* You may use the plugin on any server you like, no questions asked.
* You can use all my code, but you're not allowed to use the name MineCam or say that you wrote it.
* If you use any code, the file that you use it in must be licensed under the MPL, however the project does not need to be.
* You cannot get me into legal trouble for breaking anything, nor can you get me into trouble for not helping you fix it.

For more info, you can look at [the TLDR Legal page for the MPL](https://tldrlegal.com/license/mozilla-public-license-2.0-(mpl-2))
## Support
For support and to get new releases as quickly as possible, you can join the [MineCam Discord.](https://discord.gg/JfJ7R2X)

## Versioning
To make life easier for server admins, the version numbers used by this plugin is compliant with the [Semantic Versioning System](https://semver.org) **TL;DR:**
* Each version number will be formatted like this: 1.0.0
* The first number is rewrites (e.g. Minecraft version updates)
* The second is feature updates
* The third is patches (e.g. bug fixes.
