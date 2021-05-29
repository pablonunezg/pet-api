package com.pumapunku.pet.infrastructure.firestore;

import javax.inject.Named;

import com.google.cloud.firestore.Firestore;

@Named
public class PetFirestoreRepository extends AbstractFirestoreRepository<PetCollection>
{
    protected PetFirestoreRepository(Firestore firestore)
    {
        super(PetCollection.class, firestore, "pet");
    }
}