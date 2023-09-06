import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HuffmanCoding {

  private static class HuffmanNode {
    char c;
    int freq;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char c, int freq) {
      this.c = c;
      this.freq = freq;
    }
  }

  public static Map<Character, String> encode(String input) {
    // Step 1: Calculate frequency of each character
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : input.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    // Step 2: Build Huffman tree
    PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));
    for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
      pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
    }
    while (pq.size() > 1) {
      HuffmanNode left = pq.poll();
      HuffmanNode right = pq.poll();
      HuffmanNode parent = new HuffmanNode('\0', left.freq + right.freq);
      parent.left = left;
      parent.right = right;
      pq.offer(parent);
    }
    HuffmanNode root = pq.poll();

    // Step 3: Generate codes for each character
    Map<Character, String> codeMap = new HashMap<>();
    generateCode(root, "", codeMap);

    return codeMap;
  }

  private static void generateCode(HuffmanNode node, String code, Map<Character, String> codeMap) {
    if (node == null) {
      return;
    }
    if (node.c != '\0') {
      codeMap.put(node.c, code);
    }
    generateCode(node.left, code + "0", codeMap);
    generateCode(node.right, code + "1", codeMap);
  }

  public static String decode(String encodedText, Map<Character, String> codeMap) {
    StringBuilder decoded = new StringBuilder();
    StringBuilder currCode = new StringBuilder();
    for (int i = 0; i < encodedText.length(); i++) {
      char c = encodedText.charAt(i);
      currCode.append(c);
      for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
        if (entry.getValue().equals(currCode.toString())) {
          decoded.append(entry.getKey());
          currCode = new StringBuilder();
          break;
        }
      }
    }
    return decoded.toString();
  }

  public static void main(String[] args) {
    String input = "ÑÎÕÕØ©ñøĀ©êûî©Ăøþ©íøò÷ð·©Ýñòü©òü©öĂ©öîüüêðî";
    Map<Character, String> codeMap = encode(input);
    System.out.println("Huffman codes:");
    for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
    String encoded = "";
    for (char c : input.toCharArray()) {
      encoded += codeMap.get(c);
    }
    System.out.println("Encoded text: " + encoded);

    String decoded = decode(encoded, codeMap);
    System.out.println("Decoded text: " + decoded);
  }

}