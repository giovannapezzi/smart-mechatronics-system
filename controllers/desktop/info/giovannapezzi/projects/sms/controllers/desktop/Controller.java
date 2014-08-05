package info.giovannapezzi.projects.sms.controllers.desktop;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller {
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
        
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 400);
        frame.setLayout(new FlowLayout());
        
        final JTextField textField = new JTextField("", 30);
        frame.add(textField);
        
        JButton button = new JButton("SEND COMMAND");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendCommand(textField.getText());
            }
        });
        frame.add(button);
        
        JComboBox selector = new JComboBox(new String[]{ "1", "2", "3", "4", "5" });
        frame.add(selector);
        
        JSlider slider = new JSlider(300, 800);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sendCommand("SET SERVO " + selector.getSelectedItem().toString() + " POSITION TO " + slider.getValue());
            }
        });        
        frame.add(slider);
        
        frame.setVisible(true);
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