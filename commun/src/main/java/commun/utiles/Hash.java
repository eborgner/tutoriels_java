package commun.utiles;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import commun.debogage.J;

public class Hash {

    private static MessageDigest sha1;

    static {
        try {

            sha1 = MessageDigest.getInstance("SHA-1");

        } catch (NoSuchAlgorithmException e) {

            J.valeurs("[FATAL] impossible d'instantier SHA-1");
            System.exit(0);

        }
    }

    public static String hash(String entree) {

        sha1.update(entree.getBytes());

        return versHex(sha1.digest());
    }

    private static String versHex(final byte[] hash){

        String resultat;

        Formatter formatter = new Formatter();

        for (byte b : hash) {
            formatter.format("%02x", b);
        }

        resultat = formatter.toString();
        formatter.close();

        return resultat;
    }

}
