package com.ABC.smsprovoder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
       String sender;
       String resiver;
       String message;
       @Setter
       @AllArgsConstructor
       @NoArgsConstructor
       @Getter
       public static
       class Response {
              private  String status;
              private  String mobileNumber;
              private  double charges;
       }
}
