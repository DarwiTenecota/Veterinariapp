package com.example.darwinftb.repository

import com.example.darwinftb.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface UsuarioRepository: JpaRepository<Usuario,Long> {
    fun findById (id:Long?): Usuario?

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    fun setOtherUsuario (@Param("username") username: String?, @Param("nuevoUsername") nuevoUsername: String?): Int?


}