package com.lilhui.leecode.trie;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/08/06 22:24
 */
public class Trie {

   private Trie[] children;

   private boolean isEnd;

   public Trie() {
      //初始化26个字母
      children = new Trie[26];
      //默认为不是最后一个字母
      isEnd = false;
   }

   public void insert(String word) {
      //得到字典树根节点
      Trie node = this;
      //去遍历待插入单词的字符集合
      for (int i = 0; i < word.length(); i ++) {
         char ch = word.charAt(i);
         //得到该字符再数组中的坐标
         int index = ch - 'a';
         if (node.children[index] == null) {
            //如果正在遍历该字母上一个节点的数组坐标中没有记录，新建一个母节点在字典树中
            node.children[index] = new Trie();
         }
         //每次生成字幕都移动指针到下一个字母节点
         node = node.children[index];
      }
      //之后一个字母节点设置为最后一个字母
      node.isEnd = true;
   }

   public boolean search(String word) {
      //返回检索到的最后一个字母节点
      Trie node = searchPrefix(word);
      //只有当该单词再字典树中存在并且最后一个字母节点为最后一个字母，才返回true
      return node != null && node.isEnd;
   }

   public boolean startWith(String prefix) {
      //只要前缀匹配存在于字典树中就返回true
      return searchPrefix(prefix) != null;
   }

   //前缀检索 还是 全文检索都是调用此方法，区别在于前缀检索只要前缀匹配就返回true,
   //全文检索则要匹配到最后一个字母才返回true，所以这里返回的是最后一个字母节点
   private Trie searchPrefix(String prefix) {
      //得到字典树根节点
      Trie node = this;
      //开始验证字符串在字典树中是否存在
      for (int i = 0; i < prefix.length(); i ++) {
         char ch = prefix.charAt(i);
         //得到该字符串在数组中的坐标
         int index = ch - 'a';
         //如果改字符再数组中存在，就移动到下一个
         if (node.children[index] == null) {
            return null;
         }
         node = node.children[index];
      }
      //如果没有问题，那就是到达了最后一个待搜索的最后一个字母
      return node;
   }

   public static void main(String[] args) {
      Trie trie = new Trie();
      String word = "apple";
      String word2 = "appleT";
      trie.insert(word);
      trie.insert(word2);
      System.out.println(trie.startWith("app"));
   }

}
