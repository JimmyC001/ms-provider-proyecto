package co.com.cattleya.ms.provider.phone.repository;

import co.com.cattleya.ms.provider.phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByProviderId(Long id);
    Phone findByExtensionAndNumber(Integer ext, Long number);
}
