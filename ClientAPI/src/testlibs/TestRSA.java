package testlibs;

import java.security.*;

/**
 * Created by Sebastían on 13/12/2016.
 */
public class TestRSA {

    public static void main(String[] args) throws Exception {
        // Initialize public and private key per user and create a signature with my private key
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
        keyGen.initialize(512, new SecureRandom());
        KeyPair keyPair = keyGen.generateKeyPair();
        Signature signature = Signature.getInstance("SHA1withRSA", "BC");
        signature.initSign(keyPair.getPrivate(), new SecureRandom());
        // In this step i should send the public key to the user

        // SERVER SIDE
        // Write the message to the signature and grab the sign
        byte[] message = "abc".getBytes();
        signature.update(message);
        byte[] sigBytes = signature.sign();

        // Init verification with the public key from the client (CLIENT SIDE)
        signature = Signature.getInstance("SHA1withRSA", "BC");
        signature.initVerify(keyPair.getPublic());
        signature.update(message);
        System.out.println(signature.verify(sigBytes));
    }
}
