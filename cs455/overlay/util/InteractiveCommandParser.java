package cs455.overlay.util;

/*
 *Author: Tiger Barras
 *InteractiveCommandParser.java
 *Parses the commands for nodes
 */

import cs455.overlay.node.Node;
import cs455.overlay.node.Registry;
import cs455.overlay.node.MessageNode;

import java.util.Scanner;

public class InteractiveCommandParser{

	Registry registry;
	int flag;//Lets the parser know whether it's parsing for a MessageNode or a Registry
				//Zero for Register, one for MessageNode

	public InteractiveCommandParser(Registry r, int f){
		registry = r;
		flag = f;

		if(flag == 0){
			this.registryListen();
		}else if(flag == 1){
			//Do stuff for messagingNode
		}else{
			System.out.println("InteractiveCommandParser: Error, flag must be zero or one");
			System.exit(-1);
		}

	}//End constructor

	public void registryListen(){
		System.out.println("Starting command parser");
		Scanner sc = new Scanner(System.in);

		String input;

		while(true){//Just sit in this loop and listen for input
			System.out.print(">> ");
			input = sc.next();
			parseRegistry(input);
		}
	}//End listen

	public void parseRegistry(String input){
		switch(input){
			//Registry commands
			case "list-messaging-nodes":
					this.registry.listMessagingNodes();
					break;
			default:
					System.out.println("Not a valid command");
		}
	}//End parseRegistry

	public void parseMessageNode(String input){

	}//End parseMessageNode



}