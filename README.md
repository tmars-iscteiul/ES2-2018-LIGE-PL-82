# ES2-2018-LIGE-PL-82
Nêmesis - Decision Support and Optimization Software

### Nêmesis presentation video:
https://youtu.be/MjpPWpRHTGA

### State-of-art:
The main features of the software are working.
The following features are still on beta version:
1. Multi-type of inputs in a process;
2. Enable restrictions to the values;
3. Auto-selection of the optimizer algorithms;
4. Output results considering R plots and Latex;
5. Administrator main configurations.

### Nêmesis Team:
* 65345 - Tiago Rodrigues - tmars@iscte-iul.pt;
* 68958 - Catarina Carriço - cdpco@iscte-iul.pt;
* 69565 - Rodolfo Arnaldo - rgnsa@iscte-iul.pt;
* 73553 - Rui Tomé - rmnte@iscte-iul.pt.


## INSTALLATION SETUP
### NodeJS - Download and Installation
Go to the URL https://nodejs.org/ and download the NodeJS software and install it.
Confirm the installation going to the commandline and typing "npm".
If the commandline returns an unknown command then go to system variables and add the npm path.

### NêmesisForm - Serving
Open a commandline and go to the path ./NêmesisWebApps/nemesis-form-app/
Type "npm install" and wait for the finish of the installation.
After the installation, type "ng serve", open your browser and go to: http://localhost:4200

### NêmesisResults - Serving
Open a commandline and go to the path ./NêmesisWebApps/nemesis-results-app/
Type "npm install" and wait for the finish of the installation.
After the installation, type "ng serve --port=4100", open your browser and go to: http://localhost:4100

### Nêmesis Spring Server - Serving
Open a commandline and in the root folder type "java -jar ESII-2018-LIGE-PL-82.jar"
