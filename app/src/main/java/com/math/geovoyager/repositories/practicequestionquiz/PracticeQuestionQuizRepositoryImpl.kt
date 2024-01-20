package com.math.geovoyager.repositories.practicequestionquiz

import com.math.geovoyager.R
import com.math.geovoyager.pages.practicequestionquiz.models.AnswerData
import com.math.geovoyager.pages.practicequestionquiz.models.QuestionData

class PracticeQuestionQuizRepositoryImpl : PracticeQuestionQuizRepository {
    override fun getLOTSQuestions(): List<QuestionData> {
        val question1 = QuestionData(
            1,
            "Pilihlah definisi segitiga sama sama kaki yang benar!", listOf(
                AnswerData(
                    "Segitiga yang memiliki dua sisi dan satu sudut yang panjangnya sama.",
                    false,
                ),
                AnswerData(
                    "Segitiga yang memiliki dua sisi yang panjangnya sama dan dua sudut yang berhadapan dengan sisi tersebut juga sama besar.",
                    true
                ),
                AnswerData(
                    "Segitiga yang memiliki tiga sisi dengan panjang yang sama.",
                    false
                ),
                AnswerData(
                    "Segitiga yang memiliki tiga sudut yang besarannya sama.",
                    false
                ),
            ),
            null
        )

        val question2 = QuestionData(
            2,
            "Pernyataan yang benar mengenai sifat-sifat segitiga sama kaki adalah", listOf(
                AnswerData(
                    "Panjang dua sisi alasnya selalu berbeda",
                    false
                ),
                AnswerData(
                    "Panjang dua sisi alasnya selalu sama",
                    true
                ),
                AnswerData(
                    "Sudut-sudut yang melibatkan sisi alasnya tidak memiliki hubungan",
                    false
                ),
                AnswerData(
                    "Segitiga sama kaki tidak memiliki sifat khusus",
                    false
                ),
            ),
            null
        )

        val question3 = QuestionData(
            3,
            "Apa yang dimaksud dengan sudut lancip?", listOf(
                AnswerData(
                    "Besar kedua sudut dalamnya 90⁰",
                    false
                ),
                AnswerData(
                    "Besar salah satu sudut dalamnya 90⁰",
                    false
                ),
                AnswerData(
                    "Besar ketiga sudut dalamnya 90⁰",
                    false
                ),
                AnswerData(
                    "Besar sudut yang ukurannya kurang dari 90⁰",
                    true
                ),
            ),
            null
        )

        val question4 = QuestionData(
            4,
            "Dua segitiga siku-siku memiliki hipotenusa yang bersesuaian sama panjang dan sisi lain yang bersesuaian juga sama panjang. Apa kesimpulan yang dapat diambil?",
            listOf(
                AnswerData(
                    "Segitiga tersebut pasti kongruen",
                    true
                ),
                AnswerData(
                    "Segitiga tersebut mungkin kongruen",
                    false
                ),
                AnswerData(
                    "Tidak dapat ditentukan",
                    false
                ),
                AnswerData(
                    "Segitiga tersebut tidak kongruen",
                    false
                ),
            ),
            null
        )

        val question5 = QuestionData(
            5,
            "Apa yang dapat disimpulkan dari pernyataan bahwa segitiga sama sisi memiliki tiga sisi yang sama panjang?",
            listOf(
                AnswerData(
                    "Sudut-sudutnya pasti siku-siku",
                    true
                ),
                AnswerData(
                    "Sudut-sudutnya pasti sama besar",
                    false
                ),
                AnswerData(
                    "Segitiga tersebut pasti sama kaki",
                    false
                ),
                AnswerData(
                    "Segitiga tersebut pasti memiliki sudut sudut yang berbeda",
                    false
                ),
            ),
            null
        )

        return listOf(
            question1,
            question2,
            question3,
            question4,
            question5
        )
    }

    override fun getMOTSQuestions(): List<QuestionData> {
        val question1 = QuestionData(
            1,
            "Jika dalam segitiga sama kaki diketahui salah satu sudut alasnya adalah 60 derajat, berapakah besar sudut alas yang lain?",
            listOf(
                AnswerData(
                    "30⁰",
                    true
                ),
                AnswerData(
                    "60⁰",
                    false
                ),
                AnswerData(
                    "90⁰",
                    false
                ),
                AnswerData(
                    "120⁰",
                    false
                ),
            ),
            null
        )

        val question2 = QuestionData(
            2,
            "Pernyataan: Jika dua sudut bersesuaian (berkorespondensi) sama besar, maka garis yang melalui sudut-sudut tersebut sejajar.\n\n" +
                    "Konvers: Jika suatu garis memotong dua garis yang sejajar, maka sudut-sudut yang terbentuk bersesuaian (berkorespondensi) sama besar.\n\n" +
                    "Pilihlah jawaban yang benar menurut pernyataan dan konvers tersebut!",
            listOf(
                AnswerData(
                    "Benar, karena kedua pernyataan memiliki hubungan yang sesuai.",
                    true
                ),
                AnswerData(
                    "Benar, tapi perlu syarat tambahan.",
                    false
                ),
                AnswerData(
                    "Salah, karena konversnya tidak benar.",
                    false
                ),
                AnswerData(
                    "Salah, karena kedua pernyataan tidak memiliki hubungan yang sesuai.",
                    false
                ),
            ),
            null
        )

        val question3 = QuestionData(
            3,
            "Berdasarkan gambar dibawah ini besar sudut C adalah ...", listOf(
                AnswerData(
                    "30⁰",
                    false
                ),
                AnswerData(
                    "60⁰",
                    false
                ),
                AnswerData(
                    "90⁰",
                    true
                ),
                AnswerData(
                    "120⁰",
                    false
                ),
            ),
            R.drawable.img_question_mots_3
        )

        val question4 = QuestionData(
            4,
            "Sebuah pagar berbentuk segitiga siku-siku dengan panjang alas 6 m dan tinggi 8 m. Berapakah panjang garis miring (hipotenusa)?",
            listOf(
                AnswerData(
                    "10 m",
                    true
                ),
                AnswerData(
                    "15 m",
                    false
                ),
                AnswerData(
                    "16 m",
                    false
                ),
                AnswerData(
                    "20 m",
                    false
                ),
            ),
            null
        )

        val question5 = QuestionData(
            5,
            "Perhatikan gambar dan pernyataan berikut!\n\n" +
                    "Titik A dihubungkan ke titik E. Dari asumsi di ΔABE dan ΔADE,\n\n" +
                    "① ∠ABE = ∠ADE = 90⁰\n" +
                    "② AB = AD\n" +
                    "③ AE sisi persekutuan\n\n" +
                    "Dari (1), (2), (3) dan aturan kekongruenan dua sudut siku-siku, maka ΔABE ≅ ΔADE, jadi BE =….",
            listOf(
                AnswerData(
                    "DE",
                    true
                ),
                AnswerData(
                    "EC",
                    false
                ),
                AnswerData(
                    "AE",
                    false
                ),
                AnswerData(
                    "AD",
                    false
                ),
            ),
            R.drawable.img_question_mots_5
        )

        return listOf(
            question1,
            question2,
            question3,
            question4,
            question5
        )
    }

    override fun getHOTSQuestions(): List<QuestionData> {
        val question1 = QuestionData(
            1,
            "Segitiga ABC adalah segitiga sama kaki kongruen dengan segitiga PQR, dengan AB = PR. Jika sudut B = sudut R adalah 40° , berapakah besar sudut C?",
            listOf(
                AnswerData(
                    "40°",
                    true,
                ),
                AnswerData(
                    "60°",
                    false,
                ),
                AnswerData(
                    "80°",
                    false
                ),
                AnswerData(
                    "90°",
                    false
                ),
            ),
            null
        )

        val question2 = QuestionData(
            2,
            "Di suatu kota, terdapat dua menara yang memiliki bentuk segitiga sama kaki dan kongruen. Menara pertama, Menara A, memiliki panjang alas dan tinggi masing-masing sepanjang 20 meter. Menara kedua, Menara P, memiliki panjang sisi alas dan tinggi yang sama dengan Menara A. Jika sudut kemiringan Menara A adalah 55°, berapakah besar sudut kemiringan Menara P?",
            listOf(
                AnswerData(
                    "35°",
                    false
                ),
                AnswerData(
                    "55°",
                    true
                ),
                AnswerData(
                    "70°",
                    false
                ),
                AnswerData(
                    "110°",
                    false
                ),
            ),
            null
        )

        val question3 = QuestionData(
            3,
            "Pada segitiga siku-siku EFG jika panjang EF = 6cm, FG = 8cm, dan sudut F adalah 90°. Berapakah panjang sisi EG?",
            listOf(
                AnswerData(
                    "8 cm",
                    false
                ),
                AnswerData(
                    "10 cm",
                    true
                ),
                AnswerData(
                    "12 cm",
                    false
                ),
                AnswerData(
                    "15 cm",
                    false
                ),
            ),
            null
        )

        val question4 = QuestionData(
            4,
            "Sebuah tangga diletakkan di depan sebuah tembok. Panjang tangga tersebut adalah 25 meter, dan bagian bawah tangga berjarak 7 meter dari tembok. Berapakah tinggi tembok tersebut yang dijangkau oleh tangga?",
            listOf(
                AnswerData(
                    "15 m",
                    false
                ),
                AnswerData(
                    "18 m",
                    false
                ),
                AnswerData(
                    "24 m",
                    true
                ),
                AnswerData(
                    "25 m",
                    false
                ),
            ),
            null
        )

        val question5 = QuestionData(
            5,
            "Terdapat satu segitiga sama sisi ABC. Panjang sisi AB adalah 12cm. Kemudian dari titik A ditarik garis memotong tepat ditengah sisi BC yang diberi nama titik O. Berapakah panjang sisi BO? ",
            listOf(
                AnswerData(
                    "4",
                    false
                ),
                AnswerData(
                    "6",
                    true
                ),
                AnswerData(
                    "8",
                    false
                ),
                AnswerData(
                    "12",
                    false
                ),
            ),
            null
        )

        return listOf(
            question1,
            question2,
            question3,
            question4,
            question5
        )
    }
}