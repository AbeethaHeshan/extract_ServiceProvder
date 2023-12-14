package com.ABC.smsprovoder.service;

import com.ABC.smsprovoder.dto.MessageDTO;
import com.ABC.smsprovoder.utils.helpers.ServiceProvider;
import com.ABC.smsprovoder.utils.helpers.charges.ProviderDetails;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

       public MessageDTO.Response getServiceProvider(MessageDTO messageDTO) throws Exception {
           System.out.println("*********** message gateway ***********");
           String senderServiceProvider = ServiceProvider.getServiceProviderForMobilePrefix(messageDTO.getSender()).name();
           String resiverServiceProvider = ServiceProvider.getServiceProviderForMobilePrefix(messageDTO.getResiver()).name();

           ServiceProvider serviceProvider = new ServiceProvider();
           ProviderDetails charges = serviceProvider.charges(ServiceProvider.getServiceProviderForMobilePrefix(messageDTO.getSender()), ServiceProvider.getServiceProviderForMobilePrefix(messageDTO.getResiver()));

           String redColor = "\u001B[31m";
           String resetColor = "\u001B[0m";

           System.out.println("*********** sending ***********");
           if(!senderServiceProvider.equals(resiverServiceProvider)){
               System.out.println(redColor+"send the message from "+ senderServiceProvider + " To " + resiverServiceProvider + " charges : Rs "+charges.getCharge()+resetColor);
           }else{
               System.out.println(redColor+"send the message from "+ senderServiceProvider + " To " + resiverServiceProvider + " charges : Rs "+charges.getCharge()+resetColor);
           }
           System.out.println("*********** ... ***********");

           return new MessageDTO.Response(
                   "message send success to",
                   messageDTO.getResiver());
       }
}
