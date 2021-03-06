package com.pumapunku.pet.infrastructure.firestore;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.pumapunku.pet.domain.Pet;
import com.pumapunku.pet.domain.repository.PetRepository;

@Named
public class PetRepositoryImpl implements PetRepository
{
    @Inject
    private transient PetFirestoreRepository petRepository;

    @Override
    public Pet create(Pet pet)
    {
    	PetCollection petCollection = new PetCollection(pet.getId(), pet.getName());
        PetCollection petResult = petRepository.create(petCollection);
        pet.setId(petResult.getId());

        return pet;
    }

    @Override
    public void update(Pet pet)
    {
        petRepository.update(new PetCollection(pet.getId(), pet.getName()));
    }

    @Override
    public void delete(String id)
    {
        petRepository.delete(id);
    }

	@Override
	public List<Pet> getPets()
	{
		List<PetCollection> petCollection = petRepository.retrieveAll();
		
		return petCollection.stream().map(p->new Pet(p.getId(), p.getName())).toList();
	}
}
