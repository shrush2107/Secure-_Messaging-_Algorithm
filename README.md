# Secure Messaging Algorithm

This project focus on the development of the messaging algorithm that combines Huffman coding for data compression and the Diffie-Hellman algorithm for secure key exchange.

DiffieHellman.java

Two parties, Alice and Bob, perform the Diffie-Hellman key exchange to securely share encryption keys.
They exchange public values generated based on a shared prime number and generator.
They demonstrate the encryption and decryption of a message using these shared keys.
A simulation is included where an eavesdropper attempts to decrypt the message without the correct key.
Message encryption involves adding a key to ASCII codes and encoding with Huffman coding.
Message decryption reverses this process, subtracting the key and decoding with Huffman.



