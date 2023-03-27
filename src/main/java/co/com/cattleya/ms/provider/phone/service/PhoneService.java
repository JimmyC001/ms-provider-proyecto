package co.com.cattleya.ms.provider.phone.service;

import co.com.cattleya.ms.provider.phone.Phone;
import java.util.List;

public interface PhoneService {
    List<Phone> findByProviderId(Long id);
    List<Phone> findAll();
    Phone findPhone(Integer ext, Long number);
    Phone savePhone(Phone phone);
}
