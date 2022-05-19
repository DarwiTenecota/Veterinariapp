package com.example.darwinftb.service

import com.example.darwinftb.model.Dueño
import com.example.darwinftb.model.Mascota
import com.example.darwinftb.repository.MascotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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
    fun save (mascota: Mascota):Mascota {
        return mascotaRepository.save(mascota)
    }
    fun update(mascota: Mascota):Mascota{
        mascotaRepository.findById(mascota.id)?:Exception()
        return mascotaRepository.save(mascota)
    }
    fun updateName(mascota: Mascota):Mascota {
        val response = mascotaRepository.findById(mascota.id)
                ?: throw Exception()
        response.apply {
            edad=mascota.edad
        }
        return mascotaRepository.save(mascota)
    }
    fun delete (id: Long):Boolean{
        mascotaRepository.findById(id)
        return true
    }

}
