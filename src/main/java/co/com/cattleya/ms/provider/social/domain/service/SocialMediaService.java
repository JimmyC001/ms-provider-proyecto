package co.com.cattleya.ms.provider.social.domain.service;

import co.com.cattleya.ms.provider.social.domain.repository.SocialMediaRepository;
import co.com.cattleya.ms.provider.social.domain.model.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
