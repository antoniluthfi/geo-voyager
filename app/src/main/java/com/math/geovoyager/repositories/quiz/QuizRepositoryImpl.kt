package com.math.geovoyager.repositories.quiz

import com.math.geovoyager.R
import com.math.geovoyager.pages.quiz.models.AnswerData
import com.math.geovoyager.pages.quiz.models.QuizData

class QuizRepositoryImpl : QuizRepository {
    override fun getQuestions(): List<QuizData> {
        val question1 = QuizData(
            1,
            "Pada segitiga sama kaki ABC, dengan sudut puncak  A = 36°, buatlah garis bagi ∠B  dan misalkan D titik potong  dengan sisi AC. Jawablah pertanyaan berikut...",
            listOf(
                AnswerData("70°", false),
                AnswerData("71°", false),
                AnswerData("72°", true),
                AnswerData("73°", false),
            ),
            R.drawable.img_question_quiz_1
        )

        val question2 = QuizData(
            2,
            "Perhatikan gambar Segitiga ABD kongruen dengan segitiga BAC karena memenuhi syarat .....",
            listOf(
                AnswerData("Sisi, Sudut, Sisi", true),
                AnswerData("Sisi, Sisi, Sisi", false),
                AnswerData("Sisi, Sisi, Sudut", false),
                AnswerData("Sudut, Sudut, Sisi", false),
            ),
            R.drawable.img_question_quiz_2
        )

        val question3 = QuizData(
            3,
            "Segitiga ABC kongruen dengan segitiga POT Pasangan sudut yang sama besar adalah....",
            listOf(
                AnswerData("∠BAC = ∠POT", false),
                AnswerData("∠BAC = ∠PTO", false),
                AnswerData("∠ABC = ∠POT", true),
                AnswerData("∠ABC = ∠PTO", false),
            ),
            R.drawable.img_question_quiz_3
        )

        val question4 = QuizData(
            4,
            "Suatu segitiga samakaki memiliki sepasang sisi yang sama panjang, yaitu 5 cm. Jika panjang sisi yang tidak sama panjang adalah 6 cm, dan tinggi segitiga terhadap sisi tersebut adalah 4 cm. Hitung keliling dan luas segitiga tersebut.",
            listOf(
                AnswerData("11 cm2", false),
                AnswerData("12 cm2", true),
                AnswerData("13 cm2", false),
                AnswerData("14 cm2", false),
            ),
            null
        )

        val question5 = QuizData(
            5,
            "Dua segitiga pada gambar di bawah adalah kongruen. Pasangan sisi yang sama panjang adalah",
            listOf(
                AnswerData("AB dan EC", false),
                AnswerData("AD dan BE", false),
                AnswerData("AC dan CD", true),
                AnswerData("BC dan CD", false),
            ),
            R.drawable.img_question_quiz_5
        )

        val question6 = QuizData(
            6,
            "Diketahui alas segitiga siku-siku adalah 5 m dan tinggi segitiga 12 m. Berapakah sisi miring atau hipotenusa (c)...",
            listOf(
                AnswerData("12,5 m", false),
                AnswerData("13 m", true),
                AnswerData("13,5 m", false),
                AnswerData("14 m", false),
            ),
            null
        )

        val question7 = QuizData(
            7,
            "Panjang hipotenusa sebuah segitiga siku-siku sama kaki adalah 18 cm panjang kaki-kaki segitiga tersebut adalah...",
            listOf(
                AnswerData("9 akar 2", true),
                AnswerData("9 akar 3", false),
                AnswerData("9 akar 4", false),
                AnswerData("9 akar 5", false),
            ),
            null
        )

        val question8 = QuizData(
            8,
            "Panjang hipotenusa sebuah segitiga siku-siku sama kaki adalah 16 cm, dan panjang kaki-kakinya x cm. Hitunglah x...",
            listOf(
                AnswerData("8 akar 8", false),
                AnswerData("8 akar 2", true),
                AnswerData("8 akar 4", false),
                AnswerData("8 akar 6", false),
            ),
            R.drawable.img_question_quiz_8
        )

        val question9 = QuizData(
            9,
            "Pada gambar di bawah, segitiga ABC kongruen dengan segitiga BEF . Panjang EF ....",
            listOf(
                AnswerData("5 cm", false),
                AnswerData("6 cm", false),
                AnswerData("6,5 cm", false),
                AnswerData("7 cm", true),
            ),
            R.drawable.img_question_quiz_9
        )

        val question10 = QuizData(
            10,
            "Hitunglah nilai sisi p dari segitiga tersebut...",
            listOf(
                AnswerData("39, 5 cm", false),
                AnswerData("40 cm", true),
                AnswerData("40, 5 cm", false),
                AnswerData("41, 5 cm", false),
            ),
            R.drawable.img_question_quiz_10
        )

        return listOf(
            question1,
            question2,
            question3,
            question4,
            question5,
            question6,
            question7,
            question8,
            question9,
            question10,
        )
    }
}