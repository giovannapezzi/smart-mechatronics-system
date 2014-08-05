/*
 * The MIT License
 *
 * Copyright 2014 Giovanna.
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
 *
 * @author Giovanna
 */
public class ServoModule {
    public static final int SERVO_TYPE_DYNAMIXEL = 0;
    public static final int SERVO_TYPE_SMS_DRIVER = 1;
    public static final int SERVO_TYPE_HERKULEX = 2;
    
    private static final DynamixelModule dynamixelModule;
    private static final SmsDriverModule smsDriverModule;
    private static final HerkulexModule herkulexModule;
    
    private static Module module;
    
    private static final ArrayList<Integer> servos;
    
    static {
        dynamixelModule = new DynamixelModule();
        smsDriverModule = new SmsDriverModule();
        herkulexModule = new HerkulexModule();
        servos = new ArrayList<>();
    }
    
    private static void detectAvailableServos() {
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
    
    private static int getServoType(int servoId) {
        return servos.get(servoId);
    }
    
    private static void setModule(int servoType) {
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
    
    public static ArrayList<Integer> getAvailableServos() {
        detectAvailableServos();
        return servos;
    }

    public static int getServoPosition(int servoId) {
        setModule(getServoType(servoId));
        return module.getServoPosition(servoId);
    }
    
    public static void setServoPosition(int servoId, int position) {
        setModule(getServoType(servoId));
        module.setServoPosition(servoId, position);
    }
}