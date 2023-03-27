package co.com.cattleya.ms.provider.social.repository;

import co.com.cattleya.ms.provider.social.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> { }
