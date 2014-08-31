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

package info.giovannapezzi.projects.sms.controllers.custom;

import java.io.*;
import java.net.*;

public class ExampleController {
    private static Socket socket;
    private static BufferedReader readerOfDataFromServer;
    private static BufferedWriter writerOfDataForServer;
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress host = InetAddress.getLocalHost();
        socket = new Socket(host.getHostName(), 55555);
        
        InputStream inputStreamFromServer = socket.getInputStream();
        readerOfDataFromServer = new BufferedReader(new InputStreamReader(inputStreamFromServer));   
        
        OutputStream outputStreamForServer = socket.getOutputStream();
        writerOfDataForServer = new BufferedWriter(new OutputStreamWriter(outputStreamForServer));
    }
    
    private static void sendCommand(String command) {
        try {
            System.out.println(command);
            writerOfDataForServer.write(command + "\r\n");
            writerOfDataForServer.flush();
        } catch (IOException e) {
            
        }
    }
}
