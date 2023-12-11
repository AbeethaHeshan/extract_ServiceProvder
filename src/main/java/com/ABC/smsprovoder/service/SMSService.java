package com.ABC.smsprovoder.service;

import com.ABC.smsprovoder.dto.MessageDTO;
import com.ABC.smsprovoder.utils.helpers.ServiceProvider;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

       public MessageDTO.Response getServiceProvider(MessageDTO messageDTO) throws Exception {

           return new MessageDTO.Response(messageDTO.getMessage(),
                   ServiceProvider.getServiceProviderForMobile(messageDTO.getMobileNumber()).name(),
                   messageDTO.getMobileNumber());
       }
}
