package at.ac.uibk.pm.g03.csbb5525.test1.e01;

//siehe Foto

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println(classifyCharacter('a'));
        System.out.println(classifyCharacter('x'));
        System.out.println(classifyCharacter('F'));
        System.out.println(classifyCharacter(' '));
        System.out.println(classifyCharacter('5'));
        System.out.println(classifyCharacter('A'));
        System.out.println(classifyCharacter('E'));
        System.out.println(classifyCharacter('I'));
        System.out.println(classifyCharacter('O'));
        System.out.println(classifyCharacter('U'));


    }

    public static String classifyCharacter(char character) {
        character = (!Character.isLetter(character)) ? '.' : character;

        return switch (character) {
            case    'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> "vowel";
            case '.' -> "other";
            default -> "consonant";
        };

    }


}

/*
//case    'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z',
            //        'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'
            //        -> "consonant";
 */