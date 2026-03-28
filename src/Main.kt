fun main() {
    val scanner = java.util.Scanner(System.`in`)

    // 16 ta belgi
    val mySecretKey = "1234567890123456"
    val shield = SecurityMaster(mySecretKey)

    println("🛡️ Secure Shield: Maxfiy Ma'lumotlar Himoyachisi")
    println("1. Ma'lumotni shifrlash")
    println("2. Ma'lumotni ochish (Decrypt)")
    print("Tanlov: ")

    when (scanner.nextLine()) {
        "1" -> {
            print("Shifrlash uchun matnni kiriting: ")
            val original = scanner.nextLine()
            val encrypted = shield.encrypt(original)
            println("\n🔒 Shifrlangan kod: $encrypted")
        }
        "2" -> {
            print("Shifrlangan kodni kiriting: ")
            val code = scanner.nextLine()
            try {
                val decrypted = shield.decrypt(code)
                println("\n🔓 Asl matn: $decrypted")
            } catch (e: Exception) {
                println("❌ Xato: Kalit noto'g'ri yoki kod buzilgan!")
            }
        }
        else -> println("Noma'lum buyruq.")
    }
}