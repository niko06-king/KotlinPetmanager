package com.example.kotlinpetmanager.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlinpetmanager.model.Paciente

class PacienteViewModel : ViewModel() {

    private val _pacientes = mutableStateListOf<Paciente>()
    val pacientes: List<Paciente> get() = _pacientes

    var nombre by mutableStateOf("")
        private set

    var especie by mutableStateOf("")
        private set

    var edad by mutableStateOf("")
        private set

    var esUrgencia by mutableStateOf(false)
        private set

    fun onNombreChange(nuevoNombre: String) { nombre = nuevoNombre }
    fun onEspecieChange(nuevaEspecie: String) { especie = nuevaEspecie }
    fun onEdadChange(nuevaEdad: String) { edad = nuevaEdad }
    fun onUrgenciaChange(nuevaUrgencia: Boolean) { esUrgencia = nuevaUrgencia }

    fun agregarPaciente(): Boolean {
        val edadInt = edad.toIntOrNull()
        if (nombre.isNotBlank() && especie.isNotBlank() && edadInt != null && edadInt >= 0) {
            val nuevoPaciente = Paciente(
                id = _pacientes.size + 1,
                nombre = nombre.trim(),
                especie = especie.trim(),
                edad = edadInt,
                esUrgencia = esUrgencia
            )
            _pacientes.add(nuevoPaciente)
            limpiarFormulario()
            return true
        }
        return false
    }

    fun limpiarFormulario() {
        nombre = ""
        especie = ""
        edad = ""
        esUrgencia = false
    }
}