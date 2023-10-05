package com.example.demo;


import com.example.demo.persistence.PetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping("/greeting")
    public ResponseEntity<PetEntity> getPet(@RequestBody RequestPet name) {
        var pets = petService.findPet(name.getName());
       if (pets.size() > 0) {
           return ResponseEntity.ok(pets.get(0));
       }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/pet")
    public ResponseEntity<Void> postPet(@RequestBody String name) {
        petService.savePet(name);

        return ResponseEntity.ok().build();
    }


}
