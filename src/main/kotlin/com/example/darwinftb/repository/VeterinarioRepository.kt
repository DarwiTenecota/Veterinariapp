package com.example.darwinftb.repository

import com.example.darwinftb.model.Veterinario
import org.springframework.data.jpa.repository.JpaRepository

interface VeterinarioRepository: JpaRepository<Veterinario,Long> {


    fun findById (id:Long?):Veterinario?

}
