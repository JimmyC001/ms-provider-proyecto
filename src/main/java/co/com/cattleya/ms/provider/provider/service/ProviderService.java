package co.com.cattleya.ms.provider.provider.service;

import co.com.cattleya.ms.provider.provider.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> findAll();
    Provider saveProvider(Provider provider);
    Provider findProvider(Long id);
}
