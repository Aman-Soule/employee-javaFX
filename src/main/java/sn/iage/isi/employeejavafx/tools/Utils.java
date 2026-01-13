package sn.iage.isi.employeejavafx.tools;

import org.mindrot.jbcrypt.BCrypt;

public class Utils {

    public static String hashPassword(String passwordTextPlain) {
        return BCrypt.hashpw(passwordTextPlain, BCrypt.gensalt());
    }

    public static boolean checkPassword(String passwordTextPlain, String passwordHashed) {
        return BCrypt.checkpw(passwordTextPlain, passwordHashed);
    }
}
