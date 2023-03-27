package co.com.cattleya.ms.provider.social.service.impl;

import co.com.cattleya.ms.provider.social.repository.SocialMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SocialMediaServiceImpl {
    private final SocialMediaRepository repository;
    @Autowired
    public SocialMediaServiceImpl(SocialMediaRepository repository){
        this.repository = repository;
    }
}
