package co.com.cattleya.ms.provider.phone.service.impl;

import co.com.cattleya.ms.provider.phone.Phone;
import co.com.cattleya.ms.provider.phone.repository.PhoneRepository;
import co.com.cattleya.ms.provider.phone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository repository;
    @Autowired
    public PhoneServiceImpl(PhoneRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Phone> findByProviderId(Long id) {
        return repository.findByProviderId(id);
    }
    @Override
    public Phone findPhone(Integer ext, Long number) {
        return repository.findByExtensionAndNumber(ext, number);
    }
    @Override
    public Phone savePhone(Phone phone) {
        Phone dbPhone = repository.findByExtensionAndNumber(phone.getExtension(), phone.getNumber());
        if(dbPhone == null)
            return repository.save(phone);
        return dbPhone;
    }

    @Override
    public List<Phone> findAll() {
        return repository.findAll();
    }

}
