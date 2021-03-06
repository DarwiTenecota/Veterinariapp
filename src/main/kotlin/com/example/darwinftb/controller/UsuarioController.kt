package com.example.darwinftb.controller
import com.example.darwinftb.dto.NuevoNombre
import com.example.darwinftb.dto.NuevoUsuario
import com.example.darwinftb.model.Usuario
import com.example.darwinftb.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario")

class UsuarioController {
    @Autowired
    lateinit var usuarioService: UsuarioService

    @PostMapping
    fun save (@RequestBody usuario: Usuario): Usuario{
        return usuarioService.save(usuario)

    }
    @PostMapping ("/change/username")
    fun updateOtherUsername (@RequestBody nuevoUsername: NuevoUsuario): String? {
        return usuarioService.updateOtherUsername (nuevoUsername)
    }

    @PostMapping ("/change/password")
    fun updateOtherPassword (@RequestBody nuevoPassword: NuevoUsuario): String? {
        return usuarioService.updateOtherPassword (nuevoPassword)
    }

}