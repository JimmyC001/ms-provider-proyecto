package co.com.cattleya.ms.provider.provider.domain.repository;

import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Provider findByName(String name);



}
