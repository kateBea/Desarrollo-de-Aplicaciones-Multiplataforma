/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unscramble.data

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

// Set with all the words for the Game
val allWords: Set<String> =
    setOf(
        "casa", "árbol", "coche", "sol", "luna", "estrella", "cielo", "mar",
        "río", "montaña", "camino", "libro", "ventana", "puerta", "silla",
        "mesa", "reloj", "gato", "perro", "pájaro", "flor", "fruta", "verde",
        "rojo", "azul", "blanco", "negro", "grande", "pequeño", "largo",
        "corto", "amargo", "dulce", "salado", "fresco", "caliente", "frío",
        "nuevo", "viejo", "rápido", "lento", "arriba", "abajo", "izquierda",
        "derecha", "joven", "viejo", "feliz", "triste", "rico", "pobre"
    )
