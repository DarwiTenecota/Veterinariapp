package com.example.darwinftb.service


import com.example.darwinftb.model.Dueño
import com.example.darwinftb.repository.DueñoRepository
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class DueñoService {

    @Autowired
    lateinit var dueñoRepository: DueñoRepository

    fun list(): List<Dueño> {
        return dueñoRepository.findAll()
    }

    fun getById(id: Long?): Dueño? {
        return dueñoRepository.findById(id)
    }

    fun save(dueño: Dueño): Dueño {
        try {
            dueño.nombre?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("nombre no debe ser vacio")
            return dueñoRepository.save(dueño)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }
    fun update (dueño: Dueño): Dueño {
        dueñoRepository.findById(dueño.id) ?: throw Exception()
        return dueñoRepository.save(dueño)
    }

    fun updateName(dueño: Dueño): Dueño {
        try {

            val response = dueñoRepository.findById(dueño.id)
                    ?: throw Exception("El id ${dueño.id} en dueño no existe")
            response.apply {
                this.nombre = dueño.nombre
            }
            return dueñoRepository.save(dueño)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete(id: Long): Boolean {
        dueñoRepository.deleteById(id)
        return true
    }
}