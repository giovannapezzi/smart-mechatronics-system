## Smart Mechatronics System (SMS)

An integrated solution to allow Mechatronics developers to simply interact with Servos and Sensors, of different types and companies, as well as to simulate them. 

SMS is based on the socket messages model and every component in the project is runnable on separated hardware that communicates with others through the Ethernet or Wi-Fi networks. 

SMS is thought to be compatible with different hardware thanks to its architecture of Modules and Drivers that allows to develop specific systems, that are able to interconnect with external proprietary solutions or embedded firmwares for the most famous prototyping boards, while completely abstracting this activity from the user point of view.



## Milestone 1

1) Finishing the Router component with integration of a new dynamixel JNI compatible dll that supports a Java class under the project namespace as well as supporting other servo types.

2) Writing documentation for the usage of the system under the GitHub Wiki and standard README.md files as well as more Example Controllers.

3) Creation of a Maven configuration for automatic libraries download.

4) Initialization of the Desktop controller component (a system for manual control of servos and sensors through a convenient desktop application).

5) Initialization of the Web controller component (a system for manual control of servos and sensors through a convenient web application that is runnable from embedded devices with few resources).

6) Initialization of the Simulator Component (a system to see Servos and Sensors in action without necessarely having them).

7) Adding support of sensors acquisition.

8) Initialization of the first Drivers for prototyping boards like Arduino, Raspberry Pi and PCDuino.



## Copyright and License

Code and Documentation Copyright (c) 2014 Giovanna Pezzi - Code released under the [MIT license](LICENSE). Documentation released under the Creative Commons license.