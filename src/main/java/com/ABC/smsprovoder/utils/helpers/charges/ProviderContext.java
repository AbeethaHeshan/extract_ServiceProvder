package com.ABC.smsprovoder.utils.helpers.xx;

import com.ABC.smsprovoder.utils.helpers.xx.serviceproviders.CommonProvider;

/**
 * @author : Abeetha Heshan Gunathilaka <abeethaheshan400@gmail.com>
 * @Since : 12/14/2023
 **/
public class ProviderContext {
   private CommonProvider commonProvider;

   public void setProvider(CommonProvider providerStrategy){
        this.commonProvider = providerStrategy;
   }


   public ProviderDetails charge(String sender,String resiver){
       return commonProvider.charge(sender,resiver);
   }

}
