package com.example.administrator.apiservice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class AndroidRunable implements Runnable{
	Socket socket;
	int time;
	 public AndroidRunable(Socket socket) {
		
		this.socket=socket;
		
	}
	@Override
	public void run() {
		 // 鍚慳ndroid瀹㈡埛绔緭鍑篽ello worild  
        String line = null;  
      
        InputStream input;  
        OutputStream output;  
        String str = "hello world!";  
        try {  
            //鍚戝鎴风鍙戦?佷俊鎭?  
            output = socket.getOutputStream();  
            input = socket.getInputStream();  
            BufferedReader bff = new BufferedReader(  
                    new InputStreamReader(input));  
            output.write(str.getBytes("UTF-8"));  
            output.flush();  
            //鍗婂叧闂璼ocket    
            socket.shutdownOutput();  
            //鑾峰彇瀹㈡埛绔殑淇℃伅  
            while ((line = bff.readLine()) != null) {  
                System.out.print(line);  
            }  
            System.out.println("clicked");
            //鍏抽棴杈撳叆杈撳嚭娴?  
            output.close();  
            bff.close();  
            input.close();  
            socket.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
     
		
	}
	
}
