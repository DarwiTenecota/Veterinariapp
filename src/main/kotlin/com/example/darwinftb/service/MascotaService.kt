package com.example.darwinftb.service

import com.example.darwinftb.dto.NuevoNombre
import com.example.darwinftb.model.Dueño
import com.example.darwinftb.model.Mascota
import com.example.darwinftb.repository.MascotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
@Service

class MascotaService {
    
    @Autowired
    lateinit var mascotaRepository: MascotaRepository

    fun list (): List<Mascota>{
        return mascotaRepository.findAll()
    }
    fun getById(id: Long?): Mascota? {
        return mascotaRepository.findById(id)
    }
    fun save(mascota: Mascota):Mascota {
        try {
            mascota.name?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Nombre no debe ser vacio")

            mascotaRepository.findById(mascota.id)
                    ?: throw Exception("El departamento no exits")

            return mascotaRepository.save(mascota)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun update (mascota: Mascota):Mascota {
            try {
                mascota.name?.takeIf { it.trim().isNotEmpty() }
                        ?: throw Exception("Nombre no debe ser vacio")
                return mascotaRepository.save(mascota)
            } catch (ex: Exception) {
                throw ResponseStatusException(
                        HttpStatus.NOT_FOUND, ex.message, ex)

            }
        }
    fun updateOtherName (nuevoNombre:NuevoNombre): Boolean??{
         mascotaRepository.setOtherName(nuevoNombre.name, nuevoNombre.nuevoNombre)
        return true
    }

    fun updateName (mascota: Mascota): Mascota {
        try {

            val response = mascotaRepository.findById(mascota.id)
                    ?: throw Exception("El id ${mascota.id} en docente no existe")
            response.apply {
                this.name = mascota.name
            }
            return mascotaRepository.save(mascota)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        mascotaRepository.deleteById(id)
        return true
    }
    fun getByName(name: String?):List<Mascota>?{
        return mascotaRepository.getListName(name)
    }
}


