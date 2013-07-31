package com.timvisee.dungeonmazeapiexample;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.timvisee.dungeonmaze.api.DungeonMazeApi;

public class DungeonMazeApiExample extends JavaPlugin {
	
	private static final Logger log = Logger.getLogger("Minecraft");

	// Api variable holding the DungeonMazeApi instance
	public DungeonMazeApi api;

	/**
	 * Called when the plugin is being enabled
	 */
	public void onEnable() {
		// Try to hook into the Dungeon Maze API
		this.api = new DungeonMazeApi(this);
		
		// Show a status message because the plugin is being enabled
		log.info("[DungeonMazeApiExample] Dungeon Maze API Example enabled");
		
		// Run the API example methods
		runApiExample();
	}

	/**
	 * Called when the plugin is being disabled
	 */
	public void onDisable() {
		// Show a status message because the plugin is being disabled
		log.info("[DungeonMazeApiExample] DungeonMazeApiExample Disabled!");
	}
	
	/**
	 * Run the API example
	 */
	public void runApiExample() {
		// Always make sure the plugin is successfully hooked into the Dungeon Maze API
		if(this.api.isHooked()) {
			// Retrieve the current Dungeon Maze version through the API
			log.info("[DungeonMazeApiExample] Dungeon Maze version: " + this.api.getVersion());
			
			// Print a list of dungeon maze worlds in the console retrieved through the Dungeon Maze API
			log.info("[DungeonMazeApiExample] Dungeon Maze worlds:");
			
			for(String w : this.api.getWorldManager().getDMWorlds()) {
				// Check whether the world is loaded or not
				boolean isLoaded = this.api.getWorldManager().isDMWorldLoaded(w);
				
				if(isLoaded)
					log.info("[DungeonMazeApiExample] - " + w + " (Loaded)");
				else
					log.info("[DungeonMazeApiExample] - " + w + " (Not Loaded)");
			}
			
		} else {
			// The plugin failed to hook into Dungeon Maze, is the correct version of Dungeon Maze installed?
			log.info("[DungeonMazeApiExample] Not hooked into Dungeon Maze! :(");
		}
	}
}
