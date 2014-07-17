package com.danailbd;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Networing {
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Enumeration<NetworkInterface> network = null;
		try {
			network = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<InetAddress> networkAddrs = new ArrayList<>();

		
		InterfaceAddress inf = network.nextElement().getInterfaceAddresses().get(1);
		short prefix = inf.getNetworkPrefixLength();
		

		
		Inet4Address testAddr = null;
		
		System.out.println("Scaning ...");
		for(int z = 1 ; z<256; z+=(1<<(prefix-16))){
			for(int y = 1 ; y<256 ; y+=(1<<(prefix-24))){
				InetAddress tempAddr = testAddr.getByName("192.168." + z + "." + y);
				if(tempAddr.isReachable(60)){
					networkAddrs.add(tempAddr);
				}
			}
		}
		for(InetAddress x: networkAddrs)
			if(x instanceof Inet4Address) 
					System.out.println(x.getHostAddress());
		}


		/*
		for( InterfaceAddress x: network.nextElement().getInterfaceAddresses())
			if(x.getAddress() instanceof Inet4Address) 
					System.out.println(x.getAddress().getHostAddress());
		}
		*/
	}

