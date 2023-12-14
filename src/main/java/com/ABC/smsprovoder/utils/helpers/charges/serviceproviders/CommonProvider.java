package com.ABC.smsprovoder.utils.helpers.xx.serviceproviders;

import com.ABC.smsprovoder.utils.helpers.xx.ProviderDetails;

/**
 * @author : Abeetha Heshan Gunathilaka <abeethaheshan400@gmail.com>
 * @Since : 12/14/2023
 **/
public interface CommonProvider {

     ProviderDetails charge(String senderServiceProvider, String ReseverServiceProvider);
}
