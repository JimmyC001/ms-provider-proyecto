package co.com.cattleya.ms.provider.provider.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {
    private String name;
    private String description;
    private String photo;
    private String web;
}
