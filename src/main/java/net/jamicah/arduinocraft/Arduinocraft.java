package net.jamicah.arduinocraft;

import net.fabricmc.api.ModInitializer;

import net.jamicah.arduinocraft.arduino.SerialCom;
import net.jamicah.arduinocraft.block.ModBlocks;
import net.jamicah.arduinocraft.commands.Commands;
import net.jamicah.arduinocraft.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Arduinocraft implements ModInitializer {
	public static final String MOD_ID = "arduinocraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static SerialCom comPort;


	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();


		Commands.registerCommands();

		// close port
		// SerialCom.closePort(comPort.comPort);
		// TODO: Add command or anything to close the port
	}
}