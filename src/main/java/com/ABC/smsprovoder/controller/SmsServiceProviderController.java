package com.ABC.smsprovoder.controller;

import com.ABC.smsprovoder.dto.MessageDTO;
import com.ABC.smsprovoder.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class SmsServiceProviderController {

           @Autowired
           SMSService smsService;

           @PostMapping
           public ResponseEntity<MessageDTO.Response> getServiceProviderWithMessage(@RequestBody MessageDTO messageDTO) throws Exception {
              return ResponseEntity.ok().body(smsService.getServiceProvider(messageDTO));
           }
}
