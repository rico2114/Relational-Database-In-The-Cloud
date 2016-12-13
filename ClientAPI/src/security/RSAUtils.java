package security;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sebastían on 12/12/2016.
 * This class is a static class used for RSA encryption between the Distribution Server and the Client
 */
public class RSAUtils {

    /**
     * Represents the logger used for the RSA
     */
    private static final Logger LOGGER = Logger.getLogger(RSAUtils.class.getName());

    /**
     * Represents the algorithm used in this class
     */
    private static final String ALGORITHM_NAME = "RSA";

    /**
     * Privatises the following class to avoid instantiation of this class
     * All the class methods are static and public
     */
    private RSAUtils() { }

    /**
     * Generates a {@link KeyPair keyPair} if possible used for the RSA algorithm
     * @return  null if the algorithm couldn't be found otherwise the key pair
     */
    public static KeyPair generateKeyPairs() {
        try {
            return KeyPairGenerator.getInstance(ALGORITHM_NAME).generateKeyPair();
        } catch (NoSuchAlgorithmException exception) {
            LOGGER.log(Level.SEVERE, exception.toString(), exception);
        }
        return null;
    }

    /**
     * Attempts to return a {@link Cipher cipher} based on the algorithm key
     * @return  null if no cipher was found otherwise the cipher
     */
    public static Cipher getCipher() {
        try {
            return Cipher.getInstance(ALGORITHM_NAME);
        } catch (NoSuchAlgorithmException exception) {
            LOGGER.log(Level.SEVERE, exception.toString(), exception);
        } catch (NoSuchPaddingException exception) {
            LOGGER.log(Level.SEVERE, exception.toString(), exception);
        }
        return null;
    }
}
