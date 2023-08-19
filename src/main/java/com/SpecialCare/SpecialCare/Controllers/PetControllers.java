package com.SpecialCare.SpecialCare.Controllers;


import com.SpecialCare.SpecialCare.models.Pet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetControllers {

    @RequestMapping(value = "pet/{id}")
    public Pet getUsuario(@PathVariable Long id){
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName("Luna");
        pet.setPet_tipe("Perro");
        pet.setBirthday_date("02/03/2023");
        pet.setAge("12");
        pet.setGender("macho");

       return pet;
    }
    @RequestMapping(value = "pets")
    public List<Pet> getpets(){
        List<Pet> pets = new ArrayList<>();
        Pet pet = new Pet();
        pet.setId(123l);
        pet.setName("Luna");
        pet.setPet_tipe("Perro");
        pet.setBirthday_date("02/03/2023");
        pet.setAge("12");
        pet.setGender("macho");

        Pet pet2 = new Pet();
        pet2.setId(123l);
        pet2.setName("Luna");
        pet2.setPet_tipe("Perro");
        pet2.setBirthday_date("02/03/2023");
        pet2.setAge("12");
        pet2.setGender("macho");

        Pet pet3 = new Pet();
        pet3.setId(123l);
        pet3.setName("Luna");
        pet3.setPet_tipe("Perro");
        pet3.setBirthday_date("02/03/2023");
        pet3.setAge("12");
        pet3.setGender("macho");

        pets.add(pet);
        pets.add(pet2);
        pets.add(pet3);

        return pets;
    }
    @RequestMapping(value = "petEdit")
    public Pet edit(){
        Pet pet = new Pet();
        pet.setId(123l);
        pet.setName("Luna");
        pet.setPet_tipe("Perro");
        pet.setBirthday_date("02/03/2023");
        pet.setAge("12");
        pet.setGender("macho");
        return pet;
    }
    @RequestMapping(value = "petDetele")
    public Pet delete(){
        Pet pet = new Pet();
        pet.setId(123l);
        pet.setName("Luna");
        pet.setPet_tipe("Perro");
        pet.setBirthday_date("02/03/2023");;
        pet.setAge("12");
        pet.setGender("macho");
        return pet;
    }
    @RequestMapping(value = "petSearch")
    public Pet search(){
        Pet pet = new Pet();
        pet.setId(123l);
        pet.setName("Luna");
        pet.setPet_tipe("Perro");
        pet.setBirthday_date("02/03/2023");;
        pet.setAge("12");
        pet.setGender("macho");
        return pet;
    }
}
