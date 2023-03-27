package co.com.cattleya.ms.provider.provider.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProviderRequest {
    private String name;
    private String photo;
    private String description;
    private String web;
}
