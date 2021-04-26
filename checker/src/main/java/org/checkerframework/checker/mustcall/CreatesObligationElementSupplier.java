package org.checkerframework.checker.mustcall;

import javax.lang.model.element.ExecutableElement;
import org.checkerframework.dataflow.cfg.node.MethodInvocationNode;
import org.checkerframework.framework.type.GenericAnnotatedTypeFactory;
import org.checkerframework.javacutil.AnnotationUtils;

/**
 * This interface should be implemented by all type factories that can provide the ExecutableElement
 * needed to call {@link AnnotationUtils#getElementValueArray} when {@link
 * MustCallTransfer#getCreatesObligationExpressions(MethodInvocationNode,
 * GenericAnnotatedTypeFactory, CreatesObligationElementSupplier)} is called. This interface is
 * needed so any type factory with these elements can be used to call that method, not just the
 * MustCallAnnotatedTypeFactory (in particular, the consistency checker needs to be able to call
 * that method with both the ObjectConstruction/CalledMethods type factory and the MustCall type
 * factory).
 */
public interface CreatesObligationElementSupplier {

  /**
   * Returns the CreatesObligation.value field/element.
   *
   * @return the CreatesObligation.value field/element
   */
  ExecutableElement getCreatesObligationValueElement();

  /**
   * Returns the CreatesObligation.List.value field/element.
   *
   * @return the CreatesObligation.List.value field/element
   */
  ExecutableElement getCreatesObligationListValueElement();
}
