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

import java.util.ArrayList;

/**
 * ServoModule
 * 
 * This class is able to scan available servos. Is is also able to decide which module must be used to execute the 
 * requested method in compatibility with the type of the specified servo. 
 * 
 * 
 * @author Giovanna Pezzi <contact@giovannapezzi.info>
 */
public class ServoModule implements Module {
    public static final int SERVO_TYPE_DYNAMIXEL = 0;
    public static final int SERVO_TYPE_SMS_DRIVER = 1;
    public static final int SERVO_TYPE_HERKULEX = 2;
    
    private DynamixelModule dynamixelModule;
    private SmsDriverModule smsDriverModule;
    private HerkulexModule herkulexModule;
    
    private Module module;
    
    private ArrayList<Integer> servos;
    
    public ServoModule() {
        dynamixelModule = new DynamixelModule();
        smsDriverModule = new SmsDriverModule();
        herkulexModule = new HerkulexModule();
        servos = new ArrayList<>();
    }
    
    public void scanForAvailableServos() {
        servos.add(SERVO_TYPE_DYNAMIXEL);
        servos.add(SERVO_TYPE_DYNAMIXEL);
        servos.add(SERVO_TYPE_DYNAMIXEL);
        servos.add(SERVO_TYPE_SMS_DRIVER);
        servos.add(SERVO_TYPE_HERKULEX);
        servos.add(SERVO_TYPE_HERKULEX);
        servos.add(SERVO_TYPE_HERKULEX);
        servos.add(SERVO_TYPE_HERKULEX);
        servos.add(SERVO_TYPE_SMS_DRIVER);
        servos.add(SERVO_TYPE_SMS_DRIVER);
    }
    
    public ArrayList<Integer> getAvailableServos() {
        return servos;
    }    
    
    public int getServoType(int servoId) {
        if (!servos.isEmpty()) {
            return servos.get(servoId);
        } else {
            throw new IllegalStateException();
        }
    } 
    
    private void setModule(int servoType) {
        switch (servoType) {
            case SERVO_TYPE_DYNAMIXEL:
                module = dynamixelModule;
                break;
            case SERVO_TYPE_SMS_DRIVER:
                module = smsDriverModule;
                break;
            case SERVO_TYPE_HERKULEX:
                module = herkulexModule;
                break;                
        }
    }    

    @Override
    public int getServoPosition(int servoId) {
        setModule(getServoType(servoId));
        return module.getServoPosition(servoId);
    }
    
    @Override
    public void setServoPosition(int servoId, int position) {
        setModule(getServoType(servoId));
        module.setServoPosition(servoId, position);
    }
    
    @Override
    public int getServoTemperature(int servoId) {
        setModule(getServoType(servoId));
        return module.getServoTemperature(servoId);
    }
    
    @Override
    public int getServoHigherTemperatureLimit(int servoId) {
        setModule(getServoType(servoId));
        return module.getServoHigherTemperatureLimit(servoId);
    }
    
    @Override
    public void setServoHigherTemperatureLimit(int servoId, int servoHigherTemperatureLimit) {
        setModule(getServoType(servoId));
        module.setServoHigherTemperatureLimit(servoId, servoHigherTemperatureLimit);
    }
    
    @Override
    public int getServoSpeed(int servoId) {
        setModule(getServoType(servoId));
        return module.getServoSpeed(servoId);
    }
 
    @Override
    public void setServoSpeed(int servoId, int servoSpeed) {
        setModule(getServoType(servoId));
        module.setServoSpeed(servoId, servoSpeed);
    }
    
    @Override
    public int getServoLowerPositionLimit(int servoId) {
        setModule(getServoType(servoId));
        return module.getServoLowerPositionLimit(servoId);
    } 
      
    @Override
    public void setServoLowerPositionLimit(int servoId, int servoLowerPositionLimit) {
        setModule(getServoType(servoId));
        module.setServoLowerPositionLimit(servoId, servoLowerPositionLimit);
    }
    
    @Override
    public int getServoHigherPositionLimit(int servoId) {
        setModule(getServoType(servoId));
        return module.getServoLowerPositionLimit(servoId);
    }
    
    @Override
    public void setServoHigherPositionLimit(int servoId, int servoHigherPositionLimit ) {
        setModule(getServoType(servoId));
        module.setServoLowerPositionLimit(servoId, servoHigherPositionLimit);
    }
    
    @Override
    public int getServoLowerVoltageLimit(int servoId){
        setModule(getServoType(servoId));
        return module. getServoLowerVoltageLimit(servoId);       
    }
    
    @Override
    public void setServoLowerVoltageLimit(int servoId, int servoLowerVoltageLimit){
        setModule(getServoType(servoId));
        module.setServoLowerVoltageLimit(servoId, servoLowerVoltageLimit);
    }
    
    @Override
    public int getServoHigherVoltageLimit(int servoId){
        setModule(getServoType(servoId));
        return module.getServoHigherVoltageLimit(servoId);
    }
    
    @Override
    public void setServoHigherVoltageLimit(int servoId, int servoHigherVoltageLimit){
        setModule(getServoType(servoId));
        module.setServoHigherVoltageLimit(servoId, servoHigherVoltageLimit);
    }
    
    @Override
    public int getServoLowerTorque(int servoId){
        setModule(getServoType(servoId));
        return module.getServoLowerTorque(servoId);
    }
    
    @Override
    public void setServoLowerTorque(int servoId, int servoLowerTorque){
        setModule(getServoType(servoId));
        module.setServoLowerTorque(servoId, servoLowerTorque);
    }
    
    @Override
    public int getServoHigherTorque(int servoId){
        setModule(getServoType(servoId));
        return module.getServoHigherTorque(servoId);
    }
    
    @Override
    public void setServoHigherTorque(int servoId, int servoHigherTorque){
        setModule(getServoType(servoId));
        module.setServoHigherTorque(servoId, servoHigherTorque);
    }
} 