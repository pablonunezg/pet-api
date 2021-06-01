package com.pumapunku.pet.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PetRequest
{
    private String id;
    private String name;
}