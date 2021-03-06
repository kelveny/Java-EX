package cn.xdean.jex.reflect;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReferenceUtilTest {
  @Test
  public void testReference() throws Exception {
    A a = new A();
    a.b = new B();
    a.b.c = Arrays.asList(new C());
    a.b.c.get(0).d = new D[] { new D() };
    assertTrue(ReferenceUtil.isReferencing(a, a.b.c.get(0).d[0]));
    assertFalse(ReferenceUtil.isReferencing(a, new D()));
  }

  static class A {
    B b;
  }

  static class B {
    List<C> c;
  }

  static class C {
    D[] d;
  }

  static class D {

  }
}
