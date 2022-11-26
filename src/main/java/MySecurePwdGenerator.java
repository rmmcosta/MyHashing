import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MySecurePwdGenerator {
    public byte[] createSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public String getSaltedStrongPasswordWithSHA256(String plainPassword, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(salt);
        byte[] byteStrongPwd = messageDigest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));
        return byteArrayToString(byteStrongPwd);
    }

    public String getNotSaltedStrongPasswordWithSHA256(String plainPassword) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] byteStrongPwd = messageDigest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));
        return byteArrayToString(byteStrongPwd);
    }

    public String getSaltedStrongPasswordWithMD5(String plainPassword, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(salt);
        byte[] byteStrongPwd = messageDigest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));
        return byteArrayToString(byteStrongPwd);
    }

    public String getNotSaltedStrongPasswordWithMD5(String plainPassword) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] byteStrongPwd = messageDigest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));
        return byteArrayToString(byteStrongPwd);
    }

    public String byteArrayToString(byte[] bytes) {
        return DatatypeConverter.printBase64Binary(bytes);
    }
}
