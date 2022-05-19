package com.example.darwinftb.service


import com.example.darwinftb.model.Dueño
import com.example.darwinftb.repository.DueñoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class DueñoService {

    @Autowired
    lateinit var dueñoRepository: DueñoRepository

    fun list ():List<Dueño>{
        return dueñoRepository.findAll()
    }

    fun getById (id: Long?): Dueño? {
        return dueñoRepository.findById(id)
    }

    fun save (dueño: Dueño): Dueño {
        return  dueñoRepository.save(dueño)
    }

    fun update (dueño: Dueño): Dueño{
        dueñoRepository.findById(dueño.id) ?: throw Exception ()
        return dueñoRepository.save(dueño)
    }

    fun updateName (dueño: Dueño): Dueño {
        val response = dueñoRepository.findById(dueño.id)
                ?: throw Exception ()

        response.apply {
            nombre = dueño.nombre
        }

        return dueñoRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        dueñoRepository.deleteById(id)
        return true
    }
}