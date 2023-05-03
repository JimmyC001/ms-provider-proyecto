package co.com.cattleya.ms.provider.social.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cattleya.ms.provider.social.domain.model.SocialMedia;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {


    SocialMedia findSocialMediaByLink ( String link );
}
