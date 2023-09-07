# Secure Messaging Algorithm

This project focus on the development of the messaging algorithm that combines Huffman coding for data compression and the Diffie-Hellman algorithm for secure key exchange.

## Contents

1. [Overview](#overview)
2. [Diffie-Hellman Key Exchange](#diffie-hellman-key-exchange)
3. [Huffman Coding](#huffman-coding)
4. [Usage](#usage)
5. [Dependencies](#dependencies)


## Overview

This Java program consists of two main components:

- **DiffieHellman.java**: Implements the Diffie-Hellman key exchange algorithm, allowing two parties to securely generate a shared secret key.
- **HuffmanCoding.java**: Implements the Huffman coding algorithm for text compression and decompression.

## Diffie-Hellman Key Exchange

The Diffie-Hellman key exchange algorithm is used to securely exchange secret keys over an unsecured communication channel. It includes the following steps:

1. Two parties, Alice and Bob exchange public values generated based on a shared prime number and generator.
2. They demonstrate the encryption and decryption of a message using these shared keys.
3. A simulation is included where an eavesdropper attempts to decrypt the message without the correct key.
4. Message encryption involves adding a key to ASCII codes.
5. Message decryption reverses this process, subtracting the key.

## Huffman Coding

Huffman coding is a lossless data compression algorithm. It includes the following steps:

1. Calculate the frequency of each character in the input text.
2. Build a Huffman tree using the character frequencies.
3. Generate binary codes for each character based on the tree.
4. Encode the input text using the generated Huffman codes.
5. Decode the encoded text to recover the original input text.

## Usage

To use this program, follow these steps:

1. Compile the Java files:
   ```
   javac DiffieHellman.java HuffmanCoding.java
   ```

2. Run the program:
   ```
   java DiffieHellman
   ```

The program will perform the following steps:

1. Generate Diffie-Hellman public and private keys for Alice and Bob.
2. Exchange public keys between Alice and Bob.
3. Encrypt and decrypt a sample message using the shared secret key.
4. Demonstrate how an eavesdropper without the correct key cannot decrypt the message.

## Dependencies

This program uses the Java standard library and does not require any external dependencies.

