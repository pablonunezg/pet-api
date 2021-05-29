package com.pumapunku.pet.api.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PetRequest
{
    private String id;
    private String name;
}