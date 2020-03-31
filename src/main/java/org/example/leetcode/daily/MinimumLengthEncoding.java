package org.example.leetcode.daily;

import java.util.*;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/3/28 20:55
 */
public class MinimumLengthEncoding {
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
        System.out.println(minimumLengthEncodingV1(words));
    }


    public static int minimumLengthEncodingV1(String[] words) {
        TrieNode trieNode = new TrieNode();
        Map<TrieNode, Integer> nodeMap = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = trieNode;
            for (int j = word.length() - 1; j >= 0; j--) {
                cur = cur.get(word.charAt(j));
            }
            nodeMap.put(cur, i);
        }

        int res = 0;
        for (Map.Entry<TrieNode, Integer> entry : nodeMap.entrySet()) {
            TrieNode node = entry.getKey();
            if (node.count == 0) {
                res += words[entry.getValue()].length() + 1;
            }
        }
        return res;
    }

    public static int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        int len = 0;
        for (String word : set) {
            len += word.length() + 1;
        }
        return len;
    }

    public static class TrieNode {
        private TrieNode[] children;
        int count;

        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }
}
