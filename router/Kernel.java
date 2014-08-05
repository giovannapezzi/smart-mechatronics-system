import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.omg.CORBA.INTERNAL;

class Kernel {
    private static ServerSocket server;
    private static Socket socket;
    private static BufferedReader readerOfDataFromClient;
    private static BufferedWriter writerOfDataForClient;
    
    private static int currentTemperature;
    private static int currentHigherTemperatureLimit;
    private static int servoType;
    private static int currentSpeed;
    private static int currentLowerPositionLimit;
    private static int currentHigherPositionLimit;
    private static int currentLowerVoltageLimit;
    private static int currentHigherVoltageLimit;
    private static int currentServoLowerTorque;
    private static int currentServoHigherTorque;
    
    public static void main(String[] args) throws IOException, InterruptedException {
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
            message = readerOfDataFromClient.readLine();
            message = message.replaceAll("[^a-zA-Z0-9 ]", "");
            if (!message.equals("")) {
                interpretMessage(message);
            }
        }
    }
    
    private static void interpretMessage(String message) throws IOException {
        System.out.println(message);
        
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
        writerOfDataForClient.write("  LIST AVAILABLE SERVOS\r\n    1) NO SERVO\r\n    2) SERVO IDS: a, b, b, ...\r\n");
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
        writerOfDataForClient.write("  THERE ARE " + ServoModule.getAvailableServos().size() + " SERVOS\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void getServoPosition(int servoId) throws IOException {
        writerOfDataForClient.write(ServoModule.getServoPosition(servoId) + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoPosition(int servoId, int goalPosition) throws IOException {
        ServoModule.setServoPosition(servoId, goalPosition);       
    }
    
    private static void getServoTemperature(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentTemperature = DynamixelModule.readWord(servoId, 43);
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "CURRENT TEMPERATURE"+ " " + currentTemperature + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void getServoHigherTemperatureLimit(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentHigherTemperatureLimit = DynamixelModule.readWord(servoId, 11);
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "CURRENT HIGHER TEMPERATURE LIMIT"+ " " + currentHigherTemperatureLimit + "\r\n");
        writerOfDataForClient.flush();
    }    
    
    private static void setServoHigherTemperatureLimit(int servoId, int servoHigherTemperatureLimit) throws IOException {
		// DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
		// DynamixelModule.writeWord(servoId, 11, servoHigherTemperatureLimit);
		// DynamixelModule.terminate();        
    }    
    
    private static void getServoType(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // servoType = DynamixelModule.readWord(servoId, 1); // Codice controllo da modificare
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "TYPE"+ " " + servoType + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void getServoSpeed(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentSpeed = DynamixelModule.readWord(servoId, 38); 
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "SPEED"+ " " + currentSpeed + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoSpeed(int servoId, int servoSpeed) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // DynamixelModule.writeWord(servoId, 38, servoSpeed);
		// DynamixelModule.terminate();
    }
    
    private static void getServoLowerPositionLimit(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentLowerPositionLimit = DynamixelModule.readWord(servoId, 36); 
		// DynamixelModule.terminate();        
        writerOfDataForClient.write("SERVO" + servoId + "LOWER POSITION LIMIT"+ " " + currentLowerPositionLimit + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoLowerPositionLimit(int servoId, int servoLowerPositionLimit) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // DynamixelModule.writeWord(servoId, 36, servoLowerPositionLimit);
		// DynamixelModule.terminate();
    }
    
    private static void getServoHigherPositionLimit(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentHigherPositionLimit = DynamixelModule.readWord(servoId, 37);
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "HIGHER POSITION LIMIT"+ " " + currentHigherPositionLimit + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoHigherPositionLimit(int servoId, int servoHigherPositionLimit ) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // DynamixelModule.writeWord(servoId, 37, servoHigherPositionLimit);
		// DynamixelModule.terminate();
    }
    
    private static void getServoLowerVoltageLimit(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentLowerVoltageLimit = DynamixelModule.readWord(servoId, 12);
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "LOWER VOLTAGE LIMIT"+ " " + currentLowerVoltageLimit + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoLowerVoltageLimit(int servoId, int servoLowerVoltageLimit) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // DynamixelModule.writeWord(servoId, 12, servoLowerVoltageLimit);
		// DynamixelModule.terminate();
    }
    
    private static void getServoHigherVoltageLimit(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentHigherVoltageLimit = DynamixelModule.readWord(servoId, 13);
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "LOWER VOLTAGE LIMIT"+ " " + currentHigherVoltageLimit + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoHigherVoltageLimit(int servoId, int servoHigherVoltageLimit) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // DynamixelModule.writeWord(servoId, 13, servoHigherVoltageLimit);
		// DynamixelModule.terminate();
    }
    
    private static void getServoLowerTorque(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentServoLowerTorque = DynamixelModule.readWord(servoId, 14);
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "LOWER TORQUE"+ " " + currentServoLowerTorque + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoLowerTorque(int servoId, int servoLowerTorque) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // DynamixelModule.writeWord(servoId, 14, servoLowerTorque);
		// DynamixelModule.terminate();
    }
    
    private static void getServoHigherTorque(int servoId) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // currentServoHigherTorque = DynamixelModule.readWord(servoId, 15);
		// DynamixelModule.terminate();
        writerOfDataForClient.write("SERVO" + servoId + "HIGHER TORQUE"+ " " + currentServoHigherTorque + "\r\n");
        writerOfDataForClient.flush();
    }
    
    private static void setServoHigherTorque(int servoId, int servoHigherTorque) throws IOException {
        // DynamixelModule.initialize();
		// DynamixelModule.setBaud(1);
        // DynamixelModule.writeWord(servoId, 15, servoHigherTorque);
		// DynamixelModule.terminate();
    }
}