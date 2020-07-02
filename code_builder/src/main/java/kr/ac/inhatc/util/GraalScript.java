package kr.ac.inhatc.util;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public final class GraalScript {
  public static String runScript(String type, String code) throws Exception {
    Context context = Context.newBuilder().allowIO(true).build();
    Value result = context.eval(type, code);
    return result.toString();
  }
}