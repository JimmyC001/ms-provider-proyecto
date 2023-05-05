package co.com.cattleya.ms.provider.social.domain.service;

import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.social.domain.repository.SocialMediaRepository;
import co.com.cattleya.ms.provider.social.domain.model.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SocialMediaService {

    @Autowired
    private SocialMediaRepository repository;

    public SocialMedia saveSocial(SocialMedia social) {
        SocialMedia dbSocial = repository.findSocialMediaByLink(social.getLink());
        if (dbSocial == null)
            return repository.save(social);
        return dbSocial;
    }

    public List<SocialMedia> findByProvider(Provider provider ){
        return repository.findSocialMediaByProvider(provider);

    }

    public SocialMedia deleteSocialMedia(SocialMedia media){
        if(media ==  null)
            return null;
        SocialMedia dbMedia = repository.findById(media.getId()).orElse(null);
        if(dbMedia == null)
            return null;
        repository.delete(dbMedia);
        return dbMedia;
    }



}
