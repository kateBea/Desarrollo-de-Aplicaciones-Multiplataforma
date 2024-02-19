package com.example.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.unscramble.data.SCORE_INCREASE

/**
 * ViewModel con la lógica del juego
 * La varible de estado **userGuess** sirve para la palabra introducida por el usuario.
 * La propiedad uistate mantiene el estado con la ayuda de GameUIState
 *
 */
class GameViewModel : ViewModel() {
    var userGuess by mutableStateOf("")
        private set

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()

    init {
        resetGame()
    }

    /**
     *  Se llama recursivamente hasta que se saca una palabra no usada
     *  Que se barajan las letras
     */
    private fun pickRandomWordAndShuffle(): String {
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)){
            return pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    /**
     * Barajamos las letras de la palabra y nos aseguramos
     * que al barajarla no obtenemos la misma
     */
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(word)){
            tempWord.shuffle()
        }
        return String(tempWord)
    }
    fun resetGame(){
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    // Usado por el UI para actualizar el viewmodel
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    /**
     * El usuario a introducido la palabra. Se comprueba y se actualiza
     * a vacio el campo de entrada
     */
    fun checkUserGuess(){
        if (userGuess.equals(currentWord)){
            // acerto la palabra,
            // actualizamos marcador
            val nuevoMarcador = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(nuevoMarcador)
        } else {
            // palabra incorrecta
            _uiState.update { estadoActual ->
                estadoActual.copy(isGuessedWordWrong = true)
            }
        }

        updateUserGuess("")
    }

    /**
     * _uiState es un StateFlow que admite el método update{}
     */
    private fun updateGameState(updatedScore: Int) {

        if( usedWords.size == MAX_NO_OF_WORDS){
            _uiState.update {currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true

                )

            }
        }else {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentWordCount = currentState.currentWordCount.inc(),
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    score = updatedScore
                )
            }
        }
    }

    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }

} // de la clase
