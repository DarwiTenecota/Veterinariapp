package com.example.darwinftb.service

import com.example.darwinftb.model.Dueño
import com.example.darwinftb.model.Veterinario
import com.example.darwinftb.repository.VeterinarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

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
        try {
            veterinario.name?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("name no debe ser vacio")
            return veterinarioRepository.save(veterinario)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun update(veterinario: Veterinario): Veterinario {
        veterinarioRepository.findById(veterinario.id) ?: Exception()
        return veterinarioRepository.save(veterinario)
    }

    fun updateName (veterinario: Veterinario): Veterinario {
        try {

            val response = veterinarioRepository.findById(veterinario.id)
                    ?: throw Exception("El id ${veterinario.id} en veterinario no existe")
            response.apply {
                this.name = veterinario.name
            }
            return veterinarioRepository.save(veterinario)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id: Long): Boolean{
         veterinarioRepository.deleteById(id)
        return true
    }
}

