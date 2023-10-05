package com.example.demo.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(imports = UUID.class)
public interface PetMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "name", source = "name")
    PetEntity map(String name);
}
