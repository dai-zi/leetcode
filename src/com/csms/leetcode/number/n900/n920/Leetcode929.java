package com.csms.leetcode.number.n900.n920;

import java.util.HashSet;
import java.util.Set;

//独特的电子邮件地址
//简单
public class Leetcode929 {
public int numUniqueEmails(String[] emails) {
    Set<String> seen = new HashSet();
    for (String email : emails) {
      int i = email.indexOf('@');
      String local = email.substring(0, i);
      String rest = email.substring(i);
      if (local.contains("+")) {
        local = local.substring(0, local.indexOf('+'));
      }
      // Note: one should escape the specific character '.',
      // since it is treated as a regex expression.
      local = local.replaceAll("\\.", "");
      seen.add(local + rest);
    }

    return seen.size();
  }

    public static void main(String[] args) {
    }
}