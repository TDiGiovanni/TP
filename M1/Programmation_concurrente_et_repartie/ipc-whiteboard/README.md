# IPC Whiteboard
School Project: Client / Server IPC Whiteboard Application written in C++ with TCP/IP

## Description
The purpose of this whiteboard is to chat with collegues using the terminal.

Executables:

1. bin/server: manages clients connection, data transmition and coherence with IPC.

2. bin/client: connects to ongoing server, send and receive data simultaneously. Right now, the client will receive the entire chat log everytime they enter a new message.

**Remark**
The server should be running before executing clients.

## How to use
1. Compile using:
```bash
make
```
2. Execute server using:
```bash
./bin/server
```
You can leave by entering any input in the terminal.


3. Execute client using:
```bash
./bin/client
```
You can leave by entering "Quit"