package co.com.cattleya.ms.provider.provider.domain.service;

import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.domain.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderService  {
    private final ProviderRepository repository;

    public ProviderService(ProviderRepository repository){
        this.repository = repository;
    }

    public List<Provider> findAll() {
        return repository.findAll();
    }
    private Provider findByName(String name){
        return repository.findByName(name);
    }

    public Provider saveProvider(Provider provider) {
        Provider dbProvider = findByName(provider.getName());
        if(dbProvider != null)
            return dbProvider;
        return repository.save(provider);
    }


    public Provider findProvider(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Provider deleteProvider(Provider provider) {
        Provider dbProvider = findByName(provider.getName());

        if(dbProvider != null){
            dbProvider.setStatus(false);
            return repository.save(dbProvider);
        }
        return null;
    }

    public Provider updateProvider(Provider provider) {
        Provider dbProvider = findByName(provider.getName());

        if(dbProvider != null){

            dbProvider.setName(provider.getName());
            dbProvider.setPhoto(provider.getPhoto());
            dbProvider.setDescription(provider.getDescription());
            dbProvider.setWeb(provider.getWeb());
            dbProvider.setStatus(provider.getStatus());
            return repository.save(dbProvider);
        }
        return null;

    }

    public Phone deleteProviderPhone (Provider provider, Long id){
        List <Phone> phones = new ArrayList<>();
        Phone phdelete = null;
        for (Phone phone: provider.getPhones()) {
            if(phone.getId().compareTo(id)!=0){
                phones.add(phone);
            }
            else {
                System.out.println(phone.getNumber());
                phdelete = phone;
                //phone.setProvider(null);
            }

        }
        provider.setPhones(phones);
        repository.save(provider);
        return phdelete;
    }
}
