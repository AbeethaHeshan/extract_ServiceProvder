package com.ABC.smsprovoder.service;

import com.ABC.smsprovoder.dto.MessageDTO;
import com.ABC.smsprovoder.utils.helpers.ServiceProvider;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

       public MessageDTO.Response getServiceProvider(MessageDTO messageDTO) throws Exception {
           System.out.println("*********** message gateway ***********");
           String senderServiceProvider = ServiceProvider.getServiceProviderForMobilePrefix(messageDTO.getSender()).name();
           String resiverServiceProvider = ServiceProvider.getServiceProviderForMobilePrefix(messageDTO.getResiver()).name();
           if(!senderServiceProvider.equals(resiverServiceProvider)){
               System.out.println("Pass the message from "+ senderServiceProvider+ " To " + resiverServiceProvider);
           }
           String redColor = "\u001B[31m";
           String resetColor = "\u001B[0m";
           System.out.println("-----------------------------------------------------------------\n|"+redColor+resiverServiceProvider+"  message : "+ messageDTO.getMessage()+resetColor+"|\n-----------------------------------------------------------------");

           return new MessageDTO.Response(
                   "message send success to",
                   messageDTO.getResiver());
       }
}
