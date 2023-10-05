package com.example.demo;


import com.example.demo.persistence.PetEntity;
import com.example.demo.persistence.PetMapper;
import com.example.demo.persistence.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public List<PetEntity> findPet(String name) {
        return petRepository.findByName(name);
    }

    public void savePet(String pet) {
        var petEntity = petMapper.map(pet);
        petRepository.save(petEntity);
    }
}
