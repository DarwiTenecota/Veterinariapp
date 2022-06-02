package com.example.darwinftb.model
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
@Entity
@Table(name="mascota")

class Mascota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name: String? = null
    var edad: Long? = null
    var peso: Long? = null
    @Column(name = "veterinario_id")
    var veterinarioId:Long?=null
    @Column(name = "dueño_id")
    var dueñoId:Long?=null



}





