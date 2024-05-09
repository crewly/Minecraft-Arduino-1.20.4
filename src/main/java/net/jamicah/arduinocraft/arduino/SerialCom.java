package net.jamicah.arduinocraft.arduino;


import com.fazecast.jSerialComm.SerialPort;
import net.jamicah.arduinocraft.Arduinocraft;
import net.jamicah.arduinocraft.Chat;

import java.io.IOException;
import java.io.Serial;

public class SerialCom {
    public SerialPort comPort;
    public static Boolean isOpened = false;

    // set up the serial port
    public SerialCom(String port) {
        this.comPort = SerialPort.getCommPort(port);
        comPort.setComPortParameters(9600, 8, 1, 0);
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (comPort.openPort()) {
            Chat.sendMessage("§aCommunication successfully started");
            isOpened = true;
        } else {
            Chat.sendMessage("§cSomething went wrong, the inputted port might be wrong");
            isOpened = false;
        }
    }

    // write to the serial port
    public static void digitalWrite(SerialPort com, Integer signal) {
        try {
            com.getOutputStream().write(signal.byteValue());
        } catch (IOException e) {
            Chat.sendMessage("An error has occurred. Debug info: " + e);
        }
        try {
            com.getOutputStream().flush();
        } catch (IOException e) {
            Chat.sendMessage("An error has occurred. Debug info: " + e);
        }
    }
    public static void closePort(SerialPort comPort) {
        if (comPort.closePort()) {
            Arduinocraft.LOGGER.info("Successfully closed Serial Communication");
            isOpened = false;
        } else {
            Arduinocraft.LOGGER.info("An error has occurred while trying to close the Serial Communication");
        }
    }
}
