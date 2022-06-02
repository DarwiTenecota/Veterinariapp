package com.example.darwinftb.repository

import com.example.darwinftb.model.Mascota
import com.example.darwinftb.model.Veterinario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface MascotaRepository: JpaRepository<Mascota,Long> {


    fun findById (id: Long?):Mascota?

    @Query(nativeQuery = true)
         fun getListName (@Param("name") name:String?) : List <Mascota>

    @Transactional
    @Modifying
    @Query(nativeQuery=true)
    fun setOtherName (@Param("name")  nombre:String?, @Param("nuevoNombre")  name: String?) : List <Mascota>?
}



