package com.pumapunku.pet.api.request;


import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PetRequest
{
    private String id;
    
    @NotEmpty
    private String name;
}
