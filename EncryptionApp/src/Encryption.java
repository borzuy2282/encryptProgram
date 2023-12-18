import java.util.*;

public class Encryption {

    private Scanner sc;
    private Random rn;
    private ArrayList<Character> simpleList;
    private ArrayList<Character> shuffledList;
    private char ch;
    private char[] letters;

    Encryption(){
        sc = new Scanner(System.in);
        rn = new Random();
        simpleList = new ArrayList();
        shuffledList = new ArrayList();
        ch = ' ';

        newKey();
        menu();
    }

    private void menu(){
        System.out.println("Hey there!");
        System.out.println("This is your ultimate encryption program.");
        while (true){
            System.out.println();
            System.out.println("So, what will we do?");
            System.out.print("N - new key; ");
            System.out.println("G - get key");
            System.out.print("E - encrypt a word; ");
            System.out.println("D - decrypt a message");
            System.out.println("Q - quit the program");
            char answer;
            try {
                answer = Character.toUpperCase(sc.nextLine().charAt(0));
            }catch(StringIndexOutOfBoundsException s){
                System.out.println("No, no, no. You shouldn't press Enter!");
                continue;
            }

            switch (answer){
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    exit();
                    break;
                default:
                    System.out.println("Looks like you've missed something, so try again!");
            }
        }
    }
    private void newKey(){
        ch = ' ';
        simpleList.clear();
        shuffledList.clear();

        //All characters from ASCII from 32 to 126
        for (int i = 32; i < 127; i++) {
            simpleList.add(Character.valueOf(ch));
            ch++;
        }

        shuffledList = new ArrayList<>(simpleList);

        //Real key to decryption
        Collections.shuffle(shuffledList);
        System.out.println("/: New key has been generated :\\");
    }
    private void getKey(){
        System.out.println("Your key is: ");
        //All characters from ASCII from 32 to 126
        for (Character c : simpleList) {
            System.out.print(c);
        }
        System.out.println();
        for (int i = 0; i < simpleList.size(); i++) {
            System.out.print("*");
        }
        System.out.println();
        //Real key to decryption
        for(Character c : shuffledList){
            System.out.print(c);
        }
        System.out.println();
    }
    private void encrypt(){
        System.out.println("Enter a message to encrypt: ");
        String message = sc.nextLine();
        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < simpleList.size(); j++) {
                if(letters[i] == simpleList.get(j)){
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted message is: ");
        for(char c : letters){
            System.out.print(c);
        }
        System.out.println();

    }
    private void decrypt(){
        System.out.println("Enter a message to decrypt: ");
        String message = sc.nextLine();
        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < shuffledList.size(); j++) {
                if(letters[i] == shuffledList.get(j)){
                    letters[i] = simpleList.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted message is: ");
        for(char c : letters){
            System.out.print(c);
        }
        System.out.println();
    }
    private void exit(){
        System.out.println("Bye bye, friend!");
        System.exit(0);
    }
}
