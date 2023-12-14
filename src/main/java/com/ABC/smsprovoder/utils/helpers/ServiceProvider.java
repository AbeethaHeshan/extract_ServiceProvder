package com.ABC.smsprovoder.utils.helpers;


import com.ABC.smsprovoder.utils.helpers.charges.ProviderDetails;
import com.ABC.smsprovoder.utils.helpers.enums.ServiceProviders;
import com.ABC.smsprovoder.utils.helpers.charges.ProviderContext;
import com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.impl.DialogProviderImpl;
import com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.impl.HutchProviderImpl;
import com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.impl.MobitelProviderImpl;

import java.util.Arrays;

public class ServiceProvider {

     public static Enum<ServiceProviders> getServiceProviderForMobilePrefix(String mobileNumber) throws Exception {
             // for 077 , 076 , 078 , 072 , 074 , 071 , 077 , 072

         if (mobileNumber.matches(".*[^0-9].*")) {
             throw new Exception("String contains non-digit characters.");
         }else {

             String digits = mobileNumber.replaceAll("\\s", "").substring(0, 3);
             if(mobileNumber.replaceAll("\\s", "").length() == 10){
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
             }else {
                 throw new Exception("Length must be 10 characters");
             }

         }
     }



     public ProviderDetails  charges(Enum<ServiceProviders> sender , Enum<ServiceProviders>  resiver) throws Exception {
         ProviderContext providerContext = new ProviderContext();

         if (sender.equals(ServiceProviders.MOBITEL)) {

             providerContext.setProvider(new MobitelProviderImpl());
             return providerContext.charge(sender.name(), resiver.name());

         } else if (sender.equals(ServiceProviders.DIALOG)) {

             providerContext.setProvider(new DialogProviderImpl());
             return providerContext.charge(sender.name(), resiver.name());

         } else if (sender.equals(ServiceProviders.HUTCH)) {

             providerContext.setProvider(new HutchProviderImpl());
             return providerContext.charge(sender.name(), resiver.name());

         } else {
             throw new Exception("provider not found");
         }
     }
}
