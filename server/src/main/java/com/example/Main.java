package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        do{
            String input = in.readLine();
            String input2 = in.readLine();
            String operazione = in.readLine();
            
            

            if (operazione.equals("exit")  || input.equals("exit") || input2.equals("exit")) {
                break;
            }

                try {
                    int ope = Integer.parseInt(operazione); 
                        int num1 = Integer.parseInt(input);
                        int num2 = Integer.parseInt(input2);
                        int risultato = 0;
                if (ope == 4 && input2.equals("0")) {
                    out.println("ERR-0:divided_by_zero");
                } else {
                    switch (ope) {
                        case 1: 
                            risultato = num1 + num2;
                            out.println("RISULTATO:" + risultato);
                            break;
                        case 2: 
                            risultato = num1 - num2;
                            out.println("RISULTATO:" + risultato);
                            break;
                        case 3: 
                            risultato = num1 * num2;
                            out.println("RISULTATO:" + risultato);
                            break;
                        case 4: 
                            risultato = num1 / num2;
                            out.println("RISULTATO:" + risultato);
                            break;
                        default: 
                            out.println("ERR-2:unknown_operation");
                            break;
                    }
                }
                
            } catch (NumberFormatException e) {
                out.println("ERR-1:invalid_operation_format");
            }
            
               
        }while(true);    
        
    }
}