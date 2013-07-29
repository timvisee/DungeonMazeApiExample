package com.timvisee.dungeonmazeapiexample;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.timvisee.dungeonmaze.api.DungeonMazeApiNew;

public class DungeonMazeApiExample extends JavaPlugin {
	
	private static final Logger log = Logger.getLogger("Minecraft");

	public DungeonMazeApiNew api;
	
	public void onEnable() {
		// Try to hook into the Dungeon Maze API
		this.api = new DungeonMazeApiNew(this);
		
		// Shwo a status message
		log.info("[DungeonMaze] Dungeon Maze API Example enabled");
		
		if(this.api.isHooked()) {
			log.info("[DungeonMazeApiExample] Dungeon Maze version: " + this.api.getVersion());
			
			log.info("[DungeonMazeApiExample] Dungeon Maze worlds:");
			for(String w : this.api.getDMWorlds())
				log.info("[DungeonMazeApiExample] - " + w);
		} else
			log.info("[DungeonMazeApiExample] Not hooked into Dungeon Maze! :(");
	}

	public void onDisable() {
		log.info("[DungeonMazeApiExample] DungeonMazeApiExample Disabled!");
	}
}
