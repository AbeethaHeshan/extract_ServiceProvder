package com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.impl;

import com.ABC.smsprovoder.utils.helpers.enums.ServiceProviders;
import com.ABC.smsprovoder.utils.helpers.charges.ProviderDetails;
import com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.Chargins;
import com.ABC.smsprovoder.utils.helpers.charges.serviceproviders.CommonProvider;

/**
 * @author : Abeetha Heshan Gunathilaka <abeethaheshan400@gmail.com>
 * @Since : 12/14/2023
 **/
public class DialogProviderImpl implements CommonProvider {

    Enum<ServiceProviders> serviceProvidersEnum = ServiceProviders.DIALOG;
    private double charge = Chargins.DIALOG_TO_DIALOG;
    private ProviderDetails providerDetails;
    public DialogProviderImpl(){
        this.providerDetails =  new ProviderDetails();
    }

    @Override
    public ProviderDetails charge(String senderServiceProvider, String reseverServiceProvider) {

        if(senderServiceProvider.equals(this.serviceProvidersEnum.name())  && reseverServiceProvider.equals(this.serviceProvidersEnum.name()) ){
            providerDetails.setCharge(this.charge);
        } else if (senderServiceProvider.equals(this.serviceProvidersEnum.name()) && reseverServiceProvider.equals(ServiceProviders.MOBITEL.name()) ) {
            providerDetails.setCharge(Chargins.DIALOG_TO_MOBITEL);
        } else if (senderServiceProvider.equals(this.serviceProvidersEnum.name()) &&  senderServiceProvider.equals(ServiceProviders.HUTCH.name())) {
            providerDetails.setCharge(Chargins.DIALOG_TO_HUTCH);
        }
        return providerDetails;

    }
}
