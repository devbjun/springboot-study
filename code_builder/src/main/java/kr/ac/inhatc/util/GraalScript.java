package kr.ac.inhatc.util;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public final class GraalScript {
  public static String runScript(String code) {
    try {
      Context context = Context.create("js");
      Value result = context.eval("js", code);
      return result.toString();
    }
    catch (Exception e) {
      return e.toString();
    }
  }
}