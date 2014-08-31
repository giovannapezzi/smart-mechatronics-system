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

import java.util.*;

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
    public static final int SERVO_TYPE_HERKULEX = 1;    
    public static final int SERVO_TYPE_SMS_DRIVER = 2;
    
    private DynamixelModule dynamixelModule;
    private HerkulexModule herkulexModule;    
    private SmsDriverModule smsDriverModule;
    
    private Module module;
    
    private ArrayList<Servo> servos;
    
    public ServoModule() {
        dynamixelModule = new DynamixelModule();
        herkulexModule = new HerkulexModule();        
        smsDriverModule = new SmsDriverModule();
        servos = new ArrayList<>();
    }
    
    public ArrayList<Servo> getAvailableServos() {
        return servos;
    }    
    
    public int getServoType(int servoIndex) {
        if (!servos.isEmpty()) {
            return servos.get(servoIndex).getType();
        } else {
            throw new IllegalStateException();
        }
    } 
    
    private void setModule(int servoType) {
        switch (servoType) {
            case SERVO_TYPE_DYNAMIXEL:
                module = dynamixelModule;
                break;
            case SERVO_TYPE_HERKULEX:
                module = herkulexModule;
                break;                
            case SERVO_TYPE_SMS_DRIVER:
                module = smsDriverModule;
                break;                
        }
    } 
    
    @Override
    public ArrayList<Servo> scanForAvailableServos() {
        servos.addAll(dynamixelModule.scanForAvailableServos());
        servos.addAll(herkulexModule.scanForAvailableServos());
        servos.addAll(smsDriverModule.scanForAvailableServos());
        
        return servos;
    }    

    @Override
    public int getServoPosition(int servoIndex) {
        setModule(getServoType(servoIndex));
        return module.getServoPosition(servos.get(servoIndex).getId());
    }
    
    @Override
    public void setServoPosition(int servoIndex, int position) {
        setModule(getServoType(servoIndex));
        module.setServoPosition(servos.get(servoIndex).getId(), position);
    }
    
    @Override
    public int getServoTemperature(int servoIndex) {
        setModule(getServoType(servoIndex));
        return module.getServoTemperature(servos.get(servoIndex).getId());
    }
    
    @Override
    public int getServoHigherTemperatureLimit(int servoIndex) {
        setModule(getServoType(servoIndex));
        return module.getServoHigherTemperatureLimit(servos.get(servoIndex).getId());
    }
    
    @Override
    public void setServoHigherTemperatureLimit(int servoIndex, int servoHigherTemperatureLimit) {
        setModule(getServoType(servoIndex));
        module.setServoHigherTemperatureLimit(servos.get(servoIndex).getId(), servoHigherTemperatureLimit);
    }
    
    @Override
    public int getServoSpeed(int servoIndex) {
        setModule(getServoType(servoIndex));
        return module.getServoSpeed(servos.get(servoIndex).getId());
    }
 
    @Override
    public void setServoSpeed(int servoIndex, int servoSpeed) {
        setModule(getServoType(servoIndex));
        module.setServoSpeed(servos.get(servoIndex).getId(), servoSpeed);
    }
    
    @Override
    public int getServoLowerPositionLimit(int servoIndex) {
        setModule(getServoType(servoIndex));
        return module.getServoLowerPositionLimit(servos.get(servoIndex).getId());
    } 
      
    @Override
    public void setServoLowerPositionLimit(int servoIndex, int servoLowerPositionLimit) {
        setModule(getServoType(servoIndex));
        module.setServoLowerPositionLimit(servos.get(servoIndex).getId(), servoLowerPositionLimit);
    }
    
    @Override
    public int getServoHigherPositionLimit(int servoIndex) {
        setModule(getServoType(servoIndex));
        return module.getServoLowerPositionLimit(servos.get(servoIndex).getId());
    }
    
    @Override
    public void setServoHigherPositionLimit(int servoIndex, int servoHigherPositionLimit ) {
        setModule(getServoType(servoIndex));
        module.setServoLowerPositionLimit(servos.get(servoIndex).getId(), servoHigherPositionLimit);
    }
    
    @Override
    public int getServoLowerVoltageLimit(int servoIndex){
        setModule(getServoType(servoIndex));
        return module. getServoLowerVoltageLimit(servos.get(servoIndex).getId());       
    }
    
    @Override
    public void setServoLowerVoltageLimit(int servoIndex, int servoLowerVoltageLimit){
        setModule(getServoType(servoIndex));
        module.setServoLowerVoltageLimit(servos.get(servoIndex).getId(), servoLowerVoltageLimit);
    }
    
    @Override
    public int getServoHigherVoltageLimit(int servoIndex){
        setModule(getServoType(servoIndex));
        return module.getServoHigherVoltageLimit(servos.get(servoIndex).getId());
    }
    
    @Override
    public void setServoHigherVoltageLimit(int servoIndex, int servoHigherVoltageLimit){
        setModule(getServoType(servoIndex));
        module.setServoHigherVoltageLimit(servos.get(servoIndex).getId(), servoHigherVoltageLimit);
    }
    
    @Override
    public int getServoLowerTorque(int servoIndex){
        setModule(getServoType(servoIndex));
        return module.getServoLowerTorque(servos.get(servoIndex).getId());
    }
    
    @Override
    public void setServoLowerTorque(int servoIndex, int servoLowerTorque){
        setModule(getServoType(servoIndex));
        module.setServoLowerTorque(servos.get(servoIndex).getId(), servoLowerTorque);
    }
    
    @Override
    public int getServoHigherTorque(int servoIndex){
        setModule(getServoType(servoIndex));
        return module.getServoHigherTorque(servos.get(servoIndex).getId());
    }
    
    @Override
    public void setServoHigherTorque(int servoIndex, int servoHigherTorque){
        setModule(getServoType(servoIndex));
        module.setServoHigherTorque(servos.get(servoIndex).getId(), servoHigherTorque);
    }
} 