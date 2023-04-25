package co.com.cattleya.ms.provider.provider.aplication.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProviderResponse {
    private String name;
    private String description;
    private String photo;
    private String web;
}
