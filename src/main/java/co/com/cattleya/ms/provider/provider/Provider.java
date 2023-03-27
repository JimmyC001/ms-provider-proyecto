package co.com.cattleya.ms.provider.provider;

import co.com.cattleya.ms.provider.phone.Phone;
import co.com.cattleya.ms.provider.social.SocialMedia;
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
    @OneToMany(mappedBy = "provider")
    private List<Phone> phones;
    @OneToMany(mappedBy = "provider")
    private List<SocialMedia> social;
}
