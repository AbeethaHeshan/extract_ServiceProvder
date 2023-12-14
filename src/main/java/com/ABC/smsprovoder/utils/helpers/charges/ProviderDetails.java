package com.ABC.smsprovoder.utils.helpers.charges;

import com.ABC.smsprovoder.utils.helpers.enums.ServiceProviders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : Abeetha Heshan Gunathilaka <abeethaheshan400@gmail.com>
 * @Since : 12/14/2023
 **/

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDetails {
     double charge;
     Enum<ServiceProviders> provider;
}
