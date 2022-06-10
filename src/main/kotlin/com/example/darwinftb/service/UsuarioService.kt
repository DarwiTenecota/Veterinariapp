package com.example.darwinftb.service

import com.example.darwinftb.dto.NuevoNombre
import com.example.darwinftb.dto.NuevoUsuario
import com.example.darwinftb.model.Usuario
import com.example.darwinftb.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service

class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun save (usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }

    fun updateOtherUsername (nuevoUsername: NuevoUsuario): String? {
        val rows =  usuarioRepository.setOtherUsuario (nuevoUsername.username, nuevoUsername.nuevoUsername)
        return "se cambia el usuario " + rows
    }

    fun updateOtherPassword (nuevoPassword: NuevoUsuario): String? {
        val rows =  usuarioRepository.setOtherUsuario (nuevoPassword.password, nuevoPassword.nuevoPassword)
        return "se cambia password " + rows
    }
}