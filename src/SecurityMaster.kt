import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

class SecurityMaster(private val secretKey: String) {


    private val algorithm = "AES"

    fun encrypt(plainText: String): String {
        val keySpec = SecretKeySpec(secretKey.toByteArray(), algorithm)
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.ENCRYPT_MODE, keySpec)

        val encryptedBytes = cipher.doFinal(plainText.toByteArray())
        return Base64.getEncoder().encodeToString(encryptedBytes)
    }

    fun decrypt(encryptedText: String): String {
        val keySpec = SecretKeySpec(secretKey.toByteArray(), algorithm)
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.DECRYPT_MODE, keySpec)

        val decodedBytes = Base64.getDecoder().decode(encryptedText)
        val decryptedBytes = cipher.doFinal(decodedBytes)
        return String(decryptedBytes)
    }
}

