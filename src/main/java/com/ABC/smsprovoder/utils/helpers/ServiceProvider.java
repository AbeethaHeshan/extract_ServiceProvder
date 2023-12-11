package com.ABC.smsprovoder.utils.helpers;


import com.ABC.smsprovoder.utils.helpers.enums.ServiceProviders;

public class ServiceProvider {

     public static Enum<ServiceProviders> getServiceProviderForMobile(String mobileNumber) throws Exception {
             // for 077 , 076 , 078 , 072 , 074 , 071 , 077 , 072

         String digits = mobileNumber.substring(0, 3);
         switch (digits) {
             case "077", "076", "074" -> {
                 return ServiceProviders.DIALOG;
             }
             case "071" -> {
                 return  ServiceProviders.MOBITEL;
             }
             case "078" -> {
                 return  ServiceProviders.HUTCH;
             }
             case "072" -> {
                 return  ServiceProviders.ATISELART;
             }
             case "075" -> {
                 return ServiceProviders.AIRTEL;
             }
             default -> throw new Exception("Tel number not in valid format . number should starts with 076 , 077 etc.. ");
         }

     }



}
