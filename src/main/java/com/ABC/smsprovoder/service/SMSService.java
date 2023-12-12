package com.ABC.smsprovoder.service;

import com.ABC.smsprovoder.dto.MessageDTO;
import com.ABC.smsprovoder.utils.helpers.ServiceProvider;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

       public MessageDTO.Response getServiceProvider(MessageDTO messageDTO) throws Exception {

           String serviceProvider = ServiceProvider.getServiceProviderForMobilePrefix(messageDTO.getMobileNumber()).name();

           System.out.println(serviceProvider);
           System.out.println(serviceProvider+"  message : "+ messageDTO.getMessage());
           return new MessageDTO.Response(
                   "message send success",
                   messageDTO.getMobileNumber());
       }
}
