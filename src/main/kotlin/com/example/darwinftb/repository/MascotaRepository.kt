package com.example.darwinftb.repository

import com.example.darwinftb.model.Mascota
import com.example.darwinftb.model.Veterinario
import org.springframework.data.jpa.repository.JpaRepository
interface MascotaRepository: JpaRepository<Mascota,Long> {


    fun findById (id: Long?):Mascota?
}



