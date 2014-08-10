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
 * dynamixel_jni
 * 
 * Class written as by needs of the dynamixel_jni dll library. This class exposes camel case named methods that wrap 
 * the native methods necessary to interface with the dynamixel_jni dll library.
 * 
 * @author Giovanna Pezzi <contact@giovannapezzi.info>
 */
class dynamixel_jni
{
    /*
     * Adapted method names
     */    
    public static int initialize() {
        return dxl_initialize();
    }
    	    
    public static void terminate() {
        dxl_terminate();
    }
        
    public static int getBaud(){
        return dxl_get_baud ();
    }
    
    public static void setBaud (int baudRate) {
        dxl_set_baud (baudRate);
    }
    	
    public static int getResult() {
        return dxl_get_result();
    }

    public static void txPacket() {
        dxl_tx_packet();
    }
    	
    public static void rxPacket() {
        dxl_rx_packet();
    }
        
    public static void txRxPacket() {
        dxl_txrx_packet();
    }    
        
    public static void setTxPacketId(int id) {
        dxl_set_txpacket_id(id);
    } 
        
    public static void setTxPacketInstruction(int instruction) {
        dxl_set_txpacket_instruction(instruction);
    }  
        
    public static void setTxPacketParameter(int index, int value) {
        dxl_set_txpacket_parameter(index, value );
    }  
        
    public static void setTxPacketLength(int length) {
        dxl_set_txpacket_length(length );
    }    
    	  
    public static int getRxPacketError(int errorBit) {
        return dxl_get_rxpacket_error(errorBit);
    }   
        
    public static int getRxPacketLength() {
        return dxl_get_rxpacket_length();
    }    
  	
    public static int getRxPacketParameter(int index) {
        return dxl_get_rxpacket_parameter(index);
    }  
        
	public static int makeWord(int lowerByte, int higherByte) {
        return dxl_makeword(lowerByte, higherByte );
    }    
 	
    public static int getLowbyte(int word) {
        return dxl_get_lowbyte(word );
    }    
            
    public static int getHighbyte(int word) {
        return dxl_get_highbyte(word);
    }   
            
    public static void ping(int id) {
        dxl_ping(id);
    }    
      
    public static int readByte(int id, int address) {
        return dxl_read_byte(id, address);
    }     
    	
    public static void writeByte(int id, int address, int value) {
        dxl_write_byte(id, address, value);
    }   
        
    public static int readWord(int id, int address) {
        return dxl_read_word(id, address);
    }    
       
    public static void writeWord(int id, int address, int value) {
        dxl_write_word(id, address, value);
    }
    
    /*
     * Method names as used into the dynamixel_jni dll library
     */
    public static native int dxl_initialize();
    
    public static native void dxl_terminate();
    
    public static native int dxl_get_baud();
    
    public static native int dxl_get_result();
    
    public static native void dxl_set_baud(int baudRate);
    
    public static native void dxl_tx_packet();   
    
    public static native void dxl_rx_packet();
    
    public static native void dxl_txrx_packet();
    
    public static native void dxl_set_txpacket_id(int id);
    
    public static native void dxl_set_txpacket_instruction(int instruction);
    
    public static native void dxl_set_txpacket_parameter(int index, int value);
    
    public static native void dxl_set_txpacket_length(int length);
    
    public static native int dxl_get_rxpacket_error(int errorBit);
    
    public static native int dxl_get_rxpacket_length();
    
    public static native int dxl_get_rxpacket_parameter(int index);
    
    public static native int dxl_makeword(int lowerByte, int higherByte);
    
    public static native int dxl_get_lowbyte(int word);
    
    public static native int dxl_get_highbyte(int word);
    
    public static native void dxl_ping(int id);
    
    public static native int dxl_read_byte(int id, int address);
    
    public static native void dxl_write_byte(int id, int address, int value);
    
    public static native int dxl_read_word(int id, int address);
    
    public static native void dxl_write_word(int id, int address, int value);
	
	/*
     * Loader of the dynamixel_jni dll library
     */
    static
	{
        System.loadLibrary("dynamixel_jni");
	}
}