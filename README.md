# Secure Messaging Algorithm

This project focus on the development of the messaging algorithm that combines Huffman coding for data compression and the Diffie-Hellman algorithm for secure key exchange.

### DiffieHellman.java

In this file:

1. Two parties, Alice and Bob, perform the Diffie-Hellman key exchange to securely share encryption keys.

2. They exchange public values generated based on a shared prime number and generator.

3. They demonstrate the encryption and decryption of a message using these shared keys.

4. A simulation is included where an eavesdropper attempts to decrypt the message without the correct key.

5. Message encryption involves adding a key to ASCII codes and encoding with Huffman coding.

6. Message decryption reverses this process, subtracting the key and decoding with Huffman.

### HuffmanCoding.java

In this Java file:

1. A Huffman coding algorithm is implemented for text compression and decompression.

2. It defines a `HuffmanNode` class to represent nodes in the Huffman tree, with character and frequency attributes.

3. The encode method:
   - Calculates the frequency of each character in the input text.
   - Constructs a Huffman tree based on character frequencies.
   - Generates a mapping of characters to Huffman codes.

4. The generateCode method recursively generates Huffman codes for characters in the tree.

5. The decode method:
   - Takes an encoded text and the character-to-code mapping.
   - Decodes the text based on the Huffman codes.

6. In the main method:
   - A sample input text is provided.
   - Huffman codes are generated for the characters in the input text.
   - The input text is encoded using the generated codes.
   - The encoded text is then decoded back to the original text.

The file demonstrates how Huffman coding can be used for efficient text compression and decompression, reducing the size of the encoded text while preserving its content.
