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
 * HerkulexModule
 * 
 * Class that implements methods of the Module interface so that they can work with Herkulex servos.
 * 
 * @author Giovanna Pezzi <contact@giovannapezzi.info>
 */
public class HerkulexModule implements Module {
    
    @Override
    public ArrayList<Servo> scanForAvailableServos() {
        ArrayList<Servo> arrayList; 
        arrayList = new ArrayList<>();
        Servo servo;
        
        servo = new Servo();
        servo.setType(ServoModule.SERVO_TYPE_HERKULEX);
        servo.setId(3);
        arrayList.add(servo);
        
        servo = new Servo();
        servo.setType(ServoModule.SERVO_TYPE_HERKULEX);
        servo.setId(19);
        arrayList.add(servo);
        
        return arrayList;
    }
    
    @Override
    public int getServoPosition(int servoId) {
        return 0;
    }
    
    @Override
    public void setServoPosition(int servoId, int position) {

    }
    
    @Override
    public int getServoTemperature(int servoId) {
        return 0;
    }
    
    @Override
    public int getServoHigherTemperatureLimit(int servoId) {
        return 0;
    }
    
    @Override
    public void setServoHigherTemperatureLimit(int servoId, int servoHigherTemperatureLimit) {

    }   
       
    @Override
    public int getServoSpeed(int servoId) {
        return 0;
    } 
  
    @Override
    public void setServoSpeed(int servoId, int servoSpeed) {
        
    }

    @Override
    public int getServoLowerPositionLimit(int servoId) {
        return 0;
    }
       
    @Override
    public void setServoLowerPositionLimit(int servoId, int servoLowerPositionLimit) {

    }
    
    @Override
    public int getServoHigherPositionLimit(int servoId) {
        return 0;
    }
    
    @Override
    public void setServoHigherPositionLimit(int servoId, int servoHigherPositionLimit ) {

    }
    
    @Override
    public int getServoLowerVoltageLimit(int servoId){
        return 0;       
    }
    
    @Override
    public void setServoLowerVoltageLimit(int servoId, int servoLowerVoltageLimit){

    }
    
    @Override
    public int getServoHigherVoltageLimit(int servoId){
        return 0;
    }
    
    @Override
    public void setServoHigherVoltageLimit(int servoId, int servoHigherVoltageLimit){

    }
    
    @Override
    public int getServoLowerTorque(int servoId){
        return 0;
    }
    
    @Override
    public void setServoLowerTorque(int servoId, int servoLowerTorque){

    }
    
    @Override
    public int getServoHigherTorque(int servoId){
        return 0;
    }
    
    @Override
    public void setServoHigherTorque(int servoId, int servoHigherTorque){

    }
}
