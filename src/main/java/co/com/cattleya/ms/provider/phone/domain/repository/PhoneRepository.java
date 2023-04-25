package co.com.cattleya.ms.provider.phone.domain.repository;

import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByProviderId(Long id);

    Phone findByExtensionAndNumber(Integer ext, Long number);

    void deleteByIdaAndProvider(Long aLong);



    void deletePhoneByIdAndProvider(Long id , Provider provider);
}