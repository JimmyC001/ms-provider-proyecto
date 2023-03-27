package co.com.cattleya.ms.provider.provider.service.impl;

import co.com.cattleya.ms.provider.provider.Provider;
import co.com.cattleya.ms.provider.provider.repository.ProviderRepository;
import co.com.cattleya.ms.provider.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository repository;
    @Autowired
    public ProviderServiceImpl(ProviderRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Provider> findAll() {
        return repository.findAll();
    }
    private Provider findByName(String name){
        return repository.findByName(name);
    }
    @Override
    public Provider saveProvider(Provider provider) {
        Provider dbProvider = findByName(provider.getName());
        if(dbProvider != null)
            return dbProvider;
        return repository.save(provider);
    }

    @Override
    public Provider findProvider(Long id) {
        return repository.findById(id).orElse(null);
    }
}
