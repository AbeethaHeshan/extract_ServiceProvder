package com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.impl;

import com.ABC.smsprovoder.utils.helpers.enums.ServiceProviders;
import com.ABC.smsprovoder.utils.helpers.charges.ProviderDetails;
import com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.Chargins;
import com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.CommonProvider;

/**
 * @author : Abeetha Heshan Gunathilaka <abeethaheshan400@gmail.com>
 * @Since : 12/14/2023
 **/
public class MobitelProviderImpl extends ProviderDetails implements CommonProvider {

    Enum<ServiceProviders> serviceProvidersEnum = ServiceProviders.MOBITEL;
    private double charge = Chargins.MOBITEL_TO_MOBITEL;
    private ProviderDetails providerDetails;
    public MobitelProviderImpl(){
        this.providerDetails =  new ProviderDetails();
    }
    @Override
    public ProviderDetails charge(String senderServiceProvider, String reseverServiceProvider) {
        if(senderServiceProvider.equals(this.serviceProvidersEnum.name())  && reseverServiceProvider.equals(this.serviceProvidersEnum.name()) ){
             providerDetails.setCharge(this.charge);
        } else if (senderServiceProvider.equals(this.serviceProvidersEnum.name()) && reseverServiceProvider.equals(ServiceProviders.DIALOG.name()) ) {
             providerDetails.setCharge(Chargins.MOBITEL_TO_DIALOG);
        } else if (senderServiceProvider.equals(this.serviceProvidersEnum.name()) &&  senderServiceProvider.equals(ServiceProviders.HUTCH.name())) {
             providerDetails.setCharge(Chargins.MOBITEL_TO_HUTCH);
        }
        return providerDetails;
    }
}
