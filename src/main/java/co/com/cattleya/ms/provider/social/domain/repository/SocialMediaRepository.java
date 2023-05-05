package co.com.cattleya.ms.provider.social.domain.repository;

import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cattleya.ms.provider.social.domain.model.SocialMedia;


import java.util.List;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {


    SocialMedia findSocialMediaByLink ( String link );


    List<SocialMedia> findSocialMediaByProvider(Provider provide);
}
