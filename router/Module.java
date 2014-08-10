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
 * Module
 * 
 * This interface represents the list of common methods available for any servo type.
 * 
 * @author Giovanna Pezzi <contact@giovannapezzi.info>
 */
public interface Module {
    public int getServoPosition(int servoId);
    
    public void setServoPosition(int servoId, int position);
    
    public int getServoTemperature(int servoId);
    
    public int getServoHigherTemperatureLimit(int servoId);
    
    public void setServoHigherTemperatureLimit(int servoId, int servoHigherTemperatureLimit);
    
    public int getServoSpeed(int servoId);
    
    public void setServoSpeed(int servoId, int servoSpeed);
    
    public int getServoLowerPositionLimit(int servoId);
    
    public void setServoLowerPositionLimit(int servoId, int servoHigherPositionLimit);
    
    public int getServoHigherPositionLimit(int servoId);
    
    public void setServoHigherPositionLimit(int servoId, int servoHigherPositionLimit );

    public int getServoLowerVoltageLimit(int servoId);
    
    public void setServoLowerVoltageLimit(int servoId, int servoLowerVoltageLimit);
    
    public int getServoHigherVoltageLimit(int servoId);
    
    public void setServoHigherVoltageLimit(int servoId, int servoHigherVoltageLimit);
    
    public int getServoHigherTorque(int servoId);
    
    public int getServoLowerTorque(int servoId);
    
    public void setServoLowerTorque(int servoId, int servoLowerTorque);
    
    public void setServoHigherTorque(int servoId, int servoHigherTorque);
}