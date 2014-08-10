/*
 * The MIT License
 *
 * Copyright 2014 Giovanna Pezzi <contact@giovannapezzi.info>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * @author Giovanna Pezzi <contact@giovannapezzi.info>
 */

import java.io.*;
import java.net.*;
import java.util.regex.*;

/**
 * Kernel
 * 
 * This class is able to listen for text messages sent through socket. If a text message matches a recognized command
 * the class executes the corresponding method and gives back eventual results under the form of another text message
 * written through socket.
 * 
 * @author Giovanna Pezzi <contact@giovannapezzi.info>
 */
class Kernel {
    private static ServerSocket server;
    private static Socket socket;
    private static BufferedReader readerOfDataFromClient;
    private static BufferedWriter writerOfDataForClient;
    
    private static ServoModule servoModule;
    
    public static void main(String[] args) throws IOException, InterruptedException {
        servoModule = new ServoModule();
        while(true) {
            try {
                listenForMessages();
            } catch (NullPointerException e) {
                socket.close();
                server.close();
            }
        }
    }
    
    private static void listenForMessages() throws IOException, InterruptedException {
        server = new ServerSocket(55555);
        socket = server.accept();

        InputStream inputStreamFromClient = socket.getInputStream();
        readerOfDataFromClient = new BufferedReader(new InputStreamReader(inputStreamFromClient));   
        
        OutputStream outputStreamForClient = socket.getOutputStream();
        writerOfDataForClient = new BufferedWriter(new OutputStreamWriter(outputStreamForClient));
        
        String message;
        while (true) {
            try {
                message = readerOfDataFromClient.readLine();
                message = message.replaceAll("[^a-zA-Z0-9 ]", "").trim();
                if (!message.equals("")) {
                    try {
                        interpretMessage(message);
                    } catch (IllegalStateException exception) {
                        writerOfDataForClient.write("ERROR: THERE ARE NOT SERVOS TO OPERATE ON\r\n");
                        writerOfDataForClient.flush();
                    } catch(IndexOutOfBoundsException exception) {
                        writerOfDataForClient.write("ERROR: THE SPECIFIED SERVO DOES NOT EXIST\r\n");
                        writerOfDataForClient.flush();
                    }
                }
            } catch (SocketException e) {
                socket.close();
                server.close();                
                listenForMessages();
            }
        }
    }
    
    private static void interpretMessage(String message) throws IOException {      
        String availableCommandsListingRegexPattern = "^LIST AVAILABLE COMMANDS$";
        if (message.matches(availableCommandsListingRegexPattern)) {
            listAvailableCommands(); 
            return;
        }
        
        String availableServosListingRegexPattern = "^LIST AVAILABLE SERVOS$";
        if (message.matches(availableServosListingRegexPattern)) {
            listAvailableServos(); 
            return;
        }
        
        String availableServosScanningRegexPattern = "^SCAN FOR AVAILABLE SERVOS$";
        if (message.matches(availableServosScanningRegexPattern)) {
            scanServos(); 
            return;
        }        
        
        String servoPositionRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) POSITION$";
        if (message.matches(servoPositionRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoPositionRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoPosition(Integer.parseInt(matcher.group(1))); 
            return;
        }
        
        String servoPositionSettingCommandRegexPattern = "^SET SERVO ([0-9]+) POSITION TO ([0-9]+)$";
        if (message.matches(servoPositionSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoPositionSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoPosition(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))); 
        }
    
        String servoTemperatureRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) TEMPERATURE$";
        if (message.matches(servoTemperatureRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoTemperatureRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoTemperature(Integer.parseInt(matcher.group(1))); 
        }
        
        String servoHigherTemperaturelimitRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) HIGHER TEMPERATURE LIMIT$";
        if (message.matches(servoHigherTemperaturelimitRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoHigherTemperaturelimitRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoHigherTemperatureLimit(Integer.parseInt(matcher.group(1))); 
        }        
        
        String servoHigherTemperatureLimitSettingCommandRegexPattern = "^SET SERVO ([0-9]+) HIGHER TEMPERATURE LIMIT ([0-9]+)$";
        if (message.matches(servoHigherTemperatureLimitSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoHigherTemperatureLimitSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoHigherTemperatureLimit(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))); 
        }      
        
        String servoTypeRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) TYPE$";
        if (message.matches(servoTypeRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoTypeRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoType(Integer.parseInt(matcher.group(1))); 
        }
        
        String servoSpeedRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) SPEED$";
        if (message.matches(servoSpeedRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoSpeedRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoSpeed(Integer.parseInt(matcher.group(1))); 
        }
        
        String servoSpeedSettingCommandRegexPattern = "^SET SERVO ([0-9]+) SPEED ([0-9]+)$";
        if (message.matches(servoSpeedSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoSpeedSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoSpeed(Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2))); 
        }
        
        String servoLowerPositioLimitRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) LOWER POSITION LIMIT$";
        if (message.matches(servoLowerPositioLimitRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoLowerPositioLimitRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoLowerPositionLimit(Integer.parseInt(matcher.group(1))); 
        }
        
        String servoLowerPositioLimitSettingCommandRegexPattern = "^SET SERVO ([0-9]+) LOWER POSITION LIMIT ([0-9]+)$";
        if (message.matches(servoLowerPositioLimitSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoLowerPositioLimitSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoLowerPositionLimit(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))); 
        }
        
        String servoHigherPositioLimitRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) HIGHER POSITION LIMIT$";
        if (message.matches(servoHigherPositioLimitRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoHigherPositioLimitRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoHigherPositionLimit(Integer.parseInt(matcher.group(1))); 
        }
        
        String servoHigherPositioLimitSettingCommandRegexPattern = "^SET SERVO ([0-9]+) HIGHER POSITION LIMIT ([0-9]+)$";
        if (message.matches(servoHigherPositioLimitSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoHigherPositioLimitSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoHigherPositionLimit(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))); 
        }
        
        String servoLowerVoltageLimitRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) LOWER VOLTAGE LIMIT$";
        if (message.matches(servoLowerVoltageLimitRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoLowerVoltageLimitRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoLowerVoltageLimit(Integer.parseInt(matcher.group(1))); 
        }
        
        String servoLowerVoltageLimitSettingCommandRegexPattern = "^SET SERVO ([0-9]+) LOWER VOLTAGE LIMIT ([0-9]+)$";
        if (message.matches(servoLowerVoltageLimitSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoLowerVoltageLimitSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoLowerVoltageLimit(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))); 
        }
        
        String servoHigherVoltageLimitRetrievalCommandRegexPattern = "^GET SERVO ([0-9]+) LOWER VOLTAGE LIMIT$";
        if (message.matches(servoHigherVoltageLimitRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoHigherVoltageLimitRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoHigherVoltageLimit(Integer.parseInt(matcher.group(1))); 
        } 
        
        String servoHigherVoltageLimitSettingCommandRegexPattern = "^SET SERVO ([0-9]+) HIGHER VOLTAGE LIMIT ([0-9]+)$";
        if (message.matches(servoHigherVoltageLimitSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoHigherVoltageLimitSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoHigherVoltageLimit(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))); 
        }
        
        
        String servoLowerTorqueRetrievalCommandRegexPattern = "^SET SERVO ([0-9]+) LOWER TORQUE$";
        if (message.matches(servoLowerTorqueRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoLowerTorqueRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoLowerTorque(Integer.parseInt(matcher.group(1))); 
        }
        
        String servoLowerTorqueSettingCommandRegexPattern = "^SET SERVO ([0-9]+) LOWER TORQUE ([0-9]+)$";
        if (message.matches(servoLowerTorqueSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoLowerTorqueSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoLowerTorque(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))); 
        }
        
        String servoHigherTorqueRetrievalCommandRegexPattern = "^SET SERVO ([0-9]+) HIGHER TORQUE$";
        if (message.matches(servoHigherTorqueRetrievalCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoHigherTorqueRetrievalCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            getServoHigherTorque(Integer.parseInt(matcher.group(1))); 
        }
        
        String servoHigherTorqueSettingCommandRegexPattern = "^SET SERVO ([0-9]+) HIGHER TORQUE ([0-9]+)$";
        if (message.matches(servoHigherTorqueSettingCommandRegexPattern)) {
            Pattern pattern = Pattern.compile(servoHigherTorqueSettingCommandRegexPattern);
            Matcher matcher = pattern.matcher(message);
            matcher.find();            
            setServoHigherTorque(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))); 
        }        
    }
    
    private static void listAvailableCommands() throws IOException {
        writerOfDataForClient.write("  LIST AVAILABLE COMMANDS\r\n");
        writerOfDataForClient.write("  SCAN FOR AVAILABLE SERVOS\r\n");
        writerOfDataForClient.write("  LIST AVAILABLE SERVOS\r\n");
        writerOfDataForClient.write("  GET SERVO S POSITION\r\n");
        writerOfDataForClient.write("  SET SERVO S POSITION TO P\r\n");
        writerOfDataForClient.write("  GET SERVO S TYPE\r\n");
        writerOfDataForClient.write("  GET SERVO S TEMPERATURE\r\n");
        writerOfDataForClient.write("  GET SERVO S HIGHER TEMPERATURE LIMIT\r\n");
        writerOfDataForClient.write("  SET SERVO S HIGHER TEMPERATURE LIMIT\r\n");
        writerOfDataForClient.write("  GET SERVO S SPEED\r\n");
        writerOfDataForClient.write("  SET SERVO S SPEED\r\n");
        writerOfDataForClient.write("  GET SERVO S LOWER POSITION LIMIT\r\n");
        writerOfDataForClient.write("  SET SERVO S LOWER POSITION LIMIT\r\n");
        writerOfDataForClient.write("  GET SERVO S HIGHER POSITION LIMIT\r\n");
        writerOfDataForClient.write("  SET SERVO S HIGHER POSITION LIMIT\r\n");  
        writerOfDataForClient.write("  GET SERVO S LOWER VOLTAGE LIMIT\r\n");
        writerOfDataForClient.write("  SET SERVO S LOWER VOLTAGE LIMIT\r\n");
        writerOfDataForClient.write("  GET SERVO S HIGHER VOLTAGE LIMIT\r\n");
        writerOfDataForClient.write("  SET SERVO S HIGHER VOLTAGE LIMIT\r\n"); 
        writerOfDataForClient.write("  GET SERVO S LOWER TORQUE \r\n");
        writerOfDataForClient.write("  SET SERVO S LOWER TORQUE\r\n");
        writerOfDataForClient.write("  GET SERVO S HIGHER TORQUE \r\n");
        writerOfDataForClient.write("  SET SERVO S HIGHER TORQUE\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void listAvailableServos() throws IOException {
        writerOfDataForClient.write("  THERE ARE " + servoModule.getAvailableServos().size() + " SERVOS\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void scanServos() throws IOException {
        servoModule.scanForAvailableServos();
        writerOfDataForClient.write("  SERVOS HAVE BEEN SCANNED\r\n");
        writerOfDataForClient.flush();
    }    
    
    private static void getServoPosition(int servoId) throws IOException {
        writerOfDataForClient.write(servoModule.getServoPosition(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoPosition(int servoId, int goalPosition) throws IOException {
        servoModule.setServoPosition(servoId, goalPosition);       
    }
    
    private static void getServoTemperature(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "CURRENT TEMPERATURE"+ " " + servoModule.getServoTemperature(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void getServoHigherTemperatureLimit(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "CURRENT HIGHER TEMPERATURE LIMIT"+ " " + servoModule.getServoHigherTemperatureLimit(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }    
    
    private static void setServoHigherTemperatureLimit(int servoId, int servoHigherTemperatureLimit) throws IOException {
		servoModule.setServoHigherTemperatureLimit(servoId, servoHigherTemperatureLimit);   
    }    
    
    private static void getServoType(int servoId) throws IOException {
        String message = "SERVO" + servoId + "TYPE" + " ";
        switch (servoModule.getServoType(servoId)) {
            case ServoModule.SERVO_TYPE_DYNAMIXEL:
                message += "DYNAMIXEL\r\n";
            case ServoModule.SERVO_TYPE_HERKULEX:
                message += "HERKULEX\r\n";
            case ServoModule.SERVO_TYPE_SMS_DRIVER:
                message += "SMS DRIVER\r\n";                
        }
        writerOfDataForClient.write(message);
        writerOfDataForClient.flush();
    }
    
    private static void getServoSpeed(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "SPEED"+ " " + servoModule.getServoSpeed(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoSpeed(int servoId, int servoSpeed) throws IOException {
        servoModule.setServoSpeed(servoId, servoSpeed);
    }
    
    private static void getServoLowerPositionLimit(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "LOWER POSITION LIMIT"+ " " + servoModule.getServoLowerPositionLimit(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoLowerPositionLimit(int servoId, int servoLowerPositionLimit) throws IOException {
        servoModule.setServoLowerPositionLimit(servoId, servoLowerPositionLimit);
    }
    
    private static void getServoHigherPositionLimit(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "HIGHER POSITION LIMIT"+ " " + servoModule.getServoHigherPositionLimit(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoHigherPositionLimit(int servoId, int servoHigherPositionLimit ) throws IOException {
        servoModule.setServoHigherPositionLimit(servoId, servoHigherPositionLimit );
    }
    
    private static void getServoLowerVoltageLimit(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "LOWER VOLTAGE LIMIT"+ " " + servoModule.getServoLowerVoltageLimit(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoLowerVoltageLimit(int servoId, int servoLowerVoltageLimit) throws IOException {
        servoModule.setServoLowerVoltageLimit(servoId, servoLowerVoltageLimit);
    }
    
    private static void getServoHigherVoltageLimit(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "LOWER VOLTAGE LIMIT"+ " " + servoModule.getServoHigherVoltageLimit(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoHigherVoltageLimit(int servoId, int servoHigherVoltageLimit) throws IOException {
        servoModule.setServoHigherVoltageLimit(servoId, servoHigherVoltageLimit);
    }
    
    private static void getServoLowerTorque(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "LOWER TORQUE"+ " " +  servoModule.getServoLowerTorque(servoId)+ "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoLowerTorque(int servoId, int servoLowerTorque) throws IOException {
        servoModule.setServoLowerTorque(servoId, servoLowerTorque);
    }
    
    private static void getServoHigherTorque(int servoId) throws IOException {
        writerOfDataForClient.write("SERVO" + servoId + "HIGHER TORQUE" + " " + servoModule.getServoHigherTorque(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoHigherTorque(int servoId, int servoHigherTorque) throws IOException {
        servoModule.setServoHigherTorque(servoId, servoHigherTorque);
    }
}