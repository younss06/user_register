package com.register.controller.param;

/**
 * List of all End point parameters used in the entire application.
 *
 * @author Younuss EL KASSMI
 */
public interface ResourceParameter {

  /**
   * Parameters for {@link com.register.controller.UserResource} end point
   */
  interface UserResourceParameter {

    String ID = "/{id}";
  }

}
