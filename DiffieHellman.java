import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;

public class DiffieHellman {

  private BigInteger p; // prime number
  private BigInteger g; // generator
  private BigInteger secret; // private secret of this party
  private BigInteger publicValue; // public value to be shared with other party
  private static Map<Character, String> codeMap;

  public DiffieHellman(int numBits) {
    SecureRandom rand = new SecureRandom();
    this.p = new BigInteger("23"); // set prime number to 23
    this.g = new BigInteger("2"); // set generator to 2
    this.secret = new BigInteger(numBits, rand); // generate a random secret key
    this.publicValue = g.modPow(secret, p); // calculate the public key X & Y
  }

  public BigInteger getPublicValue() {
    return publicValue;
  }

  public BigInteger getSharedSecret(BigInteger otherPublicValue) {
    return otherPublicValue.modPow(secret, p);
  }

  public static void main(String[] args) {
    DiffieHellman alice = new DiffieHellman(512);
    DiffieHellman bob = new DiffieHellman(512);

    BigInteger alicePublicValue = alice.getPublicValue();
    BigInteger bobPublicValue = bob.getPublicValue();

    BigInteger aliceSharedSecret = alice.getSharedSecret(bobPublicValue);
    BigInteger bobSharedSecret = bob.getSharedSecret(alicePublicValue);

    System.out.println("Public Value p:" + alice.p);
    System.out.println("Public Value g:" + alice.g);
    separator();

    // STEP 1: Alice and Bob exchange their public values
    System.out.println("STEP 1: Alice and Bob share their public values: ");
    System.out.println("Alice public value(X): " + alicePublicValue);
    System.out.println("Bob public value(Y): " + bobPublicValue);
    separator();

    // STEP 2: Sending the string message
    String message = "Hello !!!";
    System.out.println("STEP 2: Message being sent: " + message);
    separator();
    // STEP 3: Key generation and encryption
    // use the first 256 bits of the shared secret as the AES key
    BigInteger aliceAesKey = aliceSharedSecret.mod(BigInteger.valueOf(256));
    System.out.println("STEP 3: Key generation and encryption");
    System.out.println("AES Key for Alice: " + aliceAesKey);
    String encrypted = encrypt(message, aliceAesKey);
    separator();
    // STEP 4: Decoding the message using Diffie-Hellman
    BigInteger bobAesKey = bobSharedSecret.mod(BigInteger.valueOf(256));
    System.out.println("STEP 4: Decoding the message using Diffie-Hellman");
    System.out.println("AES Key for Bob: " + bobAesKey);
    String decrypted = decrypt(encrypted, bobAesKey);
    System.out.println("Diffie-Hellman Decrypted message: " + decrypted);
    separator();

    // STEP 5: What if the eavesdropper is viewing and doesn't have the right key:
    System.out.println("What if the eavesdropper is viewing and doesn't have the right key:");
    BigInteger eavesDropperAes = new BigInteger("123");
    System.out.println("Imagine eavesdropper chooses a random key and chooses to decrypt the message using the key: " + eavesDropperAes);
    String failedDecryption = decrypt(encrypted, eavesDropperAes);
    System.out.println("Eavesdropper message: " + failedDecryption);

  }

  public static String encrypt(String message, BigInteger key) {
    String encrypted = "";
    for (int i = 0; i < message.length(); i++) {
      int c = message.charAt(i) + key.intValue(); // add the key to the ASCII code of each character
      encrypted += (char) c;
    }

    System.out.println("The encrypted message is: " + encrypted);

    codeMap = HuffmanCoding.encode(encrypted);

    String encoded = "";
    for (char c : encrypted.toCharArray()) {
      encoded += codeMap.get(c);
    }
    System.out.println("Huffman encoded message: " + encoded);
    return encoded;
  }

  public static String decrypt(String message, BigInteger key) {
    String decrypted = "";

    message = HuffmanCoding.decode(message, codeMap);

    System.out.println("Huffman decoded message: " + message);

    for (int i = 0; i < message.length(); i++) {
      int c = message.charAt(i) - key.intValue(); // subtract the key from the ASCII code of each character
      decrypted += (char) c;
    }
    return decrypted;
  }

  // private functions
  private static void separator(){
    System.out.println("=================================");
  }
}