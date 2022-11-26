import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Main {
    private static final String MY_PWD = "aq8fDBDFrb";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MySecurePwdGenerator mySecurePwdGenerator = new MySecurePwdGenerator();
        byte[] salt = mySecurePwdGenerator.createSalt();
        System.out.println("salt: " + mySecurePwdGenerator.byteArrayToString(salt));
        String securedSHA256SaltedPwd = mySecurePwdGenerator.getSaltedStrongPasswordWithSHA256(MY_PWD, salt);
        String securedSHA256NonSaltedPwd = mySecurePwdGenerator.getNotSaltedStrongPasswordWithSHA256(MY_PWD);
        String securedMD5SaltedPwd = mySecurePwdGenerator.getSaltedStrongPasswordWithMD5(MY_PWD, salt);
        String securedMD5NonSaltedPwd = mySecurePwdGenerator.getNotSaltedStrongPasswordWithMD5(MY_PWD);
        System.out.println("securedSHA256SaltedPwd: " + securedSHA256SaltedPwd);
        System.out.println("securedSHA256NonSaltedPwd: " + securedSHA256NonSaltedPwd);
        System.out.println("securedMD5SaltedPwd: " + securedMD5SaltedPwd);
        System.out.println("securedMD5NonSaltedPwd: " + securedMD5NonSaltedPwd);
    }


}