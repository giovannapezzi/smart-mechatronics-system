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

class DynamixelModule implements Module
{
    @Override
    public int getServoPosition(int servoId) {
		dynamixel_jni.dxl_initialize();
		dynamixel_jni.dxl_set_baud(1);
        int currentPosition = dynamixel_jni.dxl_read_word(servoId, 30);
		dynamixel_jni.dxl_terminate();
        
        return currentPosition;
    }
    
    @Override
    public void setServoPosition(int servoId, int position) {
        System.out.println("sono la classe di controllo per i dynamixel");
		dynamixel_jni.dxl_initialize();
		dynamixel_jni.dxl_set_baud(1);
		dynamixel_jni.dxl_write_word(servoId, 30, position);
		dynamixel_jni.dxl_terminate();         
    }
}
