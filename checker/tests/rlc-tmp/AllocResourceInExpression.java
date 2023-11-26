import java.io.*;
import org.checkerframework.checker.calledmethods.qual.*;

class AllocResourceInExpression {

  //  static void testCase1() {
  //    new Resource().close();
  //  }
  //
  //  static void testCase2() {
  //    alloc().close();
  //  }

  static void testCase3() {
    new Resource().free();
  }

  //  static void testCase4() {
  //    alloc().free();
  //  }
  //
  //  static void testCase5() {
  //    close(new Resource());
  //  }
  //
  //  static void testCase6() {
  //    close(alloc());
  //  }
  //
  //  class TestCase7 {
  //    @EnsuresCalledMethods(value = "#1", methods = "close")
  //    TestCase7(Resource r) {
  //      r.close();
  //    }
  //
  //    TestCase7() {
  //      this(new Resource());
  //    }
  //  }

  static class Resource implements Closeable {
    @Override
    public void close() {}

    @EnsuresCalledMethods(value = "this", methods = "close")
    public void free() {
      close();
    }
  }

  static Resource alloc() {
    return new Resource();
  }

  @EnsuresCalledMethods(value = "#1", methods = "close")
  static void close(Resource r) {
    r.close();
  }
}
