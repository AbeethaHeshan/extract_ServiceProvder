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
       String mobileNumber;
       String message;
       @Setter
       @AllArgsConstructor
       @NoArgsConstructor
       @Getter
       public static
       class Response {
              private  String message;
              private  String serviceProvider;
              private  String mobileNumber;
       }
}
