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
 * DynamixelModule
 * 
 * Class that implements methods of the Module interface so that they can work with Dynamixel servos through the use of 
 * the dynamixel_jni class.
 * 
 * @author Giovanna Pezzi <contact@giovannapezzi.info>
 */
class DynamixelModule implements Module
{
    @Override
    public int getServoPosition(int servoId) {
		dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentPosition = dynamixel_jni.readWord(servoId, 30);
		dynamixel_jni.terminate();
        
        return currentPosition;
    }
    
    @Override
    public void setServoPosition(int servoId, int position) {
		dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
		dynamixel_jni.writeWord(servoId, 30, position);
		dynamixel_jni.terminate();         
    }
    
    @Override
    public int getServoTemperature(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentTemperature = dynamixel_jni.readWord(servoId, 43);
		dynamixel_jni.terminate();
        
        return currentTemperature;
    }
    
    @Override
    public int getServoHigherTemperatureLimit(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentHigherTemperatureLimit = dynamixel_jni.readWord(servoId, 11);
		dynamixel_jni.terminate();
        
        return currentHigherTemperatureLimit;
    }
       
    @Override
    public void setServoHigherTemperatureLimit(int servoId, int servoHigherTemperatureLimit) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        dynamixel_jni.writeWord(servoId, 11, servoHigherTemperatureLimit);
		dynamixel_jni.terminate();
    }
       
    @Override
    public int getServoSpeed(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentSpeed = dynamixel_jni.readWord(servoId, 38);  
		dynamixel_jni.terminate();
        
        return currentSpeed;
    } 
  
    @Override
    public void setServoSpeed(int servoId, int servoSpeed) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        dynamixel_jni.writeWord(servoId, 38, servoSpeed);  
		dynamixel_jni.terminate();
    }

    @Override
    public int getServoLowerPositionLimit(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentLowerPositionLimit = dynamixel_jni.readWord(servoId, 36); 
		dynamixel_jni.terminate();
        
        return currentLowerPositionLimit;
    }
       
    @Override
    public void setServoLowerPositionLimit(int servoId, int servoLowerPositionLimit) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        dynamixel_jni.writeWord(servoId, 36, servoLowerPositionLimit); 
		dynamixel_jni.terminate();
    }       
      
    @Override
    public int getServoHigherPositionLimit(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentHigherPositionLimit = dynamixel_jni.readWord(servoId, 37);
		dynamixel_jni.terminate();
        
		return currentHigherPositionLimit;
    }
    
    @Override
    public void setServoHigherPositionLimit(int servoId, int servoHigherPositionLimit ) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        dynamixel_jni.writeWord(servoId, 37, servoHigherPositionLimit);  
		dynamixel_jni.terminate();
    }
    
    @Override
    public int getServoLowerVoltageLimit(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentLowerVoltageLimit = dynamixel_jni.readWord(servoId, 12);  
		dynamixel_jni.terminate();
        
        return currentLowerVoltageLimit;
    }
    
    @Override
    public void setServoLowerVoltageLimit(int servoId, int servoLowerVoltageLimit) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        dynamixel_jni.writeWord(servoId, 12, servoLowerVoltageLimit);  
		dynamixel_jni.terminate();
    }
    
    @Override
    public int getServoHigherVoltageLimit(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentHigherVoltageLimit = dynamixel_jni.readWord(servoId, 13);  
		dynamixel_jni.terminate();
        
        return currentHigherVoltageLimit;
    }
    
    @Override
    public void setServoHigherVoltageLimit(int servoId, int servoHigherVoltageLimit) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        dynamixel_jni.writeWord(servoId, 13, servoHigherVoltageLimit);
		dynamixel_jni.terminate();
    }
        
    @Override
    public int getServoLowerTorque(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentServoLowerTorque = dynamixel_jni.readWord(servoId, 13);
		dynamixel_jni.terminate();
        
        return currentServoLowerTorque;
    }
    
    @Override
    public void setServoLowerTorque(int servoId, int servoLowerTorque) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        dynamixel_jni.writeWord(servoId, 14, servoLowerTorque);
		dynamixel_jni.terminate();
    }
    
    @Override
    public int getServoHigherTorque(int servoId) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        int currentServoHigherTorque = dynamixel_jni.readWord(servoId, 15);
		dynamixel_jni.terminate();
        
        return currentServoHigherTorque;
    }
    
    @Override
    public void setServoHigherTorque(int servoId, int servoHigherTorque) {
        dynamixel_jni.initialize();
		dynamixel_jni.setBaud(1);
        dynamixel_jni.writeWord(servoId, 15, servoHigherTorque);
		dynamixel_jni.terminate();
    }
}
