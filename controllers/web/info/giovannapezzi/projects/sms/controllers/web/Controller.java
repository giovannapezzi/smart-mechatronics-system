package info.giovannapezzi.projects.sms.controllers.web;

import java.io.*;
import java.net.*;
import static spark.Spark.*;
import spark.*;

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
        
        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                String page = "";
                page += "<html>";
                page += "    <head>";
                page += "        <title>SMS Web Simulator</title>";
                page += "    </head>";
                page += "    <body>";
                page += "        <form action=\"/send-command\" method=\"POST\">";
                page += "            <input type=\"text\" name=\"command\" value=\"\" size=\"50\" />";
                page += "            <br />";
                page += "            <input type=\"submit\" value=\"SEND COMMAND\" />";
                page += "        </form>";
                page += "    </body>";
                page += "</html>";                
                return page;
            }
        });
        
        post(new Route("/send-command") {
            @Override
            public Object handle(Request request, Response response) {
                String command = request.queryParams("command");
                try {
                    System.out.println(command);
                    writerOfDataForServer.write(command + "\r\n");
                    writerOfDataForServer.flush();
                } catch (IOException e) {

                }
                response.redirect("/");
                return "";
            }
        });        
    }
}
