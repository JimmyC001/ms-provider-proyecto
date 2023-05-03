package co.com.cattleya.ms.provider.provider.domain.model;

import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.social.domain.model.SocialMedia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String photo;
    private String description;
    private String web;
    private Boolean status;
    @OneToMany(mappedBy = "provider")
    private List<Phone> phones;
    @OneToMany(mappedBy = "provider")
    private List<SocialMedia> social;
}
