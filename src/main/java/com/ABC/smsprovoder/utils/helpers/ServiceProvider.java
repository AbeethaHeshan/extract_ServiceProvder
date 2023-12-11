package com.ABC.smsprovoder.utils.helpers;


import com.ABC.smsprovoder.utils.helpers.enums.ServiceProviders;

import java.util.Arrays;

public class ServiceProvider {

     public static Enum<ServiceProviders> getServiceProviderForMobilePrefix(String mobileNumber) throws Exception {
             // for 077 , 076 , 078 , 072 , 074 , 071 , 077 , 072

         if (mobileNumber.matches(".*[^0-9].*")) {
             throw new Exception("String contains non-digit characters.");
         }

         String digits = mobileNumber.replaceAll("\\s","").substring(0, 3);

         if (Arrays.asList(MobilePrefixes.DIALOG_PREFIXES).contains(digits)) {
             return ServiceProviders.DIALOG;
         }
         return switch (digits) {
             case MobilePrefixes.MOBITEL_PREFIX -> ServiceProviders.MOBITEL;
             case MobilePrefixes.HUTCH_PREFIX -> ServiceProviders.HUTCH;
             case MobilePrefixes.AIRTEL_PREFIX -> ServiceProviders.AIRTEL;
             case MobilePrefixes.ATISELART_PREFIX -> ServiceProviders.ATISELART;
             default -> throw new Exception("Tel number not in valid format. Number should start with 076, 077, etc.");
         };
     }



}
