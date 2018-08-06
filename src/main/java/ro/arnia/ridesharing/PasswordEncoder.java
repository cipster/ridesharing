package ro.arnia.ridesharing;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {
        int strength = 4;
        String password = "pass";
        System.out.println(new BCryptPasswordEncoder(strength).encode(password));
    }
}
