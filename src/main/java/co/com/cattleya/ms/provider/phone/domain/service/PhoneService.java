package co.com.cattleya.ms.provider.phone.domain.service;

import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.phone.domain.repository.PhoneRepository;

import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository repository;


    public List<Phone> findByProviderId(Long id ){
        return repository.findByProviderId(id);

    }
    public Phone findPhone(Integer ext, Long number) {
        return repository.findByExtensionAndNumber(ext, number);
    }

    public Phone deletePhone(Phone phone){
        if(phone ==  null)
            return null;
        Phone dbPhone = repository.findById(phone.getId()).orElse(null);
        if(dbPhone == null)
            return null;
        repository.delete(phone);
        return dbPhone;
    }
     
    public Phone savePhone(Phone phone) {
        Phone dbPhone = repository.findByExtensionAndNumber(phone.getExtension(), phone.getNumber());
        if(dbPhone == null)
            return repository.save(phone);
        return dbPhone;
    }

     
    public List<Phone> findAll() {
        return repository.findAll();
    }

}
