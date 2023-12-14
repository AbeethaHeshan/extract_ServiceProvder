package com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.impl;

import com.ABC.smsprovoder.utils.helpers.enums.ServiceProviders;
import com.ABC.smsprovoder.utils.helpers.charges.ProviderDetails;
import com.ABC.smsprovoder.utils.helpers.charges.Chargins;
import com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.CommonProvider;

/**
 * @author : Abeetha Heshan Gunathilaka <abeethaheshan400@gmail.com>
 * @Since : 12/14/2023
 **/
public class HutchProviderImpl extends ProviderDetails implements CommonProvider {


    Enum<ServiceProviders> serviceProvidersEnum = ServiceProviders.HUTCH;

    private double charge = Chargins.HUTCH_TO_HUTCH;
    private ProviderDetails providerDetails;
    public HutchProviderImpl(){
        this.providerDetails =  new ProviderDetails();
    }
    @Override
    public ProviderDetails charge(String senderServiceProvider, String reseverServiceProvider){
        if(senderServiceProvider.equals(this.serviceProvidersEnum.name())  && reseverServiceProvider.equals(this.serviceProvidersEnum.name()) ){
            providerDetails.setCharge(this.charge);
        } else if (senderServiceProvider.equals(this.serviceProvidersEnum.name()) && reseverServiceProvider.equals(ServiceProviders.DIALOG.name()) ) {
            providerDetails.setCharge(Chargins.HUTCH_TO_DIALOG);
        } else if (senderServiceProvider.equals(this.serviceProvidersEnum.name()) &&  reseverServiceProvider.equals(ServiceProviders.MOBITEL.name())) {
            providerDetails.setCharge(Chargins.HUTCH_TO_MOBITEL);
        }
        return providerDetails;
    }
}
