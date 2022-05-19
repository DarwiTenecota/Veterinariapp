package com.example.darwinftb.service

import com.example.darwinftb.model.Dueño
import com.example.darwinftb.model.Veterinario
import com.example.darwinftb.repository.VeterinarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class VeterinarioService {
    @Autowired
    lateinit var veterinarioRepository: VeterinarioRepository


    fun list(): List<Veterinario> {
        return veterinarioRepository.findAll()
    }

    fun getById(id: Long?): Veterinario? {
        return veterinarioRepository.findById(id)
    }

    fun save(veterinario: Veterinario): Veterinario {
        return veterinarioRepository.save(veterinario)
    }

    fun update(veterinario: Veterinario): Veterinario {
        veterinarioRepository.findById(veterinario.id) ?: Exception()
        return veterinarioRepository.save(veterinario)
    }

    fun updateName(veterinario: Veterinario): Veterinario {
        val response = veterinarioRepository.findById(veterinario.id)
                ?: throw Exception()

        response.apply {
            name = veterinario.name
        }
        return veterinarioRepository.save(response)
    }
    fun delete (id: Long): Boolean{
         veterinarioRepository.deleteById(id)
        return true
    }
}

